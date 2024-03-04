package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_641
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        long n = sc.nextLong();
        sc.close();

        boolean end = false;
        long save = 0;

        while (!end)
        {
            end = n / 10 == 0;
            if (( n % 10 ) % 2 == 0)
                save = save * 10 + ( n % 10 );

            n = n / 10;
        }

        end = false;

        while (!end)
        {
            end = save / 10 == 0;
            System.out.print(save % 10);
            save = save / 10;
        }
    }
}
