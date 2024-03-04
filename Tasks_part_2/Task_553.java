package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_553 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        sc.close();

        double k, A;
        double sum = 0.;

        for ( k = 1; k <= n; k++){
            A = 1.;

            for ( double i = 1; i <= k; i++)
                A *= 1. / k;
            sum += A;
        }
        System.out.printf(Locale.US, "%.6f", sum);
    }
}
