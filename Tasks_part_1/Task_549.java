package Tasks_part_1;

import java.util.Scanner;
import java.util.Locale;

public class Task_549
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        sc.useLocale(Locale.US);

        double x= sc.nextDouble();
        sc.close();

        double  a = 1, 
                fact = 1,
                sum = x;

        for (int i = 1; i <= 13; i++ )
        {
            a = a * x;
            fact = fact * i;
            if (i == 3 || i == 7 || i == 11)
                sum = sum - a/fact;
            if ( i == 5 || i == 9 || i == 13)
                sum = sum + a/fact;
        }
        System.out.printf( Locale.US, "%6f", sum);
    }
}