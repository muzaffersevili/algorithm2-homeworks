//Group A

Console.ForegroundColor = ConsoleColor.Red;

Console.WriteLine("Operation Group A \n");

Console.ForegroundColor = ConsoleColor.Yellow;

double[,] matrix = new double[3, 3];

for (int i = 0; i < matrix.GetLength(0); i++)
{
    for (int j = 0; j < matrix.GetLength(1); j++)
    {
        Console.Write("Please enter the number : ");
        matrix[i, j] = Convert.ToDouble(Console.ReadLine());
    }
}


Console.ForegroundColor = ConsoleColor.Blue;

for (int i = 0; i < matrix.GetLength(0); i++)
{
    for (int j = 0; j < matrix.GetLength(1); j++)
        Console.Write(matrix[i, j] + "\t");

    Console.WriteLine();
}

Console.ForegroundColor = ConsoleColor.Yellow;

double[] sumrows = new double[matrix.GetLength(0)];
double[] sumcolumns = new double[matrix.GetLength(0)];
double sumPrimaryDiagonal = 0;

for (int i = 0; i < matrix.GetLength(0); i++)
{
    for (int j = 0; j < matrix.GetLength(1); j++)
    {
        sumrows[i] += matrix[i, j];
        sumcolumns[i] += matrix[j, i];

        if (i == j)
            sumPrimaryDiagonal += matrix[i, j];
    }

}

for (int i = 0; i < matrix.GetLength(0); i++)
    Console.WriteLine("Sum of row " + i + " : " + sumrows[i]);

for (int i = 0; i < matrix.GetLength(0); i++)
    Console.WriteLine("Sum of column " + i + " : " + sumcolumns[i]);

Console.WriteLine("Sum of PrimaryDiogonal : " + sumPrimaryDiagonal + "\n");

Console.ForegroundColor = ConsoleColor.Green;

Console.WriteLine("Transpose of Matrix : ");

for (int i = 0; i < matrix.GetLength(0); i++)
{
    for (int j = 0; j < matrix.GetLength(1); j++)
        Console.Write(matrix[j, i] + "\t");

    Console.WriteLine();
}

Console.ForegroundColor = ConsoleColor.Yellow;

double primary, secondary, determinant;

primary = (matrix[0, 0] * matrix[1, 1] * matrix[2, 2]) + (matrix[1, 0] * matrix[2, 1] * matrix[0, 2]) + (matrix[2, 0] * matrix[0, 1] * matrix[1, 2]);
secondary = (matrix[0, 2] * matrix[1, 1] * matrix[2, 0]) + (matrix[1, 2] * matrix[2, 1] * matrix[0, 0]) + (matrix[2, 2] * matrix[0, 1] * matrix[1, 0]);
determinant = primary - secondary;
Console.WriteLine("Determinant of Matrix : " + determinant + "\n");


//Group B

Console.ForegroundColor = ConsoleColor.Red;

Console.WriteLine("\nOperation Group B \n");

Console.ForegroundColor = ConsoleColor.Yellow;

bool identity=true, scalar=true, diagonal = true, zero_one = true, symmetric = true, permutation = true;


if (matrix[0, 0] == 1 && matrix[1, 1] == 1 && matrix[2, 2] == 1 && matrix[0, 1] == 0 && matrix[0, 2] == 0
    && matrix[1, 0] == 0 && matrix[1, 2] == 0 && matrix[2, 0] == 0 && matrix[2, 1] == 0)
{
    identity = true;
    scalar = true;
    diagonal = true;
    zero_one = true;
    symmetric = true;
    permutation = true;
}
else
{
    identity = false;

    if (matrix[0, 0] == matrix[1, 1] && matrix[1, 1] == matrix[2, 2] && matrix[0, 1] == 0 &&
        matrix[0, 2] == 0 && matrix[1, 0] == 0 && matrix[1, 2] == 0 && matrix[2, 0] == 0 && matrix[2, 1] == 0)
    {
        scalar = true;
        diagonal = true;
        symmetric = true;
    }
    else
    {
        scalar = false;

        if (matrix[0, 1] == 0 && matrix[0, 2] == 0 && matrix[1, 0] == 0 &&
            matrix[1, 2] == 0 && matrix[2, 0] == 0 && matrix[2, 1] == 0)
        {
            diagonal = true;
            symmetric = true;
        }
        else
        {
            diagonal = false;

            if (matrix[0, 1] == matrix[1, 0] & matrix[0, 2] == matrix[2, 0] & matrix[2, 1] == matrix[1, 2])
                symmetric = true;
            else
                symmetric = false;
        }
    }

    
    if ((matrix[0,0] == 1 && matrix[1,1] == 1 && matrix[2,2] == 1 && matrix[1,0] == 0 && matrix[2,0] == 0 
        && matrix[0,1] == 0 && matrix[2,1] == 0 && matrix[0,2] == 0 && matrix[1,2] == 0) ||
        (matrix[0,0] == 1 && matrix[2,1] == 1 && matrix[1,2] == 1 && matrix[1,0] == 0 && matrix[2,0] == 0 
        && matrix[0,1] == 0 && matrix[1,1] == 0 && matrix[0,2] == 0 && matrix[2,2] == 0) ||
        (matrix[1,0] == 1 && matrix[0,1] == 1 && matrix[2,2] == 1 && matrix[0,0] == 0 && matrix[2,0] == 0
        && matrix[1,1] == 0 && matrix[2,1] == 0 && matrix[0,2] == 0 && matrix[1,2] == 0) ||
        (matrix[1,0] == 1 && matrix[2,1] == 1 && matrix[0,2] == 1 && matrix[0,0] == 0 && matrix[2,0] == 0 
        && matrix[0,1] == 0 && matrix[1,1] == 0 && matrix[1,2] == 0 && matrix[2,2] == 0) ||
        (matrix[2,0] == 1 && matrix[1,2] == 1 && matrix[0,1] == 1 && matrix[0,0] == 0 && matrix[1,0] == 0 
        && matrix[1,1] == 0 && matrix[2,1] == 0 && matrix[0,2] == 0 && matrix[2,2] == 0) ||
        (matrix[2,0] == 1 && matrix[1,1] == 1 && matrix[0,2] == 1 && matrix[0,0] == 0 && matrix[1,0] == 0 
        && matrix[0,1] == 0 && matrix[2,1] == 0 && matrix[1,2] == 0 && matrix[2,2] == 0))
    {
        permutation = true;
        zero_one = true;
    }
    else
    {
        permutation = false;

        for(int i = 0; i < matrix.GetLength(0); i++)
        {
            for (int j = 0; j < matrix.GetLength(1); j++)
            {
                if (matrix[i, j] != 0 || matrix[i, j] != 1)
                {
                    zero_one = false;
                }
            }
        }
    }
}

Console.WriteLine("Identitiy Matrix : " + identity);
Console.WriteLine("Scalar Matrix : " + scalar);
Console.WriteLine("Diagonal Matrix : " + diagonal);
Console.WriteLine("Zero-One Matrix : " + zero_one);
Console.WriteLine("Symmetric Matrix : " + symmetric);
Console.WriteLine("Permutation Matrix : " + permutation);



//Group C
Console.ForegroundColor = ConsoleColor.Red;

Console.WriteLine("\n\nOperation Group C \n");

Console.ForegroundColor = ConsoleColor.Yellow;

double[] minRow=new double[matrix.GetLength(0)];

for(int i = 0; i < matrix.GetLength(0); i++)
{
    if(matrix[i,0] <= matrix[i, 1] && matrix[i, 0] <= matrix[i, 2])
        minRow[i] = matrix[i,0];
    else if(matrix[i, 1] <= matrix[i, 0] && matrix[i, 1] <= matrix[i, 2])
        minRow[i] = matrix[i, 1];
    else
        minRow[i] = matrix[i, 2];
}

for (int i = 0; i < matrix.GetLength(0); i++)
    Console.WriteLine("Minimum value of row "+ i+" : ", minRow[i]);


double[] maxColumn = new double[matrix.GetLength(1)];

for (int i = 0; i < matrix.GetLength(1); i++)
{
    if (matrix[0, i] >= matrix[1, i] && matrix[0, i] >= matrix[2, i])
        maxColumn[i] = matrix[0, i];
    else if (matrix[1, i] >= matrix[0, i] && matrix[1, i] >= matrix[2, i])
        maxColumn[i] = matrix[1, i];
    else
        maxColumn[i] = matrix[2, i];
}

for (int i = 0; i < matrix.GetLength(1); i++)
    Console.WriteLine("Maximum value of column " + i + " : ", maxColumn[i]);

double maxMin, minMax;

if (minRow[0] >= minRow[1] && minRow[0] >= minRow[2])
    maxMin = minRow[0];
else if (minRow[1] >= minRow[0] && minRow[1] >= minRow[2])
    maxMin = minRow[1];
else
    maxMin = minRow[2];


if (maxColumn[0] <= maxColumn[1] && maxColumn[0] <= maxColumn[2])
    minMax = maxColumn[0];
else if (maxColumn[1] <= maxColumn[0] && maxColumn[1] <= maxColumn[2])
    minMax = maxColumn[1];
else
    minMax = maxColumn[2];

Console.WriteLine("Maximum of minimum row values : {0} \n" + "Minimum of maximum column values : {1} \n ", maxMin, minMax);


if (maxMin > minMax)
    Console.WriteLine("Compare maxmin to minmax: maxMin > minMax");
else if (maxMin == minMax)
    Console.WriteLine("Compare maxmin to minmax: maxMin = minMax");
else
    Console.WriteLine("Compare maxmin to minmax: maxMin < minMax");

Console.ReadLine();