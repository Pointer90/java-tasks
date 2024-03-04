package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_1081
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double n = sc.nextDouble();
        sc.close();

        double count = 0.;

        for (double i = 0; i <= n; i++)
            for (double j = i; j <= n; j++)
                count += (n + i) / (2 * i + j + 1);

        System.out.printf(Locale.US, "%.6f", count);
    }
}
