import enigma.console.TextAttributes;
import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

public class Editor {
    public enigma.console.Console cn = Enigma.getConsole("CENG Editor", 100, 30, 20, 3); // col,row,fontsize,font type
    public enigma.console.TextWindow cnt = cn.getTextWindow();
    public static TextAttributes att0 = new TextAttributes(Color.white, Color.black);  //foreground, background color
    public static TextAttributes att1 = new TextAttributes(Color.black, Color.white);
    public TextMouseListener tmlis;
    public KeyListener klis;

    // ------ Standard variables for keyboard and mouse 2 --------------------------
    public int mousepr;          // mouse pressed?
    public int mousex, mousey;   // mouse text coords.
    public int keypr;   // key pressed?
    public int rkey;    // key   (for press/release)
    public int rkeymod;      // key modifiers
    public int capslock = 0;   // 0:off    1:on
    // -----------------------------------------------------------------------------


   public int[] read(MultiLinkedList mll) throws FileNotFoundException {   //READ FROM THE TXT FILE AND STORE IN MLL
       File input = new File("src/input.txt");
       Scanner scanner = new Scanner(input);
       int category_counter = 1;
       int line_counter=1;
       mll.addCategory(category_counter,line_counter);
       int x=1;
       int y=1;
       int[] counters=new int[2];
       while (scanner.hasNextLine()) {
           String temp = scanner.nextLine();
           if (temp.equals("") ) {
               category_counter++;
               line_counter++;
               mll.addCategory(category_counter,line_counter);
           }
           for (int j = 0; j < temp.length(); j++) {
               mll.addItem(category_counter, temp.charAt(j),x,y);
               x++;
               if (x==61){
                   x=1;
                   y++;
               }
           }
           if(temp.length()>=60)
               line_counter+=temp.length()/60;
           if(!temp.equals("")){
               category_counter++;
               line_counter++;
               mll.addCategory(category_counter,line_counter);
           }
       }
       mll.removeCategory(category_counter);
       category_counter--;
       line_counter--;
       counters[0]=category_counter;
       counters[1]=line_counter;
       return counters;
   }

    public void write(MultiLinkedList mll) throws IOException {   //WRITE TO THE TXT FILE FROM MLL
        Writer wr = new FileWriter("src/input.txt");
        wr.write(mll.returnAllItems());
        wr.flush();
        wr.close();
    }

    public Object[] find(String word, MultiLinkedList mll){     //Find Method
       char firstLetter=word.charAt(0);
       char lastLetter=word.charAt(word.length()-1);
       int length=mll.returnAllItems().length();
       Object[] positions=new Object[1200];
       int count=1;     //This counter is increased when find is done

        for (int i = 1; i <=length ; i++) {
            String selected="";
            int startX=0;
            int startY=0;
            int endX=0;
            int endY=0;

            if (String.valueOf(mll.getItemById(i)).equalsIgnoreCase(String.valueOf(firstLetter)) &&
                    String.valueOf(mll.getItemById(i+word.length()-1)).equalsIgnoreCase(String.valueOf(lastLetter))){
                startX=mll.getItemXById(i);
                startY=mll.getItemYById(i);
                endX=startX+(word.length());
                if (endX==61){
                    endY=startY+1;
                }else {
                    endY=startY;

                }

                selected=selectionForFind(mll,startX,startY,endX,endY,selected);
                if (selected.equalsIgnoreCase(word)){

                    positions[count]=startX;
                    positions[count+1]=startY;
                    positions[count+2]=endX;
                    positions[count+3]=endY;
                    count+=4;
                    i+=(word.length()-1);
                }
            }
        }
        return positions;
    }

    //Selection Method
    public String selection(MultiLinkedList mll, int startX, int startY, int endX, int endY, String selected) {

        int px = startX;
        int endLoop = (endY - startY + 1) * 60 - startX - (60 - endX);
        int counter = startY;
        for (int i = 1; i <= endLoop; i++) {
            selected += mll.findPosition(px, counter);
            cn.getTextWindow().setCursorPosition(px, counter);
            cn.getTextWindow().output(mll.findPosition(px, counter), new TextAttributes(Color.black, Color.yellow));
            px++;
            if (px == 61) {
                px = 1;
                counter++;
            }
            if (endY!=startY && counter - 1 == endY - startY + 1)
                break;
        }

        return selected;
    }

    //Replace Method
    public void replace(MultiLinkedList mll, int startX, int startY, int endX, int endY, String replaced) {

        int px = startX;
        int endLoop = (endY - startY + 1) * 60 - startX - (60 - endX);
        int counter = startY;
        for (int i = 1; i <= endLoop; i++) {
            mll.getItemToEdit(px,replaced.charAt(i-1));
            px++;
            if (px == 61) {
                px = 1;
                counter++;
            }
            if (endY!=startY && counter - 1 == endY - startY + 1)
                break;
        }
    }

    //This method is used for doing selections of FIND Method
    public String selectionForFind(MultiLinkedList mll, int startX, int startY, int endX, int endY, String selected) {

        int px = startX;
        int endLoop = (endY - startY + 1) * 60 - startX - (60 - endX);
        int counter = startY;
        for (int i = 1; i <= endLoop; i++) {
            selected += mll.findPosition(px, counter);
            cn.getTextWindow().setCursorPosition(px, counter);
            cn.getTextWindow().output(mll.findPosition(px, counter), new TextAttributes(Color.black, Color.green));
            px++;
            if (px == 61) {
                px = 1;
                counter++;
            }
            if (endY!=startY && counter - 1 == endY - startY + 1)
                break;

        }

        return selected;
    }

    //Cut Method
    public String cut(MultiLinkedList mll, int startX, int startY, int endX, int endY) {
        String cut = "";
        int px = startX;
        int endLoop = (endY - startY + 1) * 60 - startX - (60 - endX);
        int counter = startY;

        for (int i = 1; i <= endLoop; i++) {
            cut += mll.findPosition(px, counter);

            mll.deleteByPosition(true, px, counter);
            px++;
            if (px == 61) {
                px = 1;
                counter++;
            }
            if (counter - 1 == endY - startY + 1)
                break;

        }
        return cut;

    }

    //Paste Method
    public void paste(MultiLinkedList mll, String copied, int line_counter, int px, int py) {

        for (int i = 0; i < copied.length(); i++) {
            mll.addItem(line_counter, copied.charAt(i), px, py);
            px++;
            if (px == 61) {
                px = 1;
                py++;
            }
        }
    }

    //Clear the screen
    public void print_board() throws FileNotFoundException {
        char[][] board = new char[22][62];
        File file = new File("src/editorBoard.txt");
        Scanner scanner = new Scanner(file);
        int ii = 0;
        while (scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            for (int j = 0; j < temp.length(); j++) {
                board[ii][j] = temp.charAt(j);
            }
            ii++;
        }

        for (int j = 0; j < board.length; j++) {
            for (int k = 0; k < board[j].length; k++) {
                cn.getTextWindow().output(board[j][k], new TextAttributes(new Color(1, 1, 10), Color.white));
            }
            System.out.println();
        }
    }
    // --------------------------------------------------------------------------


    Editor() throws Exception {   // --- Constructor

        // ------ Standard code for keyboard and mouse 2 -------- Do not change -----
        tmlis = new TextMouseListener() {
            public void mouseClicked(TextMouseEvent arg0) {
            }

            public void mousePressed(TextMouseEvent arg0) {
                if (mousepr == 0) {
                    mousepr = 1;
                    mousex = arg0.getX();
                    mousey = arg0.getY();
                }
            }

            public void mouseReleased(TextMouseEvent arg0) {
            }
        };
        cn.getTextWindow().addTextMouseListener(tmlis);

        klis = new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if (keypr == 0) {
                    keypr = 1;
                    rkey = e.getKeyCode();
                    rkeymod = e.getModifiersEx();
                    if (rkey == KeyEvent.VK_CAPS_LOCK) {
                        if (capslock == 0) capslock = 1;
                        else capslock = 0;
                    }
                }
            }

            public void keyReleased(KeyEvent e) {
            }
        };
        cn.getTextWindow().addKeyListener(klis);
        // --------------------------------------------------------------------------

        print_board();

        MultiLinkedList mll = new MultiLinkedList(); //THE MAIN MLL

        //The borders of selection
        int start_SelectionX = 0;
        int start_SelectionY = 0;
        int end_SelectionX = 0;
        int end_SelectionY = 0;

        //Controlling the cut and copy operations
        boolean cutFlag = false;
        String cut = "";
        boolean copyFlag = false;
        String copied = "";
        String selected = "";

        //Starting positions for find, next and replace method
        Object[] positions= new Object[1200];
        int nextCounter=1;
        int replaceCounter=1;
        int number_of_replace=0;


        //PRINTING INSTRUCTIONS
        // --------------------------------------------------------------------------
        cn.getTextWindow().setCursorPosition(63, 0);
        System.out.println("F1:Selection start");
        cn.getTextWindow().setCursorPosition(63, 1);
        System.out.println("F2:Selection end");
        cn.getTextWindow().setCursorPosition(63, 2);
        System.out.println("F3:Cut");
        cn.getTextWindow().setCursorPosition(63, 3);
        System.out.println("F4:Copy");
        cn.getTextWindow().setCursorPosition(63, 4);
        System.out.println("F5:Paste");
        cn.getTextWindow().setCursorPosition(63, 5);
        System.out.println("F6:Find");
        cn.getTextWindow().setCursorPosition(63, 6);
        System.out.println("F7:Replace");
        cn.getTextWindow().setCursorPosition(63, 7);
        System.out.println("F8:Next");
        cn.getTextWindow().setCursorPosition(63, 8);
        System.out.println("F9:Align left");
        cn.getTextWindow().setCursorPosition(63, 9);
        System.out.println("F10:Justify");
        cn.getTextWindow().setCursorPosition(63, 10);
        System.out.println("F11:Load");
        cn.getTextWindow().setCursorPosition(63, 11);
        System.out.println("F12:Save");

        // --------------------------------------------------------------------------


        //CURSOR TOOLS
        // --------------------------------------------------------------------------
        int curtype;
        curtype = cnt.getCursorType();   // default:2 (invisible)       0-1:visible
        cnt.setCursorType(1);
        cn.setTextAttributes(att0);

        // console clear (white background)
        cn.setTextAttributes(att1);
        // --------------------------------------------------------------------------

        int px = 1, py = 1;
        cnt.setCursorPosition(px, py);

        boolean flag = true;   //END OF GAME
        int paragraph_counter = 1;

        //--- main game loop ---
        while (flag) {

            if (keypr == 1) {    // if keyboard button pressed
                if (rkey == KeyEvent.VK_LEFT && px > 1) {
                    px--;
                }
                if (rkey == KeyEvent.VK_RIGHT && px < 61) {
                    px++;
                }
                if (rkey == KeyEvent.VK_UP && py > 1) {
                    py--;
                }

                if (rkey == KeyEvent.VK_DOWN && py < 20) {
                    py++;
                }

                char rckey = (char) rkey;

                if ((px >= 0 && px <= 61) && (py <= 20 && py >= 1)) {
                    //        left          right          up            down
                    if (rckey == '%' || rckey == '\'' || rckey == '&' || rckey == '(') {    // test without using VK (Virtual Keycode)
                        cn.getTextWindow().setCursorPosition(px, py);
                    }
                    else {
                        if (rckey >= '0' && rckey <= '9') {
                            if (!mll.searchCategory(paragraph_counter)) //WE CHECK IF THERE IS A NEW LINE OR NOT
                                mll.addCategory(paragraph_counter, py);

                            mll.addItem(paragraph_counter, rckey, px, py);
                            cn.getTextWindow().setCursorPosition(1, 1);
                            mll.display();                      //WE PRINT THE CHARACTERS OF EACH LINE
                            px++;
                            cn.getTextWindow().setCursorPosition(px, py);

                            if (px == 61) {
                                px = 1;
                                py++;
                            }
                        }

                        if (rckey >= 'A' && rckey <= 'Z') {
                            if (((rkeymod & KeyEvent.SHIFT_DOWN_MASK) > 0) || capslock == 1) {
                                if (!mll.searchCategory(paragraph_counter))
                                    mll.addCategory(paragraph_counter, py);

                                mll.addItem(paragraph_counter, rckey, px, py);
                                cn.getTextWindow().setCursorPosition(1, 1);
                                mll.display();
                                px++;

                                cn.getTextWindow().setCursorPosition(px, py);

                                if (px == 61 && py < 20) {
                                    px = 1;
                                    py++;
                                }

                            } else {
                                if (!mll.searchCategory(paragraph_counter))
                                    mll.addCategory(paragraph_counter, py);

                                mll.addItem(paragraph_counter, (char) (rckey + 32), px, py);
                                cn.getTextWindow().setCursorPosition(1, 1);
                                mll.display();
                                px++;
                                cn.getTextWindow().setCursorPosition(px, py);

                                if (px == 61 && py < 20) {
                                    px = 1;
                                    py++;
                                }
                            }
                        }

                        if ((rkeymod & KeyEvent.SHIFT_DOWN_MASK) == 0) {

                            if (rckey == '.' || rckey == ',' || rckey == '-') {
                                if (!mll.searchCategory(paragraph_counter))
                                    mll.addCategory(paragraph_counter, py);

                                mll.addItem(paragraph_counter, rckey, px, py);
                                cn.getTextWindow().setCursorPosition(1, 1);
                                mll.display();
                                px++;
                                cn.getTextWindow().setCursorPosition(px, py);

                                if (px == 61 && py < 20) {
                                    px = 1;
                                    py++;
                                }
                            }
                        } else {
                            if (rckey == '.') {
                                if (!mll.searchCategory(paragraph_counter))
                                    mll.addCategory(paragraph_counter, py);

                                mll.addItem(paragraph_counter, ':', px, py);
                                cn.getTextWindow().setCursorPosition(1, 1);
                                mll.display();
                                px++;
                                cn.getTextWindow().setCursorPosition(px, py);

                                if (px == 61 && py < 20) {
                                    px = 1;
                                    py++;
                                }
                            }
                            if (rckey == ',') {
                                if (!mll.searchCategory(paragraph_counter))
                                    mll.addCategory(paragraph_counter, py);

                                mll.addItem(paragraph_counter, ';', px, py);
                                cn.getTextWindow().setCursorPosition(1, 1);
                                mll.display();
                                px++;
                                cn.getTextWindow().setCursorPosition(px, py);

                                if (px == 61 && py < 20) {
                                    px = 1;
                                    py++;
                                }
                            }
                        }
                    }

                    if (rkey == KeyEvent.VK_SPACE) {
                        if (!mll.searchCategory(paragraph_counter))
                            mll.addCategory(paragraph_counter, py);

                        mll.addItem(paragraph_counter, ' ', px, py);
                        cn.getTextWindow().setCursorPosition(1, 1);
                        mll.display();
                        px++;
                        cn.getTextWindow().setCursorPosition(px, py);

                        if (px == 61 && py < 20) {
                            px = 1;
                            py++;
                        }
                    }

                    if (rkey == KeyEvent.VK_ENTER) {

                        if (py < 20) {
                            px = 1;
                            py++;
                            paragraph_counter++;
                            mll.addCategory(paragraph_counter, py);

                        }
                        cn.getTextWindow().setCursorPosition(px, py);

                    }
                    if (rkey == KeyEvent.VK_BACK_SPACE && px > 0) {

                        int category_line = mll.size_thiscategory(paragraph_counter) / 60;
                        int remain = mll.size_thiscategory(paragraph_counter) % 60;

                        if (mll.size_thiscategory(paragraph_counter) != 0) {
                            px--;
                            Object delete = mll.getElementX(category_line * 60 + remain, paragraph_counter);
                            mll.removeItem(paragraph_counter, delete, category_line * 60 + remain);
                            cn.getTextWindow().setCursorPosition(px, py);
                            System.out.print(" ");
                        }

                        if (mll.size_thiscategory(paragraph_counter) == 0 && paragraph_counter > 1) {
                            mll.removeCategory(paragraph_counter);
                            paragraph_counter--;

                        }

                        if (px == 1 && py > 1) {
                            px = mll.size_thiscategory(paragraph_counter) + 1;
                            py--;
                        }
                        cn.getTextWindow().setCursorPosition(1, 1);
                        mll.display();

                        cn.getTextWindow().setCursorPosition(px, py);

                    }

                    if (rkey == KeyEvent.VK_F1) {  //selection start
                        start_SelectionX = cn.getTextWindow().getCursorX();
                        start_SelectionY = cn.getTextWindow().getCursorY();
                    }

                    if (rkey == KeyEvent.VK_F2) { //selection end
                        end_SelectionX = cn.getTextWindow().getCursorX();
                        end_SelectionY = cn.getTextWindow().getCursorY();
                        selected = "";
                        selection(mll, start_SelectionX, start_SelectionY, end_SelectionX, end_SelectionY, selected);
                        cutFlag = false;
                        copyFlag = false;
                    }

                    if (rkey == KeyEvent.VK_F3) {  //CUT
                        cutFlag = true;

                        selected = selection(mll, start_SelectionX, start_SelectionY, end_SelectionX, end_SelectionY, selected);
                        cut = cut(mll, start_SelectionX, start_SelectionY, end_SelectionX, end_SelectionY);

                        cn.getTextWindow().setCursorPosition(0, 0);
                        print_board();

                        cn.getTextWindow().setCursorPosition(1, 1);
                        mll.display();

                        px = mll.size_thiscategory(paragraph_counter) % 60 + 1;
                        py = mll.lastItem_y();
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_F4) {  //Copy
                        copyFlag = true;
                        copied = selection(mll, start_SelectionX, start_SelectionY, end_SelectionX, end_SelectionY, selected);
                    }

                    if (rkey == KeyEvent.VK_F5) {  //Paste
                        if (copyFlag)
                            paste(mll, copied, paragraph_counter, px, py);

                        else if (cutFlag)
                            paste(mll, cut, paragraph_counter, px, py);

                        cn.getTextWindow().setCursorPosition(1, 1);

                        mll.display();
                        px = mll.size_thiscategory(paragraph_counter) % 60 + 1;
                        py = mll.lastItem_y();
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_F6) {  //Find
                        selected = selection(mll, start_SelectionX, start_SelectionY, end_SelectionX, end_SelectionY, selected);
                        positions=find(selected,mll);

                        int counter=0;
                        for(int i=1;i<= positions.length;i+=4){
                            if(positions[i]==null)
                                break;
                            counter++;
                        }

                        number_of_replace=counter;
                        px=mll.lastItem_x()+1;
                        py=mll.lastItem_y();
                        cn.getTextWindow().setCursorPosition(px,py);
                    }

                    if (rkey == KeyEvent.VK_F7) {  //REPLACE
                        Scanner scanner=new Scanner(System.in);
                        cn.getTextWindow().setCursorPosition(1,23);

                        System.out.print("Enter the word to replace with:");
                        String word=scanner.nextLine();

                        cn.getTextWindow().setCursorPosition(1,23);
                        cn.getTextWindow().output("                                               ",att0);

                        if (positions[replaceCounter]!=null){
                            for(int i=0;i<number_of_replace;i++){
                                replace(mll,(int) positions[replaceCounter],(int) positions[replaceCounter+1],(int) positions[replaceCounter+2],
                                        (int) positions[replaceCounter+3],word);
                                replaceCounter+=4;
                            }
                        }

                        cn.getTextWindow().setCursorPosition(0,0);
                        print_board();
                        cn.getTextWindow().setCursorPosition(1,1);
                        mll.display();

                        px=mll.lastItem_x()+1;
                        py=mll.lastItem_y();
                        cn.getTextWindow().setCursorPosition(px,py);
                        cnt.setCursorType(1);
                    }

                    if (rkey == KeyEvent.VK_F8) {  //NEXT
                        if (positions[nextCounter]!=null) {
                            cn.getTextWindow().setCursorPosition((int) positions[nextCounter], (int) positions[nextCounter + 1]);
                            char firstLetter=mll.findPosition((int)positions[nextCounter], (int) positions[nextCounter + 1]);
                            cn.getTextWindow().output(firstLetter,new TextAttributes(Color.black,Color.cyan));
                            nextCounter += 4;
                        }

                        if(positions[nextCounter]==null)
                            nextCounter=1;
                    }

                    if (rkey == KeyEvent.VK_F11) {       //LOAD
                        int[] category_and_line=read(mll);
                        cn.getTextWindow().setCursorPosition(1, 1);
                        mll.display();

                        cn.getTextWindow().setCursorPosition(75, 10);
                        cn.getTextWindow().output("Loaded !", new TextAttributes(Color.GREEN));
                        paragraph_counter=category_and_line[0];
                        py=category_and_line[1];
                        px=mll.size_thiscategory(py)+1;
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_F12) {       //SAVE
                        write(mll);
                        cn.getTextWindow().setCursorPosition(75, 11);
                        cn.getTextWindow().output("Saved !", new TextAttributes(Color.GREEN));
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_HOME) {
                        px = 1;
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_END) {
                        int y= cn.getTextWindow().getCursorY();
                        int category_line = mll.size_thiscategory(paragraph_counter) / 60;
                        int remain = mll.size_thiscategory(y) % 60;
                        if (mll.size_thiscategory(paragraph_counter) > 60 && py != category_line + 1)
                            px = 61;
                        else
                            px = remain + 1;

                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_PAGE_UP) {
                        px = 1;
                        py = 1;
                        cn.getTextWindow().setCursorPosition(px, py);
                    }

                    if (rkey == KeyEvent.VK_PAGE_DOWN) {
                        int remain = mll.size_thiscategory(paragraph_counter) % 60;
                        px = remain + 1;
                        py = mll.lastItem_y();
                        cn.getTextWindow().setCursorPosition(px, py);
                    }
                }
                keypr = 0;    // last action
            }

            Thread.sleep(20);
        } //end of game
    }
}