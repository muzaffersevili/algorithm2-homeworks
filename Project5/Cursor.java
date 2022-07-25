import enigma.core.Enigma;
import enigma.event.TextMouseEvent;
import enigma.event.TextMouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Random;
import enigma.console.Console;
import enigma.console.TextAttributes;
import java.awt.Color;

public class Cursor {
	public static TextAttributes att0;
	public static TextAttributes att1 = new TextAttributes(Color.green);
	public static TextAttributes att2 = new TextAttributes(Color.yellow);
	public static TextAttributes att3 = new TextAttributes(Color.red);
	public static TextAttributes att4 = new TextAttributes(Color.cyan);
	public static TextAttributes att5 = new TextAttributes(Color.magenta);
	public static TextAttributes att6 = new TextAttributes(Color.orange);

	public enigma.console.Console cn = Enigma.getConsole("Number Maze", 70, 25, 20, 3);
	public TextMouseListener tmlis;
	public KeyListener klis;
	// ------ Standard variables for mouse and keyboard ------
	public int keypr; // key pressed?
	public int rkey; // key (for press/release)

	Random rand = new Random();
	Stack RightBackpack = new Stack(8);
	Stack LeftBackpack = new Stack(8);
	Stack TempRightBackpack = new Stack(8);
	Stack TempLeftBackpack = new Stack(8);
	Stack PathFinding = new Stack(1000);
	CircularQueue Inputlist = new CircularQueue(10);

	// ----------------------------------------------------

	
	Cursor() throws Exception { // --- Constructor
		// ------ Standard code for mouse and keyboard ------ Do not change
		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);
		// ----------------------------------------------------
		
		int Score=0;
		Map.Reader();
		for (int i = 0; i < 25; i++) // Firstly insert 25 random number
		{
			int random_number = rand.nextInt(300);

			if (random_number < 75) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '1');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('1', att1);
						break;
					}
				}
			} 
			else if (random_number < 150) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '2');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('2', att1);
						break;
					}
				}
			}
			else if (random_number < 225) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '3');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('3', att1);
						break;
					}
				}
			} 
			else if (random_number < 245) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '4');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('4', att2);
						break;
					}
				}
			} 
			else if (random_number < 265) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '5');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('5', att2);
						break;
					}
				}
			} 
			else if (random_number < 285) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '6');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('6', att2);
						break;
					}
				}
			} 
			else if (random_number < 290) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '7');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('7', att3);
						break;
					}
				}
			} 
			else if (random_number < 295) {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '8');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('8', att3);
						break;
					}
				}
			} 
			else {
				while (true) {
					int x = rand.nextInt(23);
					int y = rand.nextInt(55);
					if (Map.Space_Control(x, y)) {
						Map.Add(x, y, '9');
						cn.getTextWindow().setCursorPosition(y, x);
						cn.getTextWindow().output('9', att3);
						break;
					}
				}
			}
		}

		char user_number = '5';
		int userx,usery;
		int left_bpack_counter = 0;
		int right_bpack_counter = 0;
		int RADIX = 10;
		int inputlist_counter = 0;

		for (int i = 0; i < 10; i++) // insert 10 random numbers in input list
		{
			int random_number = rand.nextInt(300);
			if (random_number < 75) {
				Inputlist.enqueue(1);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('1', att1);
				inputlist_counter++;
			} 
			else if (random_number < 150) {
				Inputlist.enqueue(2);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('2', att1);
				inputlist_counter++;
			}
			else if (random_number < 225) {
				Inputlist.enqueue(3);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('3', att1);
				inputlist_counter++;
			} 
			else if (random_number < 245) {
				Inputlist.enqueue(4);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('4', att2);
				inputlist_counter++;
			} 
			else if (random_number < 265) {
				Inputlist.enqueue(5);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('5', att2);
				inputlist_counter++;
			} 
			else if (random_number < 285) {
				Inputlist.enqueue(6);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('6', att2);
				inputlist_counter++;
			} 
			else if (random_number < 290) {
				Inputlist.enqueue(7);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('7', att3);
				inputlist_counter++;
			} 
			else if (random_number < 295) {
				Inputlist.enqueue(8);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('8', att3);
				inputlist_counter++;
			} 
			else {
				Inputlist.enqueue(9);
				cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
				cn.getTextWindow().output('9', att3);
				inputlist_counter++;
			}
		}

		while (true)// insert random user_number
		{
			userx = rand.nextInt(23);
			usery = rand.nextInt(55);
			if (Map.Space_Control(userx, usery)) {
				cn.getTextWindow().setCursorPosition(usery, userx);
				cn.getTextWindow().output(user_number, att4);
				Map.Add(userx, usery, user_number);
				break;
			}
		}

		cn.getTextWindow().setCursorPosition(57, 0);
		cn.getTextWindow().output("Input", att5);

		cn.getTextWindow().setCursorPosition(57, 6);
		cn.getTextWindow().output("Backpacks", att5);

		cn.getTextWindow().setCursorPosition(57, 16);
		cn.getTextWindow().output("Left", att6);
		cn.getTextWindow().setCursorPosition(59, 17);
		cn.getTextWindow().output("Q", att6);

		cn.getTextWindow().setCursorPosition(63, 16);
		cn.getTextWindow().output("Right", att6);
		cn.getTextWindow().setCursorPosition(65, 17);
		cn.getTextWindow().output("W", att6);

		cn.getTextWindow().setCursorPosition(57, 20);
		cn.getTextWindow().output("Score:", att5);

		cn.getTextWindow().setCursorPosition(57, 22);
		cn.getTextWindow().output("Time :", att5);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 5; j += 4) {
				cn.getTextWindow().setCursorPosition(57 + j, 7 + i);
				cn.getTextWindow().output("|", att6);
			}
			for (int j = 0; j < 5; j += 4) {
				cn.getTextWindow().setCursorPosition(63 + j, 7 + i);
				cn.getTextWindow().output("|", att6);
			}
		}

		cn.getTextWindow().setCursorPosition(57, 15);
		cn.getTextWindow().output("+---+", att6);

		cn.getTextWindow().setCursorPosition(63, 15);
		cn.getTextWindow().output("+---+", att6);

		int timer = 0;
		int map_coming = 0;
		int converter_1to2 = 0;
		boolean new_input_flag = false;
		int chronometer = 0;

		while (true) { // Game loop

			if (user_number == '1' && new_input_flag == false) {
				converter_1to2 = timer;
				new_input_flag = true;
			} 
			else if (converter_1to2 + 4 == timer && user_number == '1') {
				user_number = '2';
				new_input_flag = false;
			}

			if (timer % 5 == 0) { // Add new numbers to inputlist queue
				map_coming = (int) Inputlist.dequeue();
				int random_number = rand.nextInt(300);

				if (random_number < 75) {
					Inputlist.enqueue(1);
				} 
				else if (random_number < 150) {
					Inputlist.enqueue(2);
				} 
				else if (random_number < 225) {
					Inputlist.enqueue(3);
				}
				else if (random_number < 245) {
					Inputlist.enqueue(4);
				} 
				else if (random_number < 265) {
					Inputlist.enqueue(5);
				}
				else if (random_number < 285) {
					Inputlist.enqueue(6);
				} 
				else if (random_number < 290) {
					Inputlist.enqueue(7);
				} 
				else if (random_number < 295) {
					Inputlist.enqueue(8);
				} 
				else {
					Inputlist.enqueue(9);
				}

				inputlist_counter = 0;
				for (int i = 0; i < 10; i++)// print inputlist queue
				{
					int a = (int) Inputlist.peek();
					if (a == 1 || a == 2 || a == 3) {
						char c = Character.forDigit(a, RADIX);
						cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
						cn.getTextWindow().output(c, att1);
						inputlist_counter++;
						Inputlist.enqueue(Inputlist.dequeue());
					} 
					else if (a == 4 || a == 5 || a == 6) {
						char c = Character.forDigit(a, RADIX);
						cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
						cn.getTextWindow().output(c, att2);
						inputlist_counter++;
						Inputlist.enqueue(Inputlist.dequeue());
					}
					else if (a == 7 || a == 8 || a == 9) {
						char c = Character.forDigit(a, RADIX);
						cn.getTextWindow().setCursorPosition(57 + inputlist_counter, 2);
						cn.getTextWindow().output(c, att3);
						inputlist_counter++;
						Inputlist.enqueue(Inputlist.dequeue());
					}
				}

				while (true) {// inserting numbers to map which came from inputlist
					int random_x = rand.nextInt(23);
					int random_y = rand.nextInt(55);
					if (Map.Space_Control(random_x, random_y)) {

						if (map_coming == 1 || map_coming == 2 || map_coming == 3) {

							cn.getTextWindow().setCursorPosition(random_y, random_x);
							char c = Character.forDigit(map_coming, RADIX);
							Map.Add(random_x, random_y, c);
							cn.getTextWindow().output(c, att1);
							break;

						} 
						else if (map_coming == 4 || map_coming == 5 || map_coming == 6) {
							cn.getTextWindow().setCursorPosition(random_y, random_x);
							char c = Character.forDigit(map_coming, RADIX);
							Map.Add(random_x, random_y, c);
							cn.getTextWindow().output(c, att2);
							break;

						}
						else {
							cn.getTextWindow().setCursorPosition(random_y, random_x);
							char c = Character.forDigit(map_coming, RADIX);
							Map.Add(random_x, random_y, c);
							cn.getTextWindow().output(c, att3);
							break;
						}
					}
				}
			}

			int user_number_int = Integer.parseInt(String.valueOf(user_number));
			cn.getTextWindow().setCursorPosition(64, 22);
			String time_str = Integer.toString(timer);
			cn.getTextWindow().output(time_str, att5); // print timer

			cn.getTextWindow().setCursorPosition(usery, userx);
			cn.getTextWindow().output(user_number, att4);

			if (keypr == 1) {
				boolean move_checker = false;
				
				if (rkey == KeyEvent.VK_W) {
					
					if (RightBackpack.isFull() == false && LeftBackpack.isEmpty() != true) {
						cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter + 1);
						cn.getTextWindow().output(' ');
						RightBackpack.push(LeftBackpack.pop());
						left_bpack_counter--;
						cn.getTextWindow().setCursorPosition(65, 14 - right_bpack_counter);
						int a = (int) RightBackpack.peek();
						char c = Character.forDigit(a, RADIX);
						cn.getTextWindow().output(c);
						right_bpack_counter++;
					}
				}
				
				if (rkey == KeyEvent.VK_Q) {
					
					if (LeftBackpack.isFull() == false && RightBackpack.isEmpty() != true) {
						cn.getTextWindow().setCursorPosition(65, 14 - right_bpack_counter + 1);
						cn.getTextWindow().output(' ');
						LeftBackpack.push(RightBackpack.pop());
						right_bpack_counter--;
						cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter);
						int a = (int) LeftBackpack.peek();
						char c = Character.forDigit(a, RADIX);
						cn.getTextWindow().output(c);
						left_bpack_counter++;
					}
				}

				if (rkey == KeyEvent.VK_LEFT && Map.Wall_Control(userx, usery - 1) == true) {
					
					if (Map.CollectNumber(userx, usery - 1) > user_number_int
							&& Map.CollectNumber(userx, usery - 1) != 0) {
						cn.getTextWindow().setCursorPosition(30, 24);
						cn.getTextWindow().output("Game Over!!", att4);
						break;
						
					} 
					else if (Map.CollectNumber(userx, usery - 1) <= user_number_int) {
						
						if (Map.CollectNumber(userx, usery - 1) != 0) {
							if (LeftBackpack.isFull() == true) {
								LeftBackpack.pop();
								LeftBackpack.push(Map.CollectNumber(userx, usery - 1));
								int a = Map.CollectNumber(userx, usery - 1);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter + 1);
								cn.getTextWindow().output(c);
								Map.Delete_Number(userx, usery - 1);
							} 
							else {
								LeftBackpack.push(Map.CollectNumber(userx, usery - 1));
								int a = Map.CollectNumber(userx, usery - 1);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter);
								cn.getTextWindow().output(c);
								left_bpack_counter++;
								Map.Delete_Number(userx, usery - 1);
							}
						}
						usery--;
						move_checker = true;
					}
				} 
				else if (rkey == KeyEvent.VK_RIGHT && Map.Wall_Control(userx, usery + 1) == true) {

					if (Map.CollectNumber(userx, usery + 1) > user_number_int
							&& Map.CollectNumber(userx, usery + 1) != 0) {
						cn.getTextWindow().setCursorPosition(30, 24);
						cn.getTextWindow().output("Game Over!!", att4);
						break;
					} 
					else if (Map.CollectNumber(userx, usery + 1) <= user_number_int) {

						if (Map.CollectNumber(userx, usery + 1) != 0) {
							if (LeftBackpack.isFull() == true) {
								LeftBackpack.pop();
								LeftBackpack.push(Map.CollectNumber(userx, usery + 1));
								int a = Map.CollectNumber(userx, usery + 1);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter + 1);
								cn.getTextWindow().output(c);
								Map.Delete_Number(userx, usery + 1);
							} 
							else {
								LeftBackpack.push(Map.CollectNumber(userx, usery + 1));
								int a = Map.CollectNumber(userx, usery + 1);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter);
								cn.getTextWindow().output(c);
								left_bpack_counter++;
								Map.Delete_Number(userx, usery + 1);
							}
						}
						usery++;
						move_checker = true;
					}

				} 
				else if (rkey == KeyEvent.VK_UP && Map.Wall_Control(userx - 1, usery) == true) {
					if (Map.CollectNumber(userx - 1, usery) > user_number_int
							&& Map.CollectNumber(userx - 1, usery) != 0) {
						cn.getTextWindow().setCursorPosition(30, 24);
						cn.getTextWindow().output("Game Over!!", att4);
						break;
					} 
					else if (Map.CollectNumber(userx - 1, usery) <= user_number_int) {

						if (Map.CollectNumber(userx - 1, usery) != 0) {
							if (LeftBackpack.isFull() == true) {
								LeftBackpack.pop();
								LeftBackpack.push(Map.CollectNumber(userx - 1, usery));
								int a = Map.CollectNumber(userx - 1, usery);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter + 1);
								cn.getTextWindow().output(c);
								Map.Delete_Number(userx - 1, usery);
							} 
							else {
								LeftBackpack.push(Map.CollectNumber(userx - 1, usery));
								int a = Map.CollectNumber(userx - 1, usery);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter);
								cn.getTextWindow().output(c);
								left_bpack_counter++;
								Map.Delete_Number(userx - 1, usery);
							}
						}
						userx--;
						move_checker = true;
					}
				} 
				else if (rkey == KeyEvent.VK_DOWN && Map.Wall_Control(userx + 1, usery) == true) {
					if (Map.CollectNumber(userx + 1, usery) > user_number_int
							&& Map.CollectNumber(userx + 1, usery) != 0) {
						cn.getTextWindow().setCursorPosition(30, 24);
						cn.getTextWindow().output("Game Over!!", att4);
						break;
					} 
					else if (Map.CollectNumber(userx + 1, usery) <= user_number_int) {
						if (Map.CollectNumber(userx + 1, usery) != 0) {
							if (LeftBackpack.isFull() == true) {
								LeftBackpack.pop();
								LeftBackpack.push(Map.CollectNumber(userx + 1, usery));
								int a = Map.CollectNumber(userx + 1, usery);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter + 1);
								cn.getTextWindow().output(c);
								Map.Delete_Number(userx - 1, usery);
							} 
							else {
								LeftBackpack.push(Map.CollectNumber(userx + 1, usery));
								int a = Map.CollectNumber(userx + 1, usery);
								char c = Character.forDigit(a, RADIX);
								cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter);
								cn.getTextWindow().output(c);
								left_bpack_counter++;
								Map.Delete_Number(userx + 1, usery);
							}
						}
						userx++;
						move_checker = true;
					}
				}

				if (move_checker) {
					char rckey = (char) rkey;
					{
						if (rckey == '%') {
							cn.getTextWindow().output(usery, userx, user_number, att4);
							Map.Add(userx, usery, user_number);
							cn.getTextWindow().output(usery + 1, userx, ' ');
							Map.Delete_Number(userx, usery + 1);
						} 
						else if (rckey == '\'') {
							cn.getTextWindow().output(usery, userx, user_number, att4);
							Map.Add(userx, usery, user_number);
							cn.getTextWindow().output(usery - 1, userx, ' ');
							Map.Delete_Number(userx, usery - 1);
						} 
						else if (rckey == '&') {
							cn.getTextWindow().output(usery, userx, user_number, att4);
							Map.Add(userx, usery, user_number);
							cn.getTextWindow().output(usery, userx + 1, ' ');
							Map.Delete_Number(userx + 1, usery);
						}
						else if (rckey == '(') {
							cn.getTextWindow().output(usery, userx, user_number, att4);
							Map.Add(userx, usery, user_number);
							cn.getTextWindow().output(usery, userx - 1, ' ');
							Map.Delete_Number(userx - 1, usery);
						}
						else
							cn.getTextWindow().output(rckey);
						keypr = 0;
					}
				} 
				else 
					keypr = 0;

				while (true) {
					if (RightBackpack.size() > LeftBackpack.size()) {

						int difference = RightBackpack.size() - LeftBackpack.size();
						for (int i = 0; i < difference; i++) {
							TempRightBackpack.push(RightBackpack.pop());
						}
						int rightbag_size = RightBackpack.size();

						if (RightBackpack.isEmpty() != true) {
							for (int i = 0; i < rightbag_size; i++) {
								int right_peek = (int) RightBackpack.peek();
								int left_peek = (int) LeftBackpack.peek();
								if (right_peek == left_peek) {
									
									if (right_peek == 1 || right_peek == 2 || right_peek == 3) 
										Score += right_peek;
									else if (right_peek == 4 || right_peek == 5 || right_peek == 6)
										Score += right_peek * 5;
									else 
										Score += right_peek * 25;
									
									RightBackpack.pop();
									LeftBackpack.pop();
									user_number_int++;
									left_bpack_counter--;
									right_bpack_counter--;
								} 
								else {
									TempRightBackpack.push(RightBackpack.pop());
									TempLeftBackpack.push(LeftBackpack.pop());
								}
							}
						}
					} 
					else if (RightBackpack.size() < LeftBackpack.size()) {

						int difference = LeftBackpack.size() - RightBackpack.size();

						for (int i = 0; i < difference; i++)
							TempLeftBackpack.push(LeftBackpack.pop());
						
						int rightbag_size = RightBackpack.size();
						
						if (RightBackpack.isEmpty() != true) {
							for (int i = 0; i < rightbag_size; i++) {
								int right_peek = (int) RightBackpack.peek();
								int left_peek = (int) LeftBackpack.peek();
								if (right_peek == left_peek) {
									if (right_peek == 1 || right_peek == 2 || right_peek == 3) 
										Score += right_peek;
									
									else if (right_peek == 4 || right_peek == 5 || right_peek == 6) 
										Score += right_peek * 5;
									
									else
										Score += right_peek * 25;
									
									RightBackpack.pop();
									LeftBackpack.pop();
									user_number_int++;
									left_bpack_counter--;
									right_bpack_counter--;
								} 
								else {
									TempRightBackpack.push(RightBackpack.pop());
									TempLeftBackpack.push(LeftBackpack.pop());
								}
							}
						}
					} 
					else if (RightBackpack.size() == LeftBackpack.size() && RightBackpack.size() != 0) {
						int rightbag_size = RightBackpack.size();
						if (RightBackpack.isEmpty() != true) {
							for (int i = 0; i < rightbag_size; i++) {
								int right_peek = (int) RightBackpack.peek();
								int left_peek = (int) LeftBackpack.peek();
								if (right_peek == left_peek) {
									if (right_peek == 1 || right_peek == 2 || right_peek == 3) 
										Score += right_peek;
									
									else if (right_peek == 4 || right_peek == 5 || right_peek == 6)
										Score += right_peek * 5;
									
									else
										Score += right_peek * 25;
									
									RightBackpack.pop();
									LeftBackpack.pop();
									user_number_int++;
									left_bpack_counter--;
									right_bpack_counter--;
								} 
								else {
									TempRightBackpack.push(RightBackpack.pop());
									TempLeftBackpack.push(LeftBackpack.pop());
								}
							}
						}
					}
					break;
				}
				
				if (user_number_int == 10)
					user_number_int = 1;
				
				user_number = Character.forDigit(user_number_int, RADIX);
				int right_bpack_counter2 = 0;
				int left_bpack_counter2 = 0;

				while (true) {
					int tempright = TempRightBackpack.size();
					int templeft = TempLeftBackpack.size();
					
					for (int i = 0; i < tempright; i++) {
						char c = Character.forDigit((int) TempRightBackpack.peek(), RADIX);
						cn.getTextWindow().setCursorPosition(65, 14 - right_bpack_counter2);
						cn.getTextWindow().output(c);
						RightBackpack.push(TempRightBackpack.pop());
						right_bpack_counter2++;
					}
					
					for (int i = 0; i < templeft; i++) {
						char c = Character.forDigit((int) TempLeftBackpack.peek(), RADIX);
						cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter2);
						cn.getTextWindow().output(c);
						LeftBackpack.push(TempLeftBackpack.pop());
						left_bpack_counter2++;
					}
					
					for (int i = 0; i < 8 - tempright; i++) {
						cn.getTextWindow().setCursorPosition(65, 14 - right_bpack_counter2);
						cn.getTextWindow().output(' ');
						right_bpack_counter2++;
					}
					
					for (int i = 0; i < 8 - templeft; i++) {
						cn.getTextWindow().setCursorPosition(59, 14 - left_bpack_counter2);
						cn.getTextWindow().output(' ');
						left_bpack_counter2++;
					}
					break;
				}

				cn.getTextWindow().setCursorPosition(64, 20);
				String score_str = Integer.toString(Score);
				cn.getTextWindow().output(score_str, att5);
			}
			
			Map.Map_Controller_False();

			for (int z = 0; z < 23; z++) {
				for (int j = 0; j < 55; j++) {
					
					if (Map.Random_Move_Control(z, j, userx, usery) == true
							&& Map.Random_Move_Control_Bool(z, j, userx, usery) == true) {
						
						if (chronometer != timer) {
							
							while (true) {
								
								if (Map.Random_Move(z, j) == 0 && Map.Space_Control(z - 1, j) == true) {
									char number = Map.Rand_Move_Element(z, j);
									cn.getTextWindow().output(j, z - 1, number, att2);
									Map.Add(z - 1, j, number);
									Map.Map_Controller_True(z - 1, j);
									cn.getTextWindow().output(j, z, ' ');
									Map.Reset_Random(z, j);
									Map.Random_Move_Changer(z - 1, j, 0);
									Map.Space_Control_False(z, j);
									Map.Delete_Number(z, j);
									break;
								} 
								else if (Map.Random_Move(z, j) == 1 && Map.Space_Control(z, j - 1) == true) {
									char number = Map.Rand_Move_Element(z, j);
									cn.getTextWindow().output(j - 1, z, number, att2);
									Map.Add(z, j - 1, number);
									Map.Map_Controller_True(z, j - 1);
									Map.Reset_Random(z, j);
									Map.Random_Move_Changer(z, j - 1, 1);
									cn.getTextWindow().output(j, z, ' ');
									Map.Space_Control_False(z, j);
									Map.Delete_Number(z, j);
									break;
								} 
								else if (Map.Random_Move(z, j) == 2 && Map.Space_Control(z, j + 1) == true) {
									char number = Map.Rand_Move_Element(z, j);
									cn.getTextWindow().output(j + 1, z, number, att2);
									Map.Add(z, j + 1, number);
									Map.Map_Controller_True(z, j + 1);
									Map.Reset_Random(z, j);
									Map.Random_Move_Changer(z, j + 1, 2);
									cn.getTextWindow().output(j, z, ' ');
									Map.Space_Control_False(z, j);
									Map.Delete_Number(z, j);
									break;
								} 
								else if (Map.Random_Move(z, j) == 3 && Map.Space_Control(z + 1, j) == true) {
									char number = Map.Rand_Move_Element(z, j);
									cn.getTextWindow().output(j, z + 1, number, att2);
									Map.Add(z + 1, j, number);
									Map.Map_Controller_True(z + 1, j);
									Map.Reset_Random(z, j);
									Map.Random_Move_Changer(z + 1, j, 3);
									cn.getTextWindow().output(j, z, ' ');
									Map.Space_Control_False(z, j);
									Map.Delete_Number(z, j);
									break;
								} 
								else
									Map.Random_Move_Generator(z, j);
							}
						}
					}
				}
			}
			
			boolean game_over = false;
			
			for (int i = 0; i < 23; i++) {
				for (int k = 0; k < 55; k++) {
					
					if (chronometer != timer) {
						
						if (Map.Path_Finding_Control(i, k, userx, usery)) {
							while (true) {
								char number = Map.Rand_Move_Element(i, k);
								if (i > userx && k > usery) {
									
									if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i > userx && k < usery) {
									if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i < userx && k > usery) {
									if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i < userx && k < usery) {
									if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i == userx && k < usery) {
									if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i == userx && k > usery) {
									if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								} 
								else if (i > userx && k == usery) {
									if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								}
								else if (i < userx && k == usery) {
									if (Map.Space_Control(i + 1, k)) {
										PathFinding.push(2);
										Map.Delete_Number(i, k);
										Map.Add(i + 1, k, number);
										Map.Map_Controller_True(i + 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i + 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k - 1)) {
										PathFinding.push(3);
										Map.Delete_Number(i, k);
										Map.Add(i, k - 1, number);
										Map.Map_Controller_True(i, k - 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k - 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									} 
									else if (Map.Space_Control(i, k + 1)) {
										PathFinding.push(1);
										Map.Delete_Number(i, k);
										Map.Add(i, k + 1, number);
										Map.Map_Controller_True(i, k + 1);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k + 1, i, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
									else if (Map.Space_Control(i - 1, k)) {
										PathFinding.push(4);
										Map.Delete_Number(i, k);
										Map.Add(i - 1, k, number);
										Map.Map_Controller_True(i - 1, k);
										Map.Space_Control_False(i, k);
										cn.getTextWindow().output(k, i - 1, number, att3);
										cn.getTextWindow().output(k, i, ' ');
										break;
									}
								}

								if (i == userx && k == usery) {
									cn.getTextWindow().setCursorPosition(30, 24);
									cn.getTextWindow().output("Game Over!!", att4);
									game_over = true;
									break;
								}
							}
						}
					}
					
					if (game_over) 
						break;
					
					int stack_size = PathFinding.size();
					for (int j = 0; j < stack_size; j++)
						PathFinding.pop();
				}

				if (game_over)
					break;
			}
			if (game_over)
				break;
			
			chronometer = timer;
			timer++;
			Thread.sleep(500);
		}
	}
}