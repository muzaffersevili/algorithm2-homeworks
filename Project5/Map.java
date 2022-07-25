import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class Map {
	private static char[][] Map = new char[23][70];
	private static boolean[][] Map_Controller = new boolean[23][55];
	private static int[][] Random_Move_Map = new int[23][55];
	private static int[][] Path_Finding_Map = new int[23][55];
	static Random rand = new Random();

	public static boolean Wall_Control(int x, int y) {
		boolean flag = false;
		if (Map[x][y] == '#')
			flag = false;
		else
			flag = true;
		return flag;
	}

	public static void Delete_Number(int x, int y) {
		Map[x][y] = ' ';
	}

	public static int CollectNumber(int x, int y) {
		int collect = 0;
		if (Map[x][y] == '1')
			collect = 1;
		else if (Map[x][y] == '2')
			collect = 2;
		else if (Map[x][y] == '3')
			collect = 3;
		else if (Map[x][y] == '4')
			collect = 4;
		else if (Map[x][y] == '5')
			collect = 5;
		else if (Map[x][y] == '6')
			collect = 6;
		else if (Map[x][y] == '7')
			collect = 7;
		else if (Map[x][y] == '8')
			collect = 8;
		else if (Map[x][y] == '9')
			collect = 9;
		return collect;
	}

	public static void Random_Move_Generator(int x, int y) {
		int Random_Move = rand.nextInt(4);
		Random_Move_Map[x][y] = Random_Move;
	}

	public static int Random_Move(int x, int y) {
		int random = 4;
		if (Random_Move_Map[x][y] == 0)
			random = 0;
		else if (Random_Move_Map[x][y] == 1)
			random = 1;
		else if (Random_Move_Map[x][y] == 2)
			random = 2;
		else if (Random_Move_Map[x][y] == 3)
			random = 3;
		return random;
	}

	public static void Random_Move_Changer(int x, int y, int Random) {
		Random_Move_Map[x][y] = Random;
	}

	public static boolean Space_Control(int x, int y) {
		boolean flag = false;
		if (Map[x][y] == ' ')
			flag = true;
		else
			flag = false;
		return flag;
	}

	public static void Add(int x, int y, char number) {
		Map[x][y] = number;
	}

	public static void Reader() throws Exception {
		String path = "maze.txt";
		File file = new File(path);
		int map_x_counter = 0;
		int map_y_counter = 0;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		String sharp = Character.toString((char) 219);
		try {

			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);

			while (bis.available() > 0) {
				char ch = (char) bis.read();
				if (map_y_counter != 69) {
					Map[map_x_counter][map_y_counter] = ch;
					System.out.print(ch);
					map_y_counter++;
				} 
				else if (map_y_counter == 69) {
					Map[map_x_counter][map_y_counter] = ch;
					System.out.print(ch);
					map_x_counter++;
					map_y_counter = 0;
				}
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean Random_Move_Control(int x, int y, int userx, int usery) {
		boolean flag = false;

		if ((Map[x][y] == '4' || Map[x][y] == '5' || Map[x][y] == '6') && (x != userx || y != usery))
			flag = true;

		return flag;
	}

	public static void Map_Controller_False() {
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 55; j++) {
				Map_Controller[i][j] = false;
			}
		}
	}

	public static void Map_Controller_True(int x, int y) {
		Map_Controller[x][y] = true;
	}

	public static void Space_Control_False(int x, int y) {
		Map_Controller[x][y] = false;
	}

	public static boolean Random_Move_Control_Bool(int x, int y, int userx, int usery) {
		boolean flag = false;
		if ((Map[x][y] == '4' || Map[x][y] == '5' || Map[x][y] == '6') && (x != userx || y != usery)
				&& Map_Controller[x][y] == false)
			flag = true;

		return flag;
	}

	public static char Rand_Move_Element(int x, int y) {
		return Map[x][y];
	}

	public static void Reset_Random(int x, int y) {
		Random_Move_Map[x][y] = 4;
	}

	public static boolean Path_Finding_Control(int i, int k, int userx, int usery) {
		boolean flag = false;
		if ((Map[i][k] == '7' || Map[i][k] == '8' || Map[i][k] == '9') && (i != userx || k != usery)
				&& Map_Controller[i][k] == false)
			flag = true;

		return flag;
	}
}
