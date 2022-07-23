using System;

namespace pbl3
{
    class Program
    {
        static void GameScreen(string[,] array, string[] white_pieces, string[] black_pieces)
        {
            // Screening game board design, placing pieces to colorized parts of the board to the screen.
            Console.SetCursorPosition(1, 1);
            Console.Write("+ - - - - - - - - - - - - +");

            Console.SetCursorPosition(0, 2);
            for (int i = 0; i < array.GetLength(0); i++)
            {
                Console.Write(8 - i + "| ");
                for (int j = 0; j < array.GetLength(1); j++)
                {

                    if (array[i, j] == ".")
                    {
                        Console.ResetColor();
                        Console.Write("." + "  ");
                    }

                    else
                    {
                        for (int k = 0; k < 6; k++)
                        {
                            if (array[i, j] == black_pieces[k])
                            {
                                Console.ForegroundColor = ConsoleColor.Blue;
                                Console.Write(array[i, j] + "  ");
                                Console.ResetColor();
                            }
                        }

                        if (array[i, j] == white_pieces[5])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("P" + "  ");
                            Console.ResetColor();
                        }
                        else if (array[i, j] == white_pieces[0])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("R" + "  ");
                            Console.ResetColor();
                        }
                        else if (array[i, j] == white_pieces[1])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("N" + "  ");
                            Console.ResetColor();
                        }
                        else if (array[i, j] == white_pieces[2])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("B" + "  ");
                            Console.ResetColor();
                        }
                        else if (array[i, j] == white_pieces[3])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("Q" + "  ");
                            Console.ResetColor();
                        }
                        else if (array[i, j] == white_pieces[4])
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.Write("K" + "  ");
                            Console.ResetColor();
                        }
                    }
                }
                Console.WriteLine("|");
            }

            Console.SetCursorPosition(1, 10);
            Console.WriteLine("+ - - - - - - - - - - - - +");
            Console.SetCursorPosition(1, 11);
            Console.WriteLine("  a  b  c  d  e  f  g  h");
        }

        static void Main(string[] args)
        {
            Console.Title = "Chess";

            int cursorx = 3, cursory = 2;
            ConsoleKeyInfo cki;
            ConsoleKeyInfo cki2;

            //Adding pieces' name to arrays.

            string[] black_pieces = new string[6];
            black_pieces[0] = "R";
            black_pieces[1] = "N";
            black_pieces[2] = "B";
            black_pieces[3] = "Q";
            black_pieces[4] = "K";
            black_pieces[5] = "P";

            string[] white_pieces = new string[6];
            white_pieces[0] = "Rw";
            white_pieces[1] = "Nw";
            white_pieces[2] = "Bw";
            white_pieces[3] = "Qw";
            white_pieces[4] = "Kw";
            white_pieces[5] = "Pw";

            string[,] array = new string[8, 8];

            for (int i = 0; i < array.GetLength(0); i++)
            {
                for (int j = 0; j < array.GetLength(1); j++)
                {
                    array[i, j] = ".";
                }
            }

            for (int j = 0; j < array.GetLength(1); j++)
            {
                array[1, j] = black_pieces[5];
                array[6, j] = white_pieces[5];
            }

            //Pieces -Rook Knight Bishop Queen King
            array[0, 0] = black_pieces[0];
            array[0, 7] = black_pieces[0];
            array[0, 1] = black_pieces[1];
            array[0, 6] = black_pieces[1];
            array[0, 2] = black_pieces[2];
            array[0, 5] = black_pieces[2];
            array[0, 3] = black_pieces[3];
            array[0, 4] = black_pieces[4];

            array[7, 0] = white_pieces[0];
            array[7, 7] = white_pieces[0];
            array[7, 1] = white_pieces[1];
            array[7, 6] = white_pieces[1];
            array[7, 2] = white_pieces[2];
            array[7, 5] = white_pieces[2];
            array[7, 3] = white_pieces[3];
            array[7, 4] = white_pieces[4];

            GameScreen(array, white_pieces, black_pieces);
            Console.ReadLine();
            bool flag = true;
            int turner = 0;
            while (flag)
            {
                if (Console.KeyAvailable)
                {
                    cki = Console.ReadKey(true);
                    //  Moving the cursor in x-y direction 

                    if (cki.Key == ConsoleKey.RightArrow && cursorx < 22)
                    {
                        Console.SetCursorPosition(cursorx, cursory);
                        cursorx += 3;
                    }
                    if (cki.Key == ConsoleKey.LeftArrow && cursorx > 3)
                    {
                        Console.SetCursorPosition(cursorx, cursory);
                        cursorx -= 3;
                    }
                    if (cki.Key == ConsoleKey.UpArrow && cursory > 2)
                    {
                        Console.SetCursorPosition(cursorx, cursory);
                        cursory -= 1;
                    }
                    if (cki.Key == ConsoleKey.DownArrow && cursory < 9)
                    {
                        Console.SetCursorPosition(cursorx, cursory);
                        cursory += 1;
                    }
                    Console.SetCursorPosition(cursorx, cursory);


                    int cordy = (cursorx - 3) / 3;
                    int cordx = cursory - 2;

                    bool RBQ;
                    int RQcounter;
                    int RQcounter2;
                    int BQcounter;
                    int new_BQ_control;
                    string promotion;
                    int Kcounter;
                    int rivalK_counter;
                    if (cki.Key == ConsoleKey.Enter)
                    {
                        //Determining the black pieces order
                        if (turner % 2 == 0)
                        {
                            Console.ForegroundColor = ConsoleColor.Blue;
                            Console.SetCursorPosition(40, 6);
                            Console.WriteLine("Blue's Turn");
                            Console.ResetColor();
                            Console.SetCursorPosition(cursorx, cursory);

                            while (true)
                            {
                                cki2 = Console.ReadKey(true);
                                //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                {
                                    Console.SetCursorPosition(cursorx, cursory);
                                    cursorx += 3;
                                }
                                if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                {
                                    Console.SetCursorPosition(cursorx, cursory);
                                    cursorx -= 3;
                                }
                                if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                {
                                    Console.SetCursorPosition(cursorx, cursory);
                                    cursory -= 1;
                                }
                                if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                {
                                    Console.SetCursorPosition(cursorx, cursory);
                                    cursory += 1;
                                }
                                Console.SetCursorPosition(cursorx, cursory);

                                int newy = (cursorx - 3) / 3;
                                int newx = cursory - 2;

                                // Defining pieces and their moves
                                if (array[cordx, cordy] == "P")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Black pawns' first movement
                                        if (cordx == 1)
                                        {
                                            if (newx == cordx + 2) //Move forward 2 steps
                                            {
                                                if (newy == cordy && array[newx, newy] == "." && array[cordx + 1, newy] == ".")
                                                {
                                                    array[newx, newy] = black_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            else if (newx == cordx + 1) //Move forward 1 steps
                                            {
                                                if (newy == cordy && array[newx, newy] == ".")
                                                {
                                                    array[newx, newy] = black_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }

                                                /*Move forward 1 steps and move 1 step right/left*/
                                                else if ((newy == cordy + 1 || newy == cordy - 1) && array[newx, newy] != "."
                                                    && array[newx, newy] != black_pieces[0] && array[newx, newy] != black_pieces[1] &&
                                                    array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[3] &&
                                                    array[newx, newy] != black_pieces[4] && array[newx, newy] != black_pieces[5])
                                                {
                                                    array[newx, newy] = black_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            else break;
                                        }
                                        //Black pawns' other movements
                                        else
                                        {
                                            //Controlling move 1 step forward
                                            if (newx == cordx + 1)
                                            {
                                                if (newy == cordy && array[newx, newy] == ".")
                                                {
                                                    if (newx != 7)
                                                    {
                                                        array[newx, newy] = black_pieces[5];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }

                                                    else if (newx == 7)
                                                    {
                                                        // Special movement (promotion) of pawn
                                                        Console.SetCursorPosition(1, 15);
                                                        Console.ForegroundColor = ConsoleColor.Cyan;
                                                        Console.Write("Which piece do you want? [1]-Queen  [2]-Bishop  [3]-Knight  " +
                                                            "[4]-Rook  [5]-Pawn  ");
                                                        promotion = Console.ReadLine();
                                                        Console.ResetColor();

                                                        if (promotion == "1")
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "2")
                                                        {
                                                            array[newx, newy] = black_pieces[2];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "3")
                                                        {
                                                            array[newx, newy] = black_pieces[1];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "4")
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "5")
                                                        {
                                                            array[newx, newy] = black_pieces[5];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else break;
                                                    }

                                                }

                                                else if ((newy == cordy + 1 || newy == cordy - 1) && array[newx, newy] != black_pieces[0]
                                                && array[newx, newy] != black_pieces[1] && array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[3]
                                                && array[newx, newy] != black_pieces[4] && array[newx, newy] != black_pieces[5])
                                                {
                                                    if (newx != 7)
                                                    {
                                                        if (newx == 5 && newy >= 0 && array[cordx, newy] == white_pieces[5])
                                                        {
                                                            //Controlling end of the game
                                                            if (array[newx, newy] == white_pieces[4])
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, newy] = ".";
                                                                array[cordx, cordy] = ".";
                                                                Console.SetCursorPosition(40, 2);
                                                                Console.ForegroundColor = ConsoleColor.Blue;
                                                                Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                                Console.ResetColor();
                                                                flag = false;
                                                            }
                                                            //Special movement(en passant) of pawn
                                                            else
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, newy] = ".";
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                        }
                                                        else if (newx == 5 && newy <= 7 && array[cordx, newy] == white_pieces[5])
                                                        {
                                                            //Controlling end of the game
                                                            if (array[newx, newy] == white_pieces[4])
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, newy] = ".";
                                                                array[cordx, cordy] = ".";
                                                                Console.SetCursorPosition(40, 2);
                                                                Console.ForegroundColor = ConsoleColor.Blue;
                                                                Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                                Console.ResetColor();
                                                                flag = false;
                                                            }

                                                            //Special movement(en passant) of pawn
                                                            else
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, newy] = ".";
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                        }
                                                        else if (array[newx, newy] != ".")
                                                        {
                                                            //Controlling end of the game
                                                            if (array[newx, newy] == white_pieces[4])
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, cordy] = ".";
                                                                Console.SetCursorPosition(40, 2);
                                                                Console.ForegroundColor = ConsoleColor.Blue;
                                                                Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                                Console.ResetColor();
                                                                flag = false;
                                                            }

                                                            else
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                        }
                                                        else break;

                                                    }
                                                    else if (newx == 7)
                                                    {
                                                        //Controlling end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[5];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                        }
                                                        // Special movement (promotion) of pawn
                                                        else
                                                        {
                                                            Console.SetCursorPosition(1, 15);
                                                            Console.ForegroundColor = ConsoleColor.Cyan;
                                                            Console.Write("Which piece do you want? [1]-Queen  [2]-Bishop  [3]-Knight  " +
                                                                "[4]-Rook  [5]-Pawn  ");
                                                            promotion = Console.ReadLine();
                                                            Console.ResetColor();

                                                            if (promotion == "1")
                                                            {
                                                                array[newx, newy] = black_pieces[3];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                            else if (promotion == "2")
                                                            {
                                                                array[newx, newy] = black_pieces[2];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                            else if (promotion == "3")
                                                            {
                                                                array[newx, newy] = black_pieces[1];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                            else if (promotion == "4")
                                                            {
                                                                array[newx, newy] = black_pieces[0];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                            else if (promotion == "5")
                                                            {
                                                                array[newx, newy] = black_pieces[5];
                                                                array[cordx, cordy] = ".";
                                                                turner++;
                                                            }
                                                            else break;
                                                        }
                                                    }
                                                }
                                                else break;
                                            }
                                            else break;
                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }

                                else if (array[cordx, cordy] == "R")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Controlling Pieces
                                        if (array[newx, newy] == white_pieces[0] || array[newx, newy] == white_pieces[1] ||
                                        array[newx, newy] == white_pieces[2] || array[newx, newy] == white_pieces[3] ||
                                        array[newx, newy] == white_pieces[4] || array[newx, newy] == white_pieces[5] ||
                                        array[newx, newy] == ".")
                                        {
                                            if (newx == cordx) //move left and right

                                            {
                                                //move  right
                                                if (newy > cordy)
                                                {
                                                    RQcounter = 0;

                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordy + 1; i < newy; i++)
                                                    {
                                                        if (array[newx, i] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newy - cordy - 1)
                                                    {
                                                        //Controlling end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                //move  left
                                                else if (newy < cordy)
                                                {
                                                    RQcounter2 = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int j = cordy - 1; j > newy; j--)
                                                    {
                                                        if (array[newx, j] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordy - newy - 1)
                                                    {
                                                        //Controlling end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            //Emplacing Piece
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                            //Moving forward and backward
                                            else if (newy == cordy)
                                            {
                                                //Moving forward
                                                if (newx > cordx)
                                                {
                                                    RQcounter = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        if (array[i, newy] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }

                                                    if (RQcounter == newx - cordx - 1)
                                                    {
                                                        //Controlling end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            //Emplacing Piece
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                //Moving backward
                                                else if (newx < cordx)
                                                {
                                                    RQcounter2 = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int j = cordx - 1; j > newx; j--)
                                                    {
                                                        if (array[j, newy] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordx - newx - 1)
                                                    {
                                                        //Controlling end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            //Emplacing Piece
                                                            array[newx, newy] = black_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                                else if (array[cordx, cordy] == "N")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Controlling Pieces
                                        if ((array[newx, newy] != black_pieces[0] && array[newx, newy] != black_pieces[1] &&
                                    array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[3] &&
                                    array[newx, newy] != black_pieces[4] && array[newx, newy] != black_pieces[5]))
                                        {
                                            //Move 2 steps forward and 1 step right
                                            if (newx == cordx + 2 && newy == cordy + 1)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 2 steps forward and 1 step left
                                            else if (newx == cordx + 2 && newy == cordy - 1)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 1 step forward and 2 steps right
                                            else if (newx == cordx + 1 && newy == cordy + 2)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 1 step forward and 2 steps left
                                            else if (newx == cordx + 1 && newy == cordy - 2)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 2 steps backward and 1 step right
                                            else if (newx == cordx - 2 && newy == cordy + 1)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 2 steps backward and 1 step left
                                            else if (newx == cordx - 2 && newy == cordy - 1)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 1 step backward and 2 steps right
                                            else if (newx == cordx - 1 && newy == cordy + 2)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Move 1 step backward and 2 steps left
                                            else if (newx == cordx - 1 && newy == cordy - 2)
                                            {
                                                //Controlling end of the game
                                                if (array[newx, newy] == white_pieces[4])
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else break;

                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }

                                else if (array[cordx, cordy] == "B")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Controlling Pieces
                                        if ((array[newx, newy] != black_pieces[0] && array[newx, newy] != black_pieces[1] &&
                                    array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[3] &&
                                    array[newx, newy] != black_pieces[4] && array[newx, newy] != black_pieces[5]) &&
                                    Math.Abs(cordx - newx) == Math.Abs(cordy - newy))
                                        {
                                            //Moving forward and left
                                            if (newx > cordx && newy < cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                //Determining that there are no parts between the first and last position
                                                for (int i = cordx + 1; i < newx; i++)
                                                {
                                                    new_BQ_control--;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 0)
                                                        break;
                                                }

                                                if (BQcounter == newx - cordx - 1)
                                                {
                                                    //Controlling the end of the game
                                                    if (array[newx, newy] == white_pieces[4])
                                                    {
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Blue;
                                                        Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        //Emplacing Piece
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                //Controlling Placing
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            //Moving forward and right
                                            else if (newx > cordx && newy > cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                //Determining that there are no parts between the first and last position
                                                for (int i = cordx + 1; i < newx; i++)
                                                {
                                                    new_BQ_control++;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 7)
                                                        break;
                                                }
                                                if (BQcounter == newx - cordx - 1)
                                                {
                                                    //Controlling the end of the game
                                                    if (array[newx, newy] == white_pieces[4])
                                                    {
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Blue;
                                                        Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        //Emplacing Piece
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                //Controlling Placing
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else
                                                    break;
                                            }
                                            //Moving backward and left
                                            else if (newx < cordx && newy < cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                //Determining that there are no parts between the first and last position
                                                for (int i = cordx - 1; i > newx; i--)
                                                {
                                                    new_BQ_control--;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 0)
                                                        break;
                                                }
                                                if (BQcounter == cordx - newx - 1)
                                                {
                                                    //Controlling the end of the game
                                                    if (array[newx, newy] == white_pieces[4])
                                                    {
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Blue;
                                                        Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        //Emplacing Piece
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                //Controlling Placing
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            //Moving backward and right
                                            else if (newx < cordx && newy > cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                //Determining that there are no parts between the first and last position
                                                for (int i = cordx - 1; i > newx; i--)
                                                {
                                                    new_BQ_control++;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 7)
                                                        break;
                                                }
                                                if (BQcounter == cordx - newx - 1)
                                                {
                                                    //Controlling the end of the game
                                                    if (array[newx, newy] == white_pieces[4])
                                                    {
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Blue;
                                                        Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        //Emplacing Piece
                                                        array[newx, newy] = black_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                //Controlling Placing
                                                else
                                                {
                                                    RBQ = false;
                                                }

                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            else break;
                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }

                                else if (array[cordx, cordy] == "Q")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Controlling Pieces
                                        if (array[newx, newy] != black_pieces[0] && array[newx, newy] != black_pieces[1] &&
                                    array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[4] &&
                                    array[newx, newy] != black_pieces[5])
                                        {
                                            //Move right and left
                                            if (newx == cordx)
                                            {
                                                //Move right
                                                if (newy > cordy)
                                                {
                                                    RQcounter = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordy + 1; i < newy; i++)
                                                    {
                                                        if (array[newx, i] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newy - cordy - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                //Move left
                                                else if (newy < cordy)
                                                {
                                                    RQcounter2 = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int j = cordy - 1; j > newy; j--)
                                                    {
                                                        if (array[newx, j] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }
                                                    if (RQcounter2 == cordy - newy - 1)
                                                    {
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            //Controlling the end of the game
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                            //Move backward and forward
                                            else if (newy == cordy)
                                            {
                                                //Move forward
                                                if (newx > cordx)
                                                {
                                                    RQcounter = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        if (array[i, newy] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newx - cordx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                //Move backward
                                                else if (newx < cordx)
                                                {
                                                    RQcounter2 = 0;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int j = cordx - 1; j > newx; j--)
                                                    {
                                                        if (array[j, newy] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordx - newx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                            //Controlling Diagonally Movement
                                            if (Math.Abs(cordx - newx) == Math.Abs(cordy - newy))
                                            {
                                                //Moving forward and left
                                                if (newx > cordx && newy < cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        new_BQ_control--;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 0)
                                                            break;
                                                    }
                                                    if (BQcounter == newx - cordx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                else if (newx > cordx && newy > cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        new_BQ_control++;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 7)
                                                            break;
                                                    }
                                                    if (BQcounter == newx - cordx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else
                                                        break;
                                                }
                                                else if (newx < cordx && newy < cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx - 1; i > newx; i--)
                                                    {
                                                        new_BQ_control--;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 0)
                                                            break;
                                                    }
                                                    if (BQcounter == cordx - newx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                                else if (newx < cordx && newy > cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    //Determining that there are no parts between the first and last position
                                                    for (int i = cordx - 1; i > newx; i--)
                                                    {
                                                        new_BQ_control++;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 7)
                                                            break;
                                                    }
                                                    if (BQcounter == cordx - newx - 1)
                                                    {
                                                        //Controlling the end of the game
                                                        if (array[newx, newy] == white_pieces[4])
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Blue;
                                                            Console.WriteLine("GAME OVER! Black(Blue) Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        //Emplacing Piece
                                                        else
                                                        {
                                                            array[newx, newy] = black_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    //Controlling Placing
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                else break;
                                            }
                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }

                                else if (array[cordx, cordy] == "K")
                                {
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        //Controlling Pieces
                                        if (array[newx, newy] != black_pieces[0] && array[newx, newy] != black_pieces[1] &&
                                    array[newx, newy] != black_pieces[2] && array[newx, newy] != black_pieces[3]
                                    && array[newx, newy] != black_pieces[5] &&
                                    ((newx == cordx - 1) || (newx == cordx) || (newx == cordx + 1)))
                                        {
                                            ////Moving backward and forward (left)
                                            if (newy == cordy - 1)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                //Controlling the drawn of the game
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "Kw")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                //Determining the end of the game
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }

                                            }
                                            //Moving backward and forward
                                            else if (newy == cordy)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                //Controlling the drawn of the game
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "Kw")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                //Determining the end of the game
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            //Moving backward and forward (right)
                                            else if (newy == cordy + 1)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                //Controlling the drawn of the game
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "Kw")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                //Determining the end of the game
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Blue;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                //Emplacing Piece
                                                else
                                                {
                                                    array[newx, newy] = black_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else break;
                                        }
                                        //Show the new screen
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }
                        }

                        if (turner % 2 == 1)
                        {
                            Console.ForegroundColor = ConsoleColor.Red;
                            Console.SetCursorPosition(40, 6);
                            Console.WriteLine("Red's Turn ");
                            Console.ResetColor();
                            Console.SetCursorPosition(cursorx, cursory);

                            if (array[cordx, cordy] == "Pw")
                            {
                                while (true)
                                {
                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)

                                    cki2 = Console.ReadKey(true);

                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;

                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if (cordx == 6)
                                        {
                                            if (newx == cordx - 2)
                                            {
                                                if (newy == cordy && array[newx, newy] == "." && array[cordx - 1, newy] == ".")
                                                {
                                                    array[newx, newy] = white_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                                else
                                                    break;
                                            }

                                            else if (newx == cordx - 1)
                                            {
                                                if (newy == cordy && array[newx, newy] == ".")
                                                {
                                                    array[newx, newy] = white_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }

                                                else if ((newy == cordy + 1 || newy == cordy - 1) && array[newx, newy] != "." && array[newx, newy] != white_pieces[0]
                                                    && array[newx, newy] != white_pieces[1] && array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3]
                                                    && array[newx, newy] != white_pieces[4] && array[newx, newy] != white_pieces[5])
                                                {
                                                    array[newx, newy] = white_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                                else
                                                    break;
                                            }
                                            else
                                                break;
                                        }
                                        else if (newx == cordx - 1)
                                        {

                                            if (newy == cordy && array[newx, newy] == ".")
                                            {
                                                if (newx != 0)
                                                {
                                                    array[newx, newy] = white_pieces[5];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                                else if (newx == 0)
                                                {
                                                    Console.SetCursorPosition(1, 15);
                                                    Console.ForegroundColor = ConsoleColor.Magenta;
                                                    Console.Write("Which piece do you want? [1]-Queen  [2]-Bishop  [3]-Knight  " +
                                                        "[4]-Rook  [5]-Pawn  ");
                                                    promotion = Console.ReadLine();
                                                    Console.ResetColor();

                                                    if (promotion == "1")
                                                    {
                                                        array[newx, newy] = white_pieces[3];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }
                                                    else if (promotion == "2")
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }
                                                    else if (promotion == "3")
                                                    {
                                                        array[newx, newy] = white_pieces[1];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }
                                                    else if (promotion == "4")
                                                    {
                                                        array[newx, newy] = white_pieces[0];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }
                                                    else if (promotion == "5")
                                                    {
                                                        array[newx, newy] = white_pieces[5];
                                                        array[cordx, cordy] = ".";
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                            }
                                            else if ((newy == cordy + 1 || newy == cordy - 1) &&
                                                array[newx, newy] != white_pieces[0] && array[newx, newy] != white_pieces[1] &&
                                                array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3]
                                                && array[newx, newy] != white_pieces[4] && array[newx, newy] != white_pieces[5])
                                            {
                                                if (newx != 0)
                                                {

                                                    if (newx == 2 && newy >= 0 && array[cordx, newy] == black_pieces[5])
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, newy] = ".";
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, newy] = ".";
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                    }

                                                    else if (newx == 2 && newy <= 7 && array[cordx, newy] == black_pieces[5])
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, newy] = ".";
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, newy] = ".";
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                    }
                                                    else if (array[newx, newy] != ".")
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                    }
                                                    else break;
                                                }
                                                else if (newx == 0)
                                                {
                                                    if (array[newx, newy] == black_pieces[4])
                                                    {
                                                        array[newx, newy] = white_pieces[5];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Red;
                                                        Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                        Console.ResetColor();
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        Console.SetCursorPosition(1, 15);
                                                        Console.ForegroundColor = ConsoleColor.Magenta;
                                                        Console.Write("Which piece do you want? [1]-Queen  [2]-Bishop  [3]-Knight  " +
                                                            "[4]-Rook  [5]-Pawn  ");
                                                        promotion = Console.ReadLine();
                                                        Console.ResetColor();

                                                        if (promotion == "1")
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "2")
                                                        {
                                                            array[newx, newy] = white_pieces[2];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "3")
                                                        {
                                                            array[newx, newy] = white_pieces[1];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "4")
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else if (promotion == "5")
                                                        {
                                                            array[newx, newy] = white_pieces[5];
                                                            array[cordx, cordy] = ".";
                                                            turner++;
                                                        }
                                                        else break;
                                                    }
                                                }
                                            }
                                            else break;
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);

                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }

                            else if (array[cordx, cordy] == "Rw")
                            {
                                while (true)
                                {
                                    cki2 = Console.ReadKey(true);

                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;

                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if (array[newx, newy] == black_pieces[0] || array[newx, newy] == black_pieces[1] ||
                                        array[newx, newy] == black_pieces[2] || array[newx, newy] == black_pieces[3] ||
                                        array[newx, newy] == black_pieces[4] || array[newx, newy] == black_pieces[5] ||
                                        array[newx, newy] == ".")
                                        {
                                            if (newx == cordx)
                                            {
                                                if (newy > cordy)
                                                {
                                                    RQcounter = 0;
                                                    for (int i = cordy + 1; i < newy; i++)
                                                    {
                                                        if (array[newx, i] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newy - cordy - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                                else if (newy < cordy)
                                                {
                                                    RQcounter2 = 0;
                                                    for (int j = cordy - 1; j > newy; j--)
                                                    {
                                                        if (array[newx, j] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordy - newy - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }

                                            else if (newy == cordy)
                                            {
                                                if (newx > cordx)
                                                {
                                                    RQcounter = 0;
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        if (array[i, newy] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }

                                                    if (RQcounter == newx - cordx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                                else if (newx < cordx)
                                                {
                                                    RQcounter2 = 0;
                                                    for (int j = cordx - 1; j > newx; j--)
                                                    {
                                                        if (array[j, newy] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordx - newx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)   Wins!");
                                                            Console.ResetColor();
                                                            flag = false;
                                                            RBQ = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[0];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else
                                                        break;
                                                }
                                            }
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }

                            else if (array[cordx, cordy] == "Nw")
                            {
                                while (true)
                                {
                                    cki2 = Console.ReadKey(true);
                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;

                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if ((array[newx, newy] != white_pieces[0] && array[newx, newy] != white_pieces[1] &&
                                    array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3] &&
                                    array[newx, newy] != white_pieces[4] && array[newx, newy] != white_pieces[5]))
                                        {
                                            if (newx == cordx + 2 && newy == cordy + 1)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx + 2 && newy == cordy - 1)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx + 1 && newy == cordy + 2)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx + 1 && newy == cordy - 2)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx - 2 && newy == cordy + 1)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx - 2 && newy == cordy - 1)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx - 1 && newy == cordy + 2)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newx == cordx - 1 && newy == cordy - 2)
                                            {
                                                if (array[newx, newy] == black_pieces[4])
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[1];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else
                                                break;
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }

                            else if (array[cordx, cordy] == "Bw")
                            {
                                while (true)
                                {
                                    cki2 = Console.ReadKey(true);

                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;
                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if ((array[newx, newy] != white_pieces[0] && array[newx, newy] != white_pieces[1] &&
                                    array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3] &&
                                    array[newx, newy] != white_pieces[4] && array[newx, newy] != white_pieces[5]) &&
                                    Math.Abs(cordx - newx) == Math.Abs(cordy - newy))
                                        {
                                            if (newx > cordx && newy < cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                for (int i = cordx + 1; i < newx; i++)
                                                {
                                                    new_BQ_control--;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 0)
                                                        break;
                                                }
                                                if (BQcounter == newx - cordx - 1)
                                                {
                                                    if (array[newx, newy] == black_pieces[4])
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Red;
                                                        Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            else if (newx > cordx && newy > cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                for (int i = cordx + 1; i < newx; i++)
                                                {
                                                    new_BQ_control++;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 7)
                                                        break;
                                                }
                                                if (BQcounter == newx - cordx - 1)
                                                {
                                                    if (array[newx, newy] == black_pieces[4])
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Red;
                                                        Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else
                                                    break;
                                            }
                                            else if (newx < cordx && newy < cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;
                                                for (int i = cordx - 1; i > newx; i--)
                                                {
                                                    new_BQ_control--;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 0)
                                                        break;
                                                }
                                                if (BQcounter == cordx - newx - 1)
                                                {
                                                    if (array[newx, newy] == black_pieces[4])
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Red;
                                                        Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                else
                                                {
                                                    RBQ = false;
                                                }
                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }

                                            else if (newx < cordx && newy > cordy)
                                            {
                                                BQcounter = 0;
                                                new_BQ_control = cordy;

                                                for (int i = cordx - 1; i > newx; i--)
                                                {
                                                    new_BQ_control++;
                                                    if (array[i, new_BQ_control] == ".")
                                                    {
                                                        BQcounter++;
                                                    }
                                                    if (new_BQ_control == 7)
                                                        break;
                                                }
                                                if (BQcounter == cordx - newx - 1)
                                                {
                                                    if (array[newx, newy] == black_pieces[4])
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        Console.SetCursorPosition(40, 2);
                                                        Console.ForegroundColor = ConsoleColor.Red;
                                                        Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                        Console.ResetColor();
                                                        RBQ = false;
                                                        flag = false;
                                                    }
                                                    else
                                                    {
                                                        array[newx, newy] = white_pieces[2];
                                                        array[cordx, cordy] = ".";
                                                        RBQ = true;
                                                    }
                                                }
                                                else
                                                {
                                                    RBQ = false;
                                                }

                                                if (RBQ == true)
                                                {
                                                    turner++;
                                                }
                                                else break;
                                            }
                                            else break;
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }

                            else if (array[cordx, cordy] == "Qw")
                            {
                                while (true)
                                {
                                    cki2 = Console.ReadKey(true);

                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;

                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if ((array[newx, newy] != white_pieces[0] && array[newx, newy] != white_pieces[1] &&
                                    array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3] &&
                                    array[newx, newy] != white_pieces[4] && array[newx, newy] != white_pieces[5]))
                                        {
                                            if (newx == cordx)
                                            {
                                                if (newy > cordy)
                                                {
                                                    RQcounter = 0;
                                                    for (int i = cordy + 1; i < newy; i++)
                                                    {
                                                        if (array[newx, i] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newy - cordy - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                else if (newy < cordy)
                                                {
                                                    RQcounter2 = 0;
                                                    for (int j = cordy - 1; j > newy; j--)
                                                    {
                                                        if (array[newx, j] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }
                                                    if (RQcounter2 == cordy - newy - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                            else if (newy == cordy)
                                            {
                                                if (newx > cordx)
                                                {
                                                    RQcounter = 0;
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        if (array[i, newy] == ".")
                                                        {
                                                            RQcounter++;
                                                        }
                                                    }
                                                    if (RQcounter == newx - cordx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                                else if (newx < cordx)
                                                {
                                                    RQcounter2 = 0;
                                                    for (int j = cordx - 1; j > newx; j--)
                                                    {
                                                        if (array[j, newy] == ".")
                                                        {
                                                            RQcounter2++;
                                                        }
                                                    }

                                                    if (RQcounter2 == cordx - newx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                            }
                                            if (Math.Abs(cordx - newx) == Math.Abs(cordy - newy))
                                            {
                                                if (newx > cordx && newy < cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        new_BQ_control--;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 0)
                                                            break;
                                                    }
                                                    if (BQcounter == newx - cordx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                else if (newx > cordx && newy > cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    for (int i = cordx + 1; i < newx; i++)
                                                    {
                                                        new_BQ_control++;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 7)
                                                            break;
                                                    }
                                                    if (BQcounter == newx - cordx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else
                                                        break;
                                                }
                                                else if (newx < cordx && newy < cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;
                                                    for (int i = cordx - 1; i > newx; i--)
                                                    {
                                                        new_BQ_control--;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 0)
                                                            break;
                                                    }
                                                    if (BQcounter == cordx - newx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }
                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }

                                                else if (newx < cordx && newy > cordy)
                                                {
                                                    BQcounter = 0;
                                                    new_BQ_control = cordy;

                                                    for (int i = cordx - 1; i > newx; i--)
                                                    {
                                                        new_BQ_control++;
                                                        if (array[i, new_BQ_control] == ".")
                                                        {
                                                            BQcounter++;
                                                        }
                                                        if (new_BQ_control == 7)
                                                            break;
                                                    }
                                                    if (BQcounter == cordx - newx - 1)
                                                    {
                                                        if (array[newx, newy] == black_pieces[4])
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            Console.SetCursorPosition(40, 2);
                                                            Console.ForegroundColor = ConsoleColor.Red;
                                                            Console.WriteLine("GAME OVER! White(Red)  Wins!");
                                                            Console.ResetColor();
                                                            RBQ = false;
                                                            flag = false;
                                                        }
                                                        else
                                                        {
                                                            array[newx, newy] = white_pieces[3];
                                                            array[cordx, cordy] = ".";
                                                            RBQ = true;
                                                        }
                                                    }
                                                    else
                                                    {
                                                        RBQ = false;
                                                    }

                                                    if (RBQ == true)
                                                    {
                                                        turner++;
                                                    }
                                                    else break;
                                                }
                                                else break;
                                            }
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }

                            else if (array[cordx, cordy] == "Kw")
                            {
                                while (true)
                                {
                                    cki2 = Console.ReadKey(true);
                                    //  Moving the cursor in x-y direction ( This part provides the movement of the pieces)
                                    if (cki2.Key == ConsoleKey.RightArrow && cursorx < 22)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx += 3;
                                    }
                                    if (cki2.Key == ConsoleKey.LeftArrow && cursorx > 3)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursorx -= 3;
                                    }
                                    if (cki2.Key == ConsoleKey.UpArrow && cursory > 2)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory -= 1;
                                    }
                                    if (cki2.Key == ConsoleKey.DownArrow && cursory < 9)
                                    {
                                        Console.SetCursorPosition(cursorx, cursory);
                                        cursory += 1;
                                    }
                                    Console.SetCursorPosition(cursorx, cursory);

                                    int newy = (cursorx - 3) / 3;
                                    int newx = cursory - 2;

                                    if (cki2.Key == ConsoleKey.Enter)
                                    {
                                        if (array[newx, newy] != white_pieces[0] && array[newx, newy] != white_pieces[1] &&
                                    array[newx, newy] != white_pieces[2] && array[newx, newy] != white_pieces[3]
                                    && array[newx, newy] != white_pieces[5] &&
                                    ((newx == cordx - 1) || (newx == cordx) || (newx == cordx + 1)))
                                        {

                                            if (newy == cordy - 1)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "K")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newy == cordy)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "K")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else if (newy == cordy + 1)
                                            {
                                                Kcounter = 0;
                                                rivalK_counter = 0;
                                                for (int i = 0; i < array.GetLength(0); i++)
                                                {
                                                    for (int j = 0; j < array.GetLength(1); j++)
                                                    {
                                                        if (array[i, j] == ".")
                                                        {
                                                            Kcounter++;
                                                        }
                                                        if (array[i, j] == "K")
                                                        {
                                                            rivalK_counter++;
                                                        }
                                                    }
                                                }
                                                if (Kcounter == 62 && rivalK_counter == 1)
                                                {
                                                    Console.SetCursorPosition(40, 2);
                                                    Console.ForegroundColor = ConsoleColor.Red;
                                                    Console.WriteLine("GAME OVER! Dead Position Determined! The game is drawn!");
                                                    Console.ResetColor();
                                                    flag = false;
                                                }
                                                else
                                                {
                                                    array[newx, newy] = white_pieces[4];
                                                    array[cordx, cordy] = ".";
                                                    turner++;
                                                }
                                            }
                                            else break;
                                        }
                                        Console.SetCursorPosition(0, 2);
                                        GameScreen(array, white_pieces, black_pieces);
                                        Console.ReadLine();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}