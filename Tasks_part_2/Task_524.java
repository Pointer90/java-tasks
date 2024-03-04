package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_524
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        sc.close();

        double  a = 1., sum = 0.;
        double b, c;

        for ( int k = 1; k <= n; k++ )
        {
            a = k % 2 == 0 ? 1 : -1;
            b = 2 * k + 1;
            c = 1.;

            for (int i = 1; i <= k; i++)
                c *= b;

            sum += a / c;
        }
        
        System.out.printf(Locale.US, "%.6f", sum);
    }
}
