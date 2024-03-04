package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_443
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        int n = sc.nextInt();
        double min = Math.abs(sc.nextDouble());

        min = min > 1 ? min : 2;

        for (int i = 0; i < n - 1; i++)
        {
            double elem = Math.abs(sc.nextDouble());
            elem = elem > 1 ? elem : 2;
            min = elem < min ? elem : min;
        }
        sc.close();
        System.out.printf(Locale.US, "%.6f", min);
    }
}
