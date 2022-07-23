double total_score = 0;

//Console Coloring
Console.BackgroundColor = ConsoleColor.White;
Console.Clear();
Console.ForegroundColor = ConsoleColor.Black;

ConsoleKeyInfo cki;

int cursorx = 5, cursory = 4;
//Necessary console screen  elements 
Console.SetCursorPosition(53, 1);
Console.WriteLine(">> New Piece << ");

Console.SetCursorPosition(80, 1);
Console.WriteLine("Score: ");

Console.SetCursorPosition(80, 5);
Console.WriteLine("Piece: ");

Console.SetCursorPosition(53, 10);
Console.WriteLine("Calculation: ");
// Creating a 9*9 integer based game screen
int[,] game_screen = new int[9, 9];
for (int i = 0; i < game_screen.GetLength(0); i++)
{
    for (int j = 0; j < game_screen.GetLength(1); j++)
    {
        game_screen[i, j] = -1;
    }
}
//Creating game screen in right order 
Console.SetCursorPosition(2, 0);
Console.WriteLine("   1   2   3   4   5   6   7   8   9");
for (int i = 0; i < game_screen.GetLength(0); i++)
{
    if (i % 3 == 0)
    {
        Console.WriteLine("   +-----------+-----------+-----------+");
    }
    Console.Write(i + 1 + "  ");
    for (int j = 0; j < game_screen.GetLength(1); j++)
    {
        if (j % 3 == 0)
            Console.Write("|");
        if (j % 3 == 1 && game_screen[i, (j + 1) / 3] == -1)
        {
            Console.Write("  " + "." + "  ");
        }
        else
            Console.Write(" " + "." + " ");
    }
    if (i != 2 && i != 5 && i != 8)
        Console.WriteLine("|\n   |           |           |           |");
    else
        Console.WriteLine("|");
}
Console.WriteLine("   +-----------+-----------+-----------+");



// Creating first new piece outside of loop
int[,] new_piece = new int[3, 3];
Random rndm = new Random();
//Generating random piece
int new_piece_random = rndm.Next(1, 11);

//Generating random 0 and 1's
Random random2 = new Random();
int a, b, c, d;

//Generating pieces respectively to their size
a = random2.Next(0, 2);
b = random2.Next(0, 2);
c = random2.Next(0, 2);
d = random2.Next(0, 2);
if (new_piece_random == 1)
{
    new_piece[0, 0] = a;
}
if (new_piece_random == 2)
{
    new_piece[0, 0] = a;
    new_piece[0, 1] = b;
}
if (new_piece_random == 3)
{
    new_piece[0, 0] = a;
    new_piece[1, 0] = b;
}
if (new_piece_random == 4)
{
    new_piece[0, 0] = a;
    new_piece[0, 1] = b;
    new_piece[0, 2] = c;
}
if (new_piece_random == 5)
{
    new_piece[0, 0] = a;
    new_piece[1, 0] = b;
    new_piece[2, 0] = c;
}
if (new_piece_random == 6)
{
    new_piece[0, 0] = a;
    new_piece[0, 1] = b;
    new_piece[1, 0] = c;
}
if (new_piece_random == 7)
{
    new_piece[0, 0] = a;
    new_piece[0, 1] = b;
    new_piece[1, 1] = c;
}
if (new_piece_random == 8)
{
    new_piece[0, 0] = a;
    new_piece[1, 0] = b;
    new_piece[1, 1] = c;
}
if (new_piece_random == 9)
{
    new_piece[0, 1] = a;
    new_piece[1, 0] = b;
    new_piece[1, 1] = c;
}
if (new_piece_random == 10)
{
    new_piece[0, 0] = a;
    new_piece[0, 1] = b;
    new_piece[1, 0] = c;
    new_piece[1, 1] = d;
}
// Writing first new piece below "New Piece"
Console.SetCursorPosition(56, 3);
if (new_piece_random == 1)
    Console.Write(a);
if (new_piece_random == 2)
    Console.Write(a + "   " + b);
if (new_piece_random == 3)
    Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b);
if (new_piece_random == 4)
    Console.Write(a + "   " + b + "   " + c);
if (new_piece_random == 5)
    Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b + "\n\n\t\t\t\t\t\t\t" + c);
if (new_piece_random == 6)
    Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t" + c);
if (new_piece_random == 7)
    Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t    " + c);
if (new_piece_random == 8)
    Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b + "   " + c);
if (new_piece_random == 9)
    Console.Write("    " + a + "\n\n\t\t\t\t\t\t\t" + b + "   " + c);
if (new_piece_random == 10)
    Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t" + c + "   " + d);
// Gameplay Process
int piece_counter = 0;
while (true)
{   //Variables
    double score = 0;
    double block_sum = 0;
    double row_sum = 0;
    double col_sum = 0;

    if (Console.KeyAvailable)
    {   //Placing pieces on the board with the help of "Enter" key 
        cki = Console.ReadKey(true);
        if (cki.Key == ConsoleKey.Enter)
        {
            for (int i = 0; i < game_screen.GetLength(0); i++)
            {   //Conditions for new piece random 1 
                for (int j = 0; j < game_screen.GetLength(1); j++)
                {
                    if (new_piece_random == 1 && game_screen[i, j] == -1 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j))
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        Console.WriteLine(a);

                        piece_counter++;
                    }
                    //Conditions for new piece random 2 
                    else if (new_piece_random == 2 && cursory < 19 && cursorx < 36 && i < 8 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i + 1, j] == -1)
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i + 1, j] = b;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx + 4, cursory);
                        Console.WriteLine(b);


                        piece_counter++;
                    }
                    //Conditions for new piece random 3 
                    else if (j < 8 && new_piece_random == 3 && cursory < 18 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i, j + 1] == -1)
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i, j + 1] = b;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(b);


                        piece_counter++;
                    }
                    //Conditions for new piece random 4 
                    else if (new_piece_random == 4 && cursorx < 32 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i + 1, j] == -1 && game_screen[i + 2, j] == -1)
                    {

                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i + 1, j] = b;
                        game_screen[i + 2, j] = c;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx + 4, cursory);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx + 8, cursory);
                        Console.WriteLine(c);


                        piece_counter++;
                    }
                    //Conditions for new piece random 5 
                    else if (new_piece_random == 5 && cursory < 16 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i, j + 1] == -1 && game_screen[i, j + 2] == -1)
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i, j + 1] = b;
                        game_screen[i, j + 2] = c;

                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx, cursory + 4);
                        Console.WriteLine(c);


                        piece_counter++;
                    }
                    //Conditions for new piece random 6 
                    else if (new_piece_random == 6 && cursory < 18 && cursorx < 36 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i + 1, j] == -1 && game_screen[i, j + 1] == -1)
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i + 1, j] = b;
                        game_screen[i, j + 1] = c;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx + 4, cursory);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(c);


                        piece_counter++;
                    }
                    //Conditions for new piece random 7 
                    else if (new_piece_random == 7 && cursory < 18 && cursorx < 36 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i + 1, j] == -1 && game_screen[i + 1, j + 1] == -1)
                    {
                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i + 1, j] = b;
                        game_screen[i + 1, j + 1] = c;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx + 4, cursory);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx + 4, cursory + 2);
                        Console.WriteLine(c);


                        piece_counter++;
                    }
                    //Conditions for new piece random 8
                    else if (new_piece_random == 8 && cursory < 18 && cursorx < 36 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i, j + 1] == -1 && game_screen[i + 1, j + 1] == -1)
                    {

                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i, j + 1] = b;
                        game_screen[i + 1, j + 1] = c;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx + 4, cursory + 2);
                        Console.WriteLine(c);


                        piece_counter++;
                    }
                    //Conditions for new piece random 9
                    else if (i < 8 && j < 8 && new_piece_random == 9 && cursory < 18 && cursorx > 7 && cursorx == 9 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i + 1, j] == -1 && game_screen[i, j + 1] == -1 && game_screen[i + 1, j + 1] == -1)
                    {


                        //Inserting the piece in proper position
                        game_screen[i + 1, j] = a;
                        game_screen[i, j + 1] = b;
                        game_screen[i + 1, j + 1] = c;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx - 4, cursory + 2);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(c);


                        piece_counter++;

                    }
                    //Conditions for new piece random 10
                    else if (new_piece_random == 10 && cursory < 18 && cursorx < 36 && cursorx == 5 + (4 * i) && cursory == 2 + (2 * j) && game_screen[i, j] == -1 && game_screen[i, j + 1] == -1 && game_screen[i + 1, j] == -1 && game_screen[i + 1, j + 1] == -1)
                    {

                        //Inserting the piece in proper position
                        game_screen[i, j] = a;
                        game_screen[i, j + 1] = b;
                        game_screen[i + 1, j] = c;
                        game_screen[i + 1, j + 1] = d;
                        Console.WriteLine(a);
                        Console.SetCursorPosition(cursorx + 4, cursory);
                        Console.WriteLine(b);
                        Console.SetCursorPosition(cursorx, cursory + 2);
                        Console.WriteLine(c);
                        Console.SetCursorPosition(cursorx + 4, cursory + 2);
                        Console.WriteLine(d);
                        piece_counter++;
                    }
                }
            }
            //Counting of pieces
            Console.SetCursorPosition(88, 5);
            Console.WriteLine(piece_counter);
            Console.SetCursorPosition(56, 3); Console.WriteLine("           ");
            Console.SetCursorPosition(56, 5); Console.WriteLine("           ");
            Console.SetCursorPosition(56, 7); Console.WriteLine("           ");

            //Creating random new pieces that contains 0 and 1's
            new_piece_random = rndm.Next(1, 11);
            a = random2.Next(0, 2);
            b = random2.Next(0, 2);
            c = random2.Next(0, 2);
            d = random2.Next(0, 2);
            if (new_piece_random == 1)
            {
                new_piece[0, 0] = a;
            }
            if (new_piece_random == 2)
            {
                new_piece[0, 0] = a;
                new_piece[0, 1] = b;
            }
            if (new_piece_random == 3)
            {
                new_piece[0, 0] = a;
                new_piece[1, 0] = b;
            }
            if (new_piece_random == 4)
            {
                new_piece[0, 0] = a;
                new_piece[0, 1] = b;
                new_piece[0, 2] = c;
            }
            if (new_piece_random == 5)
            {
                new_piece[0, 0] = a;
                new_piece[1, 0] = b;
                new_piece[2, 0] = c;
            }
            if (new_piece_random == 6)
            {
                new_piece[0, 0] = a;
                new_piece[0, 1] = b;
                new_piece[1, 0] = c;
            }
            if (new_piece_random == 7)
            {
                new_piece[0, 0] = a;
                new_piece[0, 1] = b;
                new_piece[1, 1] = c;
            }
            if (new_piece_random == 8)
            {
                new_piece[0, 0] = a;
                new_piece[1, 0] = b;
                new_piece[1, 1] = c;
            }
            if (new_piece_random == 9)
            {
                new_piece[0, 1] = a;
                new_piece[1, 0] = b;
                new_piece[1, 1] = c;
            }
            if (new_piece_random == 10)
            {
                new_piece[0, 0] = a;
                new_piece[0, 1] = b;
                new_piece[1, 0] = c;
                new_piece[1, 1] = d;
            }
            // Placing game pieces below "New Piece"
            Console.SetCursorPosition(56, 3);
            if (new_piece_random == 1)
                Console.Write(a);
            if (new_piece_random == 2)
                Console.Write(a + "   " + b);
            if (new_piece_random == 3)
                Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b);
            if (new_piece_random == 4)
                Console.Write(a + "   " + b + "   " + c);
            if (new_piece_random == 5)
                Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b + "\n\n\t\t\t\t\t\t\t" + c);
            if (new_piece_random == 6)
                Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t" + c);
            if (new_piece_random == 7)
                Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t    " + c);
            if (new_piece_random == 8)
                Console.Write(a + "\n\n\t\t\t\t\t\t\t" + b + "   " + c);
            if (new_piece_random == 9)
                Console.Write("    " + a + "\n\n\t\t\t\t\t\t\t" + b + "   " + c);
            if (new_piece_random == 10)
                Console.Write(a + "   " + b + "\n\n\t\t\t\t\t\t\t" + c + "   " + d);
            //Game over controls          
            bool over = false;
            bool[,] gameover = new bool[9, 9];
            for (int j = 0; j < game_screen.GetLength(0); j++)
            {
                for (int i = 0; i < game_screen.GetLength(1); i++)
                {

                    if (game_screen[i, j] == -1)
                        gameover[i, j] = true;
                    else gameover[i, j] = false;
                }
            }

            for (int i = 0; i < game_screen.GetLength(1); i++)
            {
                for (int j = 0; j < game_screen.GetLength(0); j++)
                {
                    if (new_piece_random == 1)
                    {
                        //Conditions if game finisher piece is new piece random 1
                        if (gameover[i, j] == true)
                            over = true;
                    }

                    if (i < 8 && new_piece_random == 2)
                    {
                        //Conditions if game finisher piece is new piece random 2
                        if (gameover[i, j] == true && gameover[i + 1, j] == true)
                            over = true;
                    }
                    if (j < 8 && new_piece_random == 3)
                    {
                        //Conditions if game finisher piece is new piece random 3
                        if (gameover[i, j] == true && gameover[i, j + 1] == true)
                            over = true;
                    }
                    if (i < 7 && new_piece_random == 4)
                    {
                        //Conditions if game finisher piece is new piece random 4
                        if (gameover[i, j] == true && gameover[i + 1, j] == true && gameover[i + 1, j] == true)
                            over = true;
                    }
                    if (j < 7 && new_piece_random == 5)
                    {
                        //Conditions if game finisher piece is new piece random 5
                        if (gameover[i, j] == true && gameover[i, j + 1] == true && gameover[i, j + 1] == true)
                            over = true;
                    }
                    if (j < 8 && i < 8 && new_piece_random == 6)
                    {
                        //Conditions if game finisher piece is new piece random 6
                        if (gameover[i, j] == true && gameover[i + 1, j] == true && gameover[i, j + 1] == true)
                            over = true;
                    }
                    if (i < 8 && j < 8 && new_piece_random == 7)
                    {
                        //Conditions if game finisher piece is new piece random 7
                        if (gameover[i, j] == true && gameover[i + 1, j] == true && gameover[i + 1, j + 1] == true)
                            over = true;
                    }
                    if (i < 8 && j < 8 && new_piece_random == 8)
                    {
                        //Conditions if game finisher piece is new piece random 8
                        if (gameover[i, j] == true && gameover[i, j + 1] == true && gameover[i + 1, j + 1] == true)
                            over = true;
                    }
                    if (i < 8 && j < 8 && new_piece_random == 9)
                    {
                        //Conditions if game finisher piece is new piece random 9
                        if (gameover[i + 1, j] == true && gameover[i, j + 1] == true && gameover[i + 1, j + 1] == true)
                            over = true;
                    }
                    if (i < 8 && j < 8 && new_piece_random == 10)
                    {
                        //Conditions if game finisher piece is new piece random 10
                        if (game_screen[i, j] != -1 && game_screen[i, j + 1] != -1 && game_screen[i + 1, j] != -1 && game_screen[i + 1, j + 1] != -1)
                            over = false;
                        else
                            over = true;
                    }
                }
            }
            // Indicating that game is over 
            if (over == false)
            {
                Console.SetCursorPosition(17, 10);
                Console.WriteLine("Game Over");
                break;
            }
            //Calculating combination of rows, columns and blocks
            for (int k = 0; k < game_screen.GetLength(0); k++)
            {
                for (int m = 0; m < game_screen.GetLength(1); m++)
                {
                    for (int i = 0; i < game_screen.GetLength(0) - 2; i += 3)
                    {
                        for (int j = 0; j < game_screen.GetLength(1) - 2; j += 3)
                        {
                            if (game_screen[0, k] != -1 && game_screen[1, k] != -1 && game_screen[2, k] != -1 && game_screen[3, k] != -1 && game_screen[4, k] != -1 && game_screen[5, k] != -1 && game_screen[6, k] != -1 && game_screen[7, k] != -1 && game_screen[8, k] != -1 && game_screen[m, 0] != -1 && game_screen[m, 1] != -1 && game_screen[m, 2] != -1 && game_screen[m, 3] != -1 && game_screen[m, 4] != -1 && game_screen[m, 5] != -1 && game_screen[m, 6] != -1 && game_screen[m, 7] != -1 && game_screen[m, 8] != -1 && game_screen[i, j] != -1 && game_screen[i + 1, j] != -1 && game_screen[i + 2, j] != -1 && game_screen[i, j + 1] != -1 && game_screen[i + 1, j + 1] != -1 && game_screen[i + 2, j + 1] != -1 && game_screen[i, j + 2] != -1 && game_screen[i + 1, j + 2] != -1 && game_screen[i + 2, j + 2] != -1)
                            {   //Calculation of block
                                block_sum = (game_screen[i, j] * Math.Pow(2, 8)) + (game_screen[i + 1, j] * Math.Pow(2, 7)) + (game_screen[i + 2, j] * Math.Pow(2, 6)) +
                                (game_screen[i, j + 1] * Math.Pow(2, 5)) + (game_screen[i + 1, j + 1] * Math.Pow(2, 4)) + (game_screen[i + 2, j + 1] * Math.Pow(2, 3)) +
                                (game_screen[i, j + 2] * Math.Pow(2, 2)) + (game_screen[i + 1, j + 2] * Math.Pow(2, 1)) + (game_screen[i + 2, j + 2] * Math.Pow(2, 0));
                                score += block_sum;
                                //Calculation of column
                                for (int l = 0; l < game_screen.GetLength(0); l++)
                                {
                                    col_sum += (game_screen[m, l] * Math.Pow(2, game_screen.GetLength(1) - l - 1));
                                }
                                score += col_sum;
                                for (int l = 0; l < game_screen.GetLength(0); l++)
                                {
                                    row_sum += (game_screen[l, k] * Math.Pow(2, game_screen.GetLength(1) - l - 1));
                                }
                                score += row_sum;
                                //Bonus for filling at the same time(x3 bonus)
                                total_score += score * 3;
                                //Showing the results to console area
                                Console.SetCursorPosition(87, 1);
                                Console.WriteLine(total_score);
                                Console.SetCursorPosition(52, 11);
                                Console.Write("(" + game_screen[i, j] + "" + game_screen[i + 1, j] + "" + game_screen[i + 2, j] + "" + game_screen[i, j + 1] + "" + game_screen[i + 1, j + 1] + "" + game_screen[i + 2, j + 1] + "" + game_screen[i, j + 2] + "" + game_screen[i + 1, j + 2] + "" + game_screen[i + 2, j + 2] + ")2=(" + block_sum + ")10        ");
                                Console.SetCursorPosition(52, 12);
                                Console.Write("(" + game_screen[m, 0] + "" + game_screen[m, 1] + "" + game_screen[m, 2] + "" + game_screen[m, 3] + "" + game_screen[m, 4] + "" + game_screen[m, 5] + "" + game_screen[m, 6] + "" + game_screen[m, 7] + "" + game_screen[m, 8] + ")2=(" + col_sum + ")10            ");
                                Console.SetCursorPosition(52, 13);
                                Console.Write("(" + game_screen[0, k] + "" + game_screen[1, k] + "" + game_screen[2, k] + "" + game_screen[3, k] + "" + game_screen[4, k] + "" + game_screen[5, k] + "" + game_screen[6, k] + "" + game_screen[7, k] + "" + game_screen[8, k] + ")2=(" + row_sum + ")10        ");
                                Console.SetCursorPosition(52, 14);
                                Console.WriteLine("(" + row_sum + "+" + col_sum + "+" + block_sum + ")=" + score + "           ");
                                Console.SetCursorPosition(52, 15);
                                Console.WriteLine(score + "*3=" + score * 3 + "        ");
                                //Turning pieces into their first definition 
                                game_screen[i, j] = -1; game_screen[i + 1, j] = -1; game_screen[i + 2, j] = -1;
                                game_screen[i, j + 1] = -1; game_screen[i + 1, j + 1] = -1; game_screen[i + 2, j + 1] = -1;
                                game_screen[i, j + 2] = -1; game_screen[i + 1, j + 2] = -1; game_screen[i + 2, j + 2] = -1;

                                //Transforming numbers into dots(.) again 
                                for (int l = i; l < i + 3; l++)
                                {
                                    Console.SetCursorPosition(4 * l + 5, 2 * j + 2);
                                    Console.Write(".");
                                    Console.SetCursorPosition(4 * l + 5, 2 * j + 4);
                                    Console.Write(".");
                                    Console.SetCursorPosition(4 * l + 5, 2 * j + 6);
                                    Console.Write(".");
                                }
                                Console.WriteLine();
                                //Turning pieces into their first definition 
                                for (int l = 0; l < game_screen.GetLength(0); l++)
                                    game_screen[m, l] = -1;
                                //Transforming numbers into dots(.) again
                                for (int l = 0; l < game_screen.GetLength(1); l++)
                                {
                                    Console.SetCursorPosition(4 * m + 5, 2 * l + 2);
                                    Console.WriteLine(".");
                                }
                                //Turning pieces into their first definition 
                                for (int l = 0; l < game_screen.GetLength(1); l++)
                                    game_screen[l, k] = -1;

                                //Transforming numbers into dots(.) again 
                                for (int l = 0; l < game_screen.GetLength(1); l++)
                                {
                                    Console.SetCursorPosition(4 * l + 5, 2 * k + 2);
                                    Console.WriteLine(".");
                                }

                            }
                        }
                    }
                }
            }
            //Calculating combination of columns and blocks
            for (int m = 0; m < game_screen.GetLength(0); m++)
            {
                for (int i = 0; i < game_screen.GetLength(0) - 2; i += 3)
                {
                    for (int j = 0; j < game_screen.GetLength(1) - 2; j += 3)
                    {
                        if (game_screen[m, 0] != -1 && game_screen[m, 1] != -1 && game_screen[m, 2] != -1 && game_screen[m, 3] != -1 && game_screen[m, 4] != -1 && game_screen[m, 5] != -1 && game_screen[m, 6] != -1 && game_screen[m, 7] != -1 && game_screen[m, 8] != -1 && game_screen[i, j] != -1 && game_screen[i + 1, j] != -1 && game_screen[i + 2, j] != -1 && game_screen[i, j + 1] != -1 && game_screen[i + 1, j + 1] != -1 && game_screen[i + 2, j + 1] != -1 && game_screen[i, j + 2] != -1 && game_screen[i + 1, j + 2] != -1 && game_screen[i + 2, j + 2] != -1)
                        {   //Calculation of block
                            block_sum = (game_screen[i, j] * Math.Pow(2, 8)) + (game_screen[i + 1, j] * Math.Pow(2, 7)) + (game_screen[i + 2, j] * Math.Pow(2, 6)) +
                            (game_screen[i, j + 1] * Math.Pow(2, 5)) + (game_screen[i + 1, j + 1] * Math.Pow(2, 4)) + (game_screen[i + 2, j + 1] * Math.Pow(2, 3)) +
                            (game_screen[i, j + 2] * Math.Pow(2, 2)) + (game_screen[i + 1, j + 2] * Math.Pow(2, 1)) + (game_screen[i + 2, j + 2] * Math.Pow(2, 0));
                            score += block_sum;
                            //Calculation of column
                            for (int l = 0; l < game_screen.GetLength(0); l++)
                            {
                                col_sum += (game_screen[m, l] * Math.Pow(2, game_screen.GetLength(1) - l - 1));
                            }
                            //Bonus for filling at the same time(x2 bonus)
                            score += col_sum;
                            total_score += score * 2;
                            //Showing the results to console area
                            Console.SetCursorPosition(87, 1);
                            Console.WriteLine(total_score);
                            Console.SetCursorPosition(52, 11);
                            Console.Write("(" + game_screen[i, j] + "" + game_screen[i + 1, j] + "" + game_screen[i + 2, j] + "" + game_screen[i, j + 1] + "" + game_screen[i + 1, j + 1] + "" + game_screen[i + 2, j + 1] + "" + game_screen[i, j + 2] + "" + game_screen[i + 1, j + 2] + "" + game_screen[i + 2, j + 2] + ")2=(" + block_sum + ")10        ");
                            Console.SetCursorPosition(52, 12);
                            Console.Write("(" + game_screen[m, 0] + "" + game_screen[m, 1] + "" + game_screen[m, 2] + "" + game_screen[m, 3] + "" + game_screen[m, 4] + "" + game_screen[m, 5] + "" + game_screen[m, 6] + "" + game_screen[m, 7] + "" + game_screen[m, 8] + ")2=(" + col_sum + ")10            ");
                            Console.SetCursorPosition(52, 13);
                            Console.WriteLine("(" + col_sum + "+" + block_sum + ")=" + score + "           ");
                            Console.SetCursorPosition(52, 14);
                            Console.WriteLine(score + "*2=" + score * 2 + "        ");
                            Console.SetCursorPosition(52, 14);
                            Console.WriteLine("                                      ");
                            Console.SetCursorPosition(52, 15);
                            Console.WriteLine("                                      ");
                            //Turning pieces into their first definition 
                            game_screen[i, j] = -1; game_screen[i + 1, j] = -1; game_screen[i + 2, j] = -1;
                            game_screen[i, j + 1] = -1; game_screen[i + 1, j + 1] = -1; game_screen[i + 2, j + 1] = -1;
                            game_screen[i, j + 2] = -1; game_screen[i + 1, j + 2] = -1; game_screen[i + 2, j + 2] = -1;

                            //Transforming numbers into dots(.) again 
                            for (int k = i; k < i + 3; k++)
                            {
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 2);
                                Console.Write(".");
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 4);
                                Console.Write(".");
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 6);
                                Console.Write(".");
                            }

                            Console.WriteLine();
                            for (int l = 0; l < game_screen.GetLength(0); l++)
                                game_screen[m, l] = -1;

                            for (int l = 0; l < game_screen.GetLength(1); l++)
                            {
                                Console.SetCursorPosition(4 * m + 5, 2 * l + 2);
                                Console.WriteLine(".");
                            }
                        }
                    }
                }
            }


            //Calculating combination of rows and blocks
            for (int m = 0; m < game_screen.GetLength(0); m++)
            {
                for (int i = 0; i < game_screen.GetLength(0) - 2; i += 3)
                {
                    for (int j = 0; j < game_screen.GetLength(1) - 2; j += 3)
                    {
                        if (game_screen[0, m] != -1 && game_screen[1, m] != -1 && game_screen[2, m] != -1 && game_screen[3, m] != -1 && game_screen[4, m] != -1 && game_screen[5, m] != -1 && game_screen[6, m] != -1 && game_screen[7, m] != -1 && game_screen[8, m] != -1 && game_screen[i, j] != -1 && game_screen[i + 1, j] != -1 && game_screen[i + 2, j] != -1 && game_screen[i, j + 1] != -1 && game_screen[i + 1, j + 1] != -1 && game_screen[i + 2, j + 1] != -1 && game_screen[i, j + 2] != -1 && game_screen[i + 1, j + 2] != -1 && game_screen[i + 2, j + 2] != -1)
                        {   //Calculation of block
                            block_sum = (game_screen[i, j] * Math.Pow(2, 8)) + (game_screen[i + 1, j] * Math.Pow(2, 7)) + (game_screen[i + 2, j] * Math.Pow(2, 6)) +
                            (game_screen[i, j + 1] * Math.Pow(2, 5)) + (game_screen[i + 1, j + 1] * Math.Pow(2, 4)) + (game_screen[i + 2, j + 1] * Math.Pow(2, 3)) +
                            (game_screen[i, j + 2] * Math.Pow(2, 2)) + (game_screen[i + 1, j + 2] * Math.Pow(2, 1)) + (game_screen[i + 2, j + 2] * Math.Pow(2, 0));
                            score += block_sum;
                            //Calculation of row
                            for (int l = 0; l < game_screen.GetLength(0); l++)
                            {
                                row_sum += (game_screen[l, m] * Math.Pow(2, game_screen.GetLength(1) - l - 1));
                            }
                            score += row_sum;
                            //Bonus for filling at the same time(x2 bonus)
                            total_score += score * 2;

                            //Showing the results to console area
                            Console.SetCursorPosition(52, 11);
                            Console.Write("(" + game_screen[i, j] + "" + game_screen[i + 1, j] + "" + game_screen[i + 2, j] + "" + game_screen[i, j + 1] + "" + game_screen[i + 1, j + 1] + "" + game_screen[i + 2, j + 1] + "" + game_screen[i, j + 2] + "" + game_screen[i + 1, j + 2] + "" + game_screen[i + 2, j + 2] + ")2=(" + block_sum + ")10          ");
                            Console.SetCursorPosition(52, 12);
                            Console.Write("(" + game_screen[0, m] + "" + game_screen[1, m] + "" + game_screen[2, m] + "" + game_screen[3, m] + "" + game_screen[4, m] + "" + game_screen[5, m] + "" + game_screen[6, m] + "" + game_screen[7, m] + "" + game_screen[8, m] + ")2=(" + row_sum + ")10");
                            Console.SetCursorPosition(87, 1);
                            Console.WriteLine(total_score);
                            Console.SetCursorPosition(52, 13);
                            Console.WriteLine("(" + row_sum + "+" + block_sum + ")=" + score + "            ");
                            Console.SetCursorPosition(52, 14);
                            Console.WriteLine(score + "*2=" + score * 2 + "                   ");
                            Console.SetCursorPosition(52, 15);
                            Console.WriteLine("                                      ");

                            //Turning pieces into their first definition 
                            game_screen[i, j] = -1; game_screen[i + 1, j] = -1; game_screen[i + 2, j] = -1;
                            game_screen[i, j + 1] = -1; game_screen[i + 1, j + 1] = -1; game_screen[i + 2, j + 1] = -1;
                            game_screen[i, j + 2] = -1; game_screen[i + 1, j + 2] = -1; game_screen[i + 2, j + 2] = -1;


                            //Transforming numbers into dots(.) again 
                            for (int k = i; k < i + 3; k++)
                            {
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 2);
                                Console.Write(".");
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 4);
                                Console.Write(".");
                                Console.SetCursorPosition(4 * k + 5, 2 * j + 6);
                                Console.Write(".");
                            }
                            Console.WriteLine();
                            for (int l = 0; l < game_screen.GetLength(1); l++)
                                game_screen[l, m] = -1;

                            for (int l = 0; l < game_screen.GetLength(1); l++)
                            {
                                Console.SetCursorPosition(4 * l + 5, 2 * m + 2);
                                Console.WriteLine(".");
                            }
                        }
                    }
                }
            }
            // Calculating combination of columns and rows 
            for (int i = 0; i < game_screen.GetLength(0); i++)
            {
                for (int k = 0; k < game_screen.GetLength(0); k++)
                {
                    if (game_screen[0, i] != -1 && game_screen[1, i] != -1 && game_screen[2, i] != -1 && game_screen[3, i] != -1 && game_screen[4, i] != -1 && game_screen[5, i] != -1 && game_screen[6, i] != -1 && game_screen[7, i] != -1 && game_screen[8, i] != -1 && game_screen[k, 0] != -1 && game_screen[k, 1] != -1 && game_screen[k, 2] != -1 && game_screen[k, 3] != -1 && game_screen[k, 4] != -1 && game_screen[k, 5] != -1 && game_screen[k, 6] != -1 && game_screen[k, 7] != -1 && game_screen[k, 8] != -1)
                    {
                        //Calculation of column and row
                        for (int j = 0; j < game_screen.GetLength(0); j++)
                        {
                            col_sum += (game_screen[k, j] * Math.Pow(2, game_screen.GetLength(1) - j - 1));
                        }
                        score += col_sum;
                        for (int j = 0; j < game_screen.GetLength(0); j++)
                        {
                            row_sum += (game_screen[j, i] * Math.Pow(2, game_screen.GetLength(1) - j - 1));
                        }
                        score += row_sum;
                        //Bonus for filling at the same time(x2 bonus)
                        total_score += score * 2;

                        //Showing the results to console area
                        Console.SetCursorPosition(52, 11);
                        Console.Write("(" + game_screen[k, 0] + "" + game_screen[k, 1] + "" + game_screen[k, 2] + "" + game_screen[k, 3] + "" + game_screen[k, 4] + "" + game_screen[k, 5] + "" + game_screen[k, 6] + "" + game_screen[k, 7] + "" + game_screen[k, 8] + ")2=(" + col_sum + ")10          ");
                        Console.SetCursorPosition(52, 12);
                        Console.Write("(" + game_screen[0, i] + "" + game_screen[1, i] + "" + game_screen[2, i] + "" + game_screen[3, i] + "" + game_screen[4, i] + "" + game_screen[5, i] + "" + game_screen[6, i] + "" + game_screen[7, i] + "" + game_screen[8, i] + ")2=(" + row_sum + ")10          ");
                        Console.SetCursorPosition(52, 13);
                        Console.WriteLine("(" + col_sum + "+" + row_sum + ")=" + score + "               ");
                        Console.SetCursorPosition(52, 14);
                        Console.WriteLine(score + "*2=" + score * 2 + "           ");
                        Console.SetCursorPosition(52, 15);
                        Console.WriteLine("                                      ");
                        Console.SetCursorPosition(87, 1);
                        Console.WriteLine(total_score);

                        //Turning pieces into their first definition 
                        for (int j = 0; j < game_screen.GetLength(0); j++)
                            game_screen[k, j] = -1;

                        //Transforming numbers into dots(.) again 
                        for (int j = 0; j < game_screen.GetLength(1); j++)
                        {
                            Console.SetCursorPosition(4 * k + 5, 2 * j + 2);
                            Console.WriteLine(".");
                        }
                        for (int j = 0; j < game_screen.GetLength(1); j++)
                            game_screen[j, i] = -1;

                        for (int j = 0; j < game_screen.GetLength(1); j++)
                        {
                            Console.SetCursorPosition(4 * j + 5, 2 * i + 2);
                            Console.WriteLine(".");
                        }
                    }
                }
                //Calculations of nine columns
                if (game_screen[i, 0] != -1 && game_screen[i, 1] != -1 && game_screen[i, 2] != -1 && game_screen[i, 3] != -1 && game_screen[i, 4] != -1 && game_screen[i, 5] != -1 && game_screen[i, 6] != -1 && game_screen[i, 7] != -1 && game_screen[i, 8] != -1)
                {
                    for (int j = 0; j < game_screen.GetLength(0); j++)
                    {
                        col_sum += (game_screen[i, j] * Math.Pow(2, game_screen.GetLength(1) - j - 1));
                    }
                    score += col_sum;
                    total_score += score;

                    //Showing the results to console area
                    Console.SetCursorPosition(87, 1);
                    Console.WriteLine(total_score);
                    Console.SetCursorPosition(52, 11);
                    Console.Write("(" + game_screen[i, 0] + "" + game_screen[i, 1] + "" + game_screen[i, 2] + "" + game_screen[i, 3] + "" + game_screen[i, 4] + "" + game_screen[i, 5] + "" + game_screen[i, 6] + "" + game_screen[i, 7] + "" + game_screen[i, 8] + ")2=(" + col_sum + ")10        ");
                    Console.SetCursorPosition(52, 12);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 13);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 14);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 15);
                    Console.WriteLine("                                      ");
                    //Turning pieces into their first definition 
                    for (int j = 0; j < game_screen.GetLength(0); j++)
                        game_screen[i, j] = -1;

                    //Transforming numbers into dots(.) again 
                    for (int j = 0; j < game_screen.GetLength(1); j++)
                    {
                        Console.SetCursorPosition(4 * i + 5, 2 * j + 2);
                        Console.WriteLine(".");
                    }
                }
                //Calculations of nine rows
                if (game_screen[0, i] != -1 && game_screen[1, i] != -1 && game_screen[2, i] != -1 && game_screen[3, i] != -1 && game_screen[4, i] != -1 && game_screen[5, i] != -1 && game_screen[6, i] != -1 && game_screen[7, i] != -1 && game_screen[8, i] != -1)
                {
                    for (int j = 0; j < game_screen.GetLength(0); j++)
                    {
                        row_sum += (game_screen[j, i] * Math.Pow(2, game_screen.GetLength(1) - j - 1));
                    }
                    score += row_sum;
                    total_score += score;

                    //Showing the results to console area
                    Console.SetCursorPosition(87, 1);
                    Console.WriteLine(total_score);
                    Console.SetCursorPosition(52, 11);
                    Console.Write("(" + game_screen[0, i] + "" + game_screen[1, i] + "" + game_screen[2, i] + "" + game_screen[3, i] + "" + game_screen[4, i] + "" + game_screen[5, i] + "" + game_screen[6, i] + "" + game_screen[7, i] + "" + game_screen[8, i] + ")2=(" + row_sum + ")10        ");
                    Console.SetCursorPosition(52, 12);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 13);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 14);
                    Console.WriteLine("                                      ");
                    Console.SetCursorPosition(52, 15);
                    Console.WriteLine("                                      ");
                    //Turning pieces into their first definition 
                    for (int j = 0; j < game_screen.GetLength(1); j++)
                        game_screen[j, i] = -1;

                    //Transforming numbers into dots(.) again 
                    for (int j = 0; j < game_screen.GetLength(1); j++)
                    {
                        Console.SetCursorPosition(4 * j + 5, 2 * i + 2);
                        Console.WriteLine(".");
                    }
                }
            }

            // Calculations of  nine blocks 
            for (int i = 0; i < game_screen.GetLength(0) - 2; i += 3)
            {
                for (int j = 0; j < game_screen.GetLength(1) - 2; j += 3)
                {
                    if (game_screen[i, j] != -1 && game_screen[i + 1, j] != -1 && game_screen[i + 2, j] != -1 && game_screen[i, j + 1] != -1 && game_screen[i + 1, j + 1] != -1 && game_screen[i + 2, j + 1] != -1 && game_screen[i, j + 2] != -1 && game_screen[i + 1, j + 2] != -1 && game_screen[i + 2, j + 2] != -1)
                    {
                        block_sum = (game_screen[i, j] * Math.Pow(2, 8)) + (game_screen[i + 1, j] * Math.Pow(2, 7)) + (game_screen[i + 2, j] * Math.Pow(2, 6)) +
                       (game_screen[i, j + 1] * Math.Pow(2, 5)) + (game_screen[i + 1, j + 1] * Math.Pow(2, 4)) + (game_screen[i + 2, j + 1] * Math.Pow(2, 3)) +
                       (game_screen[i, j + 2] * Math.Pow(2, 2)) + (game_screen[i + 1, j + 2] * Math.Pow(2, 1)) + (game_screen[i + 2, j + 2] * Math.Pow(2, 0));
                        score += block_sum;
                        total_score += score;
                        //Showing the results to console area
                        Console.SetCursorPosition(87, 1);
                        Console.WriteLine(total_score);
                        Console.SetCursorPosition(52, 11);
                        Console.Write("(" + game_screen[i, j] + "" + game_screen[i + 1, j] + "" + game_screen[i + 2, j] + "" + game_screen[i, j + 1] + "" + game_screen[i + 1, j + 1] + "" + game_screen[i + 2, j + 1] + "" + game_screen[i, j + 2] + "" + game_screen[i + 1, j + 2] + "" + game_screen[i + 2, j + 2] + ")2=(" + block_sum + ")10");
                        Console.SetCursorPosition(52, 12);
                        Console.WriteLine("                                      ");
                        Console.SetCursorPosition(52, 13);
                        Console.WriteLine("                                      ");
                        Console.SetCursorPosition(52, 14);
                        Console.WriteLine("                                      ");
                        Console.SetCursorPosition(52, 15);
                        Console.WriteLine("                                      ");
                        //Turning pieces into their first definition 
                        game_screen[i, j] = -1; game_screen[i + 1, j] = -1; game_screen[i + 2, j] = -1;
                        game_screen[i, j + 1] = -1; game_screen[i + 1, j + 1] = -1; game_screen[i + 2, j + 1] = -1;
                        game_screen[i, j + 2] = -1; game_screen[i + 1, j + 2] = -1; game_screen[i + 2, j + 2] = -1;

                        //Transforming numbers into dots(.) again 
                        for (int k = i; k < i + 3; k++)
                        {
                            Console.SetCursorPosition(4 * k + 5, 2 * j + 2);
                            Console.Write(".");
                            Console.SetCursorPosition(4 * k + 5, 2 * j + 4);
                            Console.Write(".");
                            Console.SetCursorPosition(4 * k + 5, 2 * j + 6);
                            Console.Write(".");
                        }
                        Console.WriteLine();
                    }
                }
            }
        }
        //  Moving the cursor in x-y direction 
        if (cki.Key == ConsoleKey.RightArrow && cursorx < 36)
        {
            Console.SetCursorPosition(cursorx, cursory);
            cursorx += 4;
        }
        if (cki.Key == ConsoleKey.LeftArrow && cursorx > 6)
        {
            Console.SetCursorPosition(cursorx, cursory);
            cursorx -= 4;
        }
        if (cki.Key == ConsoleKey.UpArrow && cursory > 3)
        {
            Console.SetCursorPosition(cursorx, cursory);
            cursory -= 2;
        }
        if (cki.Key == ConsoleKey.DownArrow && cursory < 18)
        {
            Console.SetCursorPosition(cursorx, cursory);
            cursory += 2;
        }
        Console.SetCursorPosition(cursorx, cursory);
    }
}
Console.ReadLine();