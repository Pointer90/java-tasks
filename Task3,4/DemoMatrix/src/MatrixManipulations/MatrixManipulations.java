package MatrixManipulations;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixManipulations 
{
    private int ht;
    private int wd;
    private double[][] matrix;

    
// Задание № 0
    public MatrixManipulations(int size)
    {
        this.ht = this.wd = size;
        this.matrix = new double[this.ht][this.wd];

        for (int i = 0; i < this.ht; i++)
            for (int j = 0; j < this.wd; j++)
                this.matrix[i][j] = Math.random() * (2 * size) - size;
    }


    public void setValue(int row, int col, double value)
    {
        matrix[row][col] = value;
    }

// Задание № 1
    public void setMean()
    {
        double average;

        for (int i = 0; i < this.ht; i++)
        {
            average = 0.0;
            
            for (int j = 0; j < this.wd; j++)
                average += this.matrix[i][j];

            average /= this.wd;

            for (int j = 0; j < this.wd; j++)
                this.matrix[i][j] -= average;
        }
    }

// Задание № 2
    public void removeMaxElem()
    {
        double max = this.matrix[0][0];
        boolean end = false;

        for (int i = 0; i < this.ht; i++)
            for (int j = 0; j < this.wd; j++)
                max = max < this.matrix[i][j] ? this.matrix[i][j] : max;

        while(!end)
            end = !removeElem(max);
    }

// Задание № 3
    public void removeZeros()
    {
        boolean isZeros = true;

        for (int i = 0; i < this.ht; i++)
        {
            isZeros = true;

            for (int j = 0; j < this.wd; j++)
                if (this.matrix[i][j] != 0.)
                    {
                        isZeros = false;
                        break;
                    }
            
            if (isZeros)
            {
                removeRow(i);    
                i--;
            }
        }

        for (int i = 0; i < this.wd; i++)
        {
            isZeros = true;

            for (int j = 0; j < this.ht; j++)
                if (this.matrix[j][i] != 0.)
                    {
                        isZeros = false;
                        break;
                    }
            
            if (isZeros)
            {
                removeColumn(i);    
                i--;
            }
        }
    }

// Задание № 4
    public void moveMin(int row, int col)
    {
        double min = this.matrix[0][0];

        for (int i = 0; i < this.ht; i++)
            for (int j = 0; j < this.wd; j++)
                min = min > this.matrix[i][j] ? this.matrix[i][j] : min;
        
        for (int i = 0; i < this.ht; i++)
            for (int j = 0; j < this.wd; j++)
                if (min == this.matrix[i][j])
                {
                    swapRow(i, row);
                    swapColumn(j, col);
                }
    }

// Задание № 5
    public int countsSaddlePoints()
    {
        int saddlePoints = 0;

        for (int i = 0; i < this.ht; i++)
        {
            double min = minOfRow(i);

            for(int j = 0; j < this.wd; j++)
            {
                if (this.matrix[i][j] == min)
                {
                    double max = maxOfColumn(j);

                    if (this.matrix[i][j] == max)
                    {
                        saddlePoints++;
                        break;
                    }
                }
            }
        }

        return saddlePoints;
    }

// Задание № 6
    public void increaseRowsSums()
    {
        double [][] map = new double[this.ht][2];
        double [][] m = new double[this.ht][this.wd];
        double sum;

        for (int i = 0; i < this.ht; i++)
        {
            sum = 0.;

            for (int j = 0; j < this.wd; j++)
                sum += this.matrix[i][j];

            map[i] = new double[]{i, sum};
        }

        Arrays.sort(map, Comparator.comparingDouble(arr -> arr[1]));

        for (int i = 0; i < this.ht; i++)
            m[i] = this.matrix[(int)map[i][0]];

        this.matrix = m;
    }


// Задание № 7
    public int localMinCounter()
    {
        int localCounter = 0;
        double[][] tmp = new double[ht + 2][wd + 2];
        
        for (int i = 0; i < ht; i++)
            System.arraycopy(matrix[i], 0, tmp[i + 1], 1, wd);

        for (int i = 0; i < ht; i++)
        {
            tmp[i][0] = Double.MAX_VALUE;
            tmp[i][wd + 1] = Double.MAX_VALUE;
        }

        for (int j = 0; j < wd; j++)
        {
            tmp[0][j] = Double.MAX_VALUE;
            tmp[ht + 1][j] = Double.MAX_VALUE;
        }

        for (int i = 1; i < ht + 1; i++)
            for (int j = 1; j < wd + 1; j++)
            {
                boolean d1 =    tmp[i][j] < tmp[i - 1][j] && 
                                tmp[i][j] < tmp[i + 1][j] && 
                                tmp[i][j] < tmp[i][j - 1] && 
                                tmp[i][j] < tmp[i][j + 1];

                boolean d2 =    tmp[i][j] < tmp[i - 1][j - 1] &&
                                tmp[i][j] < tmp[i - 1][j + 1] && 
                                tmp[i][j] < tmp[i + 1][j - 1] &&
                                tmp[i][j] < tmp[i + 1][j + 1];

                if (d1 && d2)
                    localCounter++;
            }

        return localCounter;
    }


// Задание № 8
    public double minLocalMax()
    {
        double min = Double.MAX_VALUE;
        double[][] tmp = new double[ht + 2][wd + 2];
        
        for (int i = 0; i < ht; i++)
            System.arraycopy(matrix[i], 0, tmp[i + 1], 1, wd);

        for (int i = 0; i < ht; i++)
        {
            tmp[i][0] = Double.MIN_VALUE;
            tmp[i][wd + 1] = Double.MIN_VALUE;
        }

        for (int j = 0; j < wd; j++)
        {
            tmp[0][j] = Double.MIN_VALUE;
            tmp[ht + 1][j] = Double.MIN_VALUE;
        }

        for (int i = 1; i < ht + 1; i++)
            for (int j = 1; j < wd + 1; j++)
            {
                boolean d1 =    tmp[i][j] > tmp[i - 1][j] && 
                                tmp[i][j] > tmp[i + 1][j] && 
                                tmp[i][j] > tmp[i][j - 1] && 
                                tmp[i][j] > tmp[i][j + 1];

                boolean d2 =    tmp[i][j] > tmp[i - 1][j - 1] &&
                                tmp[i][j] > tmp[i - 1][j + 1] && 
                                tmp[i][j] > tmp[i + 1][j - 1] &&
                                tmp[i][j] > tmp[i + 1][j + 1];

                if (d1 && d2)
                    min = tmp[i][j] < min ? tmp[i][j] : min;
            }

        return min;
    }


// Задание № 9
    public void decreaseColumnSums()
    {
        double [][] map = new double[this.wd][2];
        double [][] m = new double[this.ht][this.wd];
        double sum;

        for (int i = 0; i < this.wd; i++)
        {
            sum = 0.;

            for (int j = 0; j < this.ht; j++)
                sum += Math.abs(this.matrix[j][i]);

            map[i] = new double[]{i, sum};
        }

        Arrays.sort(map, Comparator.comparingDouble(arr -> arr[1]));

        for (int j = 0; j < this.wd; j++)
            for (int i = 0; i < this. ht; i++)
                m[i][j] = this.matrix[i][(int)map[this.wd - j - 1][0]];
        this.matrix = m;
    }


    private double minOfRow(int row)
    {
        double min = this.matrix[row][0];

        for (int j = 0; j < this.wd; j++)
            min = min > this.matrix[row][j] ? this.matrix[row][j] : min;

        return min;
    }


    private double maxOfColumn(int col)
    {
        double max = this.matrix[0][col];

        for (int i = 0; i < this.ht; i++)
            max = max < this.matrix[i][col] ? this.matrix[i][col] : max;

        return max;
    }


    private void swapColumn(int i, int j)
    {
        double tmp;

        for (int k = 0; k < this.wd; k++)
        {
            tmp = this.matrix[k][i];
            this.matrix[k][i] = this.matrix[k][j];
            this.matrix[k][j] = tmp;
        }
    }


    private void swapRow(int i, int j)
    {
        double []tmp = new double[this.wd];

        tmp = this.matrix[i];
        this.matrix[i] = this.matrix[j];
        this.matrix[j] = tmp;
    }


    private void removeRow(int index)
    {
        double [][] m = new double[this.ht - 1][this.wd];

        for (int i = 0; i < index; i++)
            m[i] = Arrays.copyOf(this.matrix[i], this.wd);

        for (int i = index + 1; i < this.ht; i++)
            m[i - 1] = Arrays.copyOf(this.matrix[i], this.wd);

        this.ht--;
        this.matrix = m;
    }


    private void removeColumn(int index)
    {
        for (int i = 0; i < this.ht; i++)
            for (int j = index + 1; j < this.wd; j++)
                this.matrix[i][j - 1] = this.matrix[i][j];

        double [][] m = new double[this.ht][this.wd - 1];
        this.wd--;

        for (int i = 0; i < this.ht; i++)
            m[i] = Arrays.copyOfRange(this.matrix[i], 0, this.wd);

        this.matrix = m;
    }


    private boolean removeElem(double value)
    {
        boolean isExsit = true;

        for (int i = 0; i < this.ht; i++)
            for (int j = 0; j < this.wd; j++)
                if (this.matrix[i][j] == value)
                {
                    removeRow(i);
                    removeColumn(j);
                    return isExsit;
                }

        return !isExsit;
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < this.ht; i++)
        {
            for (int j = 0; j < this.wd; j++)
                result += this.matrix[i][j] + "\t";
            result += "\n";
        }

        return result;
    }
}
