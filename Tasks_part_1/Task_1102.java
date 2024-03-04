package Tasks_part_1;

import java.util.Locale;
import java.util.Scanner;

public class Task_1102
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        double x = sc.nextDouble();
        sc.close();

        double save = 1;
        double  a = n,
                b = n;

        for (double i = 1; i < n; i++)
            for (double j = 1; j <= n; j++)
                if (j > i & Math.abs(x - i / j) < save)
                {
                    save= Math.abs(i / j - x);
                    a = i;
                    b = j;
                }

        System.out.printf(Locale.US,"%.0f %.0f", a, b);
    }

}