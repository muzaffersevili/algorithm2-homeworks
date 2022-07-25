public class MultiLinkedList {
    CategoryNode head;

    public void addCategory(Object dataToAdd,int py_start) {
        CategoryNode temp;

        if (head == null) {
            temp = new CategoryNode((int)dataToAdd);
            head = temp;
        }

        else {
            temp = head;
            while (temp.getDown() != null)
                temp = temp.getDown();
            CategoryNode newnode = new CategoryNode((int)dataToAdd);
            temp.setDown(newnode);

        }
        temp.setStart_py(py_start);
    }

    public void addItem(Object Category, Object Item,int x,int y) {
        if (head == null)
            System.out.println("Add a Category before Item");
        else {
            CategoryNode temp = head;

            while (temp != null)
            {
                if ((int)Category==(int)temp.getCategoryName()) {
                    ItemNode temp2 = temp.getRight();

                    if (temp2 == null) {
                        temp2 = new ItemNode((char) Item);
                        temp.setRight(temp2);
                        temp2.setX(x);
                        temp2.setY(y);
                    }
                    else {
                        while (temp2.getNext() != null)
                            temp2 = temp2.getNext();
                        ItemNode newnode = new ItemNode((char)Item);

                        temp2.setNext(newnode);
                        newnode.setX(x);
                        newnode.setY(y);
                    }
                }
                temp = temp.getDown();
            }
        }
    }

    public int sizeItem()
    {
        int count = 0;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    count++;
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
            }
        }
        return count;
    }

    public void display()
    {
        int line_counter=0;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                int item_counter=0;
                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    System.out.print(temp2.getItemName() );
                    item_counter++;
                    temp2 = temp2.getNext();
                    if(item_counter%60==0){
                        line_counter++;
                        System.out.println();
                        if (line_counter==4 ||line_counter==9 ||line_counter==14 )
                            System.out.print("+");
                        else
                            System.out.print("|");
                    }

                }
                temp = temp.getDown();
                line_counter++;
                System.out.println();
                if (line_counter==4 ||line_counter==9 ||line_counter==14 )
                    System.out.print("+");
                else
                    System.out.print("|");

            }
        }
    }

    public String returnAllItems() //Getting all items regardless the categories
    {
        String txt="";

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {

                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    txt+=temp2.getItemName();
                    temp2 = temp2.getNext();
                }
                temp = temp.getDown();
                if(temp!=null)
                    txt+="\n";
            }
        }
          return txt;
    }

    public char getItemById(int x) //Getting an element by giving its order
    {
        char item=' ';
        int counter=1;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {

                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    if (counter==x){
                        item=temp2.getItemName();
                    }
                    temp2 = temp2.getNext();
                    counter++;

                }
                temp = temp.getDown();

            }
        }
        return item;
    }

    public void getItemToEdit(int x,char c) //Replacing any item in the MLL
    {
        int counter=1;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {

                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    if (counter==x){
                        temp2.setItemName(c);
                        break;

                    }
                    temp2 = temp2.getNext();
                    counter++;

                }
                temp = temp.getDown();

            }
        }
    }

    public int getItemXById(int x)  //Getting an element by giving x coordinate
    {
        int itemX=' ';
        int counter=1;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {

                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    if (counter==x){
                        itemX=temp2.getX();
                    }
                    temp2 = temp2.getNext();
                    counter++;

                }
                temp = temp.getDown();

            }
        }
        return itemX;
    }

    public int getItemYById(int y)  //Getting an element by giving y coordinate
    {
        int itemY=' ';
        int counter=1;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {

                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    if (counter==y){
                        itemY=temp2.getY();
                    }
                    temp2 = temp2.getNext();
                    counter++;
                }
                temp = temp.getDown();

            }
        }
        return itemY;
    }

    public int lastItem_y()         //Return the y coordinate of the last item in the MLL
    {
        int lastItem_y=0;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    temp2 = temp2.getNext();
                    if (temp2!=null){
                        lastItem_y=temp2.getY();
                    }

                }

                temp = temp.getDown();
            }
        }
        return lastItem_y;
    }

    public int lastItem_x()         //Return the x coordinate of the last item in the MLL
    {
        int lastItem_x=0;

        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    temp2 = temp2.getNext();
                    if (temp2!=null){
                        lastItem_x=temp2.getX();
                    }

                }

                temp = temp.getDown();


            }
        }
        return lastItem_x;
    }

    public int size_thiscategory(int Category)  //Return the number of items in the current category
    {
        int counter=0;
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                if(Category==(int)temp.getCategoryName()){
                    ItemNode temp2 = temp.getRight();
                    while (temp2 != null)
                    {
                        counter++;
                        temp2 = temp2.getNext();
                    }
                    break;
                }
                temp = temp.getDown();
            }
        }
        return counter;
    }

    public boolean searchCategory(Object category)  //Searching for category
    {
        boolean flag=false;
        CategoryNode temp = head;
        while (temp != null)
        {
            if(category.toString().equals(temp.getCategoryName().toString())){
                flag=true;
                break;
            }
            temp = temp.getDown();
        }
        return flag;
    }

    // Remove Category
    public void removeCategory(Object categoryName) {
        if (head == null)
            System.out.println("Add a category before item");
        else if (head.getCategoryName() == categoryName)
            head = head.getDown();
        else {
            CategoryNode temp = head;
            while (temp.getDown() != null) {
                if (temp.getDown().getCategoryName() == categoryName) {
                    temp.setDown(temp.getDown().getDown());
                    break;
                }
                temp = temp.getDown();
            }
        }
    }

    // Remove Item
    public void removeItem(Object categoryName, Object itemName,int x) {
        if (head == null)
            System.out.println("Add a category before item");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                if (temp.getCategoryName().toString().equals(categoryName.toString())) {
                    ItemNode temp2 = temp.getRight();

                    if (temp2.getItemName() == (char)itemName &&x==1)
                        temp.setRight(temp2.getNext());
                    else {
                        int x_count=2;
                        while (temp2.getNext() != null) {
                            if (temp2.getNext().getItemName() == (Character)itemName&& x_count==x) {
                                temp2.setNext(temp2.getNext().getNext());
                                break;
                            }
                            temp2 = temp2.getNext();
                            x_count++;
                        }
                    }
                }
                temp = temp.getDown();
            }
        }
    }

    //Delete an element by giving its coordinate
    public void deleteByPosition(boolean flag, int x,int y) {
        if (head == null)
            System.out.println("Add a category before item");
        else {
            CategoryNode temp = head;
            while (temp != null) {
                if (flag) {
                    ItemNode temp2 = temp.getRight();

                    if (temp2.getX() == x &&temp2.getY()==y){
                        temp.setRight(temp2.getNext());
                    }

                    else {

                        while (temp2.getNext() != null) {
                            if (temp2.getNext().getX()==x&& temp2.getNext().getY()==y) {

                                temp2.setNext(temp2.getNext().getNext());
                                break;
                            }
                            temp2 = temp2.getNext();

                        }
                    }
                }
                temp = temp.getDown();
            }
        }
    }

    //Getting an element by giving its x_coordinate and category
    public Object getElementX(int item_place,int category) {
        if (head == null){
            System.out.println("linked list is empty");
            return null;
        }
        else if (item_place > sizeItem() || category < 1) {
            System.out.println("Index is out of range!");
            return null;
        }
        else {
            CategoryNode temp = head;
            int countCategory = 1;
            while (temp != null) {
                if (countCategory == category) {
                    ItemNode temp2 = temp.getRight();
                    int countItem = 1;
                    while (temp2 != null) {
                        if (countItem == item_place)
                            return temp2.getItemName();
                        temp2 = temp2.getNext();
                        countItem++;
                    }
                }
                countCategory++;
                temp = temp.getDown();
            }
            return null;
        }
    }

    //Find the position of an element
    public char findPosition(int x,int y)
    {

        char requiredNode=' ';
        if (head == null)
            System.out.println("linked list is empty");
        else {
            CategoryNode temp = head;
            while (temp != null)
            {
                ItemNode temp2 = temp.getRight();
                while (temp2 != null)
                {
                    if (temp2.getX()==x&&y==temp2.getY()){
                        requiredNode=temp2.getItemName();
                    }
                    temp2 = temp2.getNext();

                }
                temp = temp.getDown();


            }
        }
        return requiredNode;
    }

    }