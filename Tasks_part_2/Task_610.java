package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_610
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double P = sc.nextDouble();
        sc.close();

        P /= 100.;
        int day = 1;
        double sum = 10.;
        double km = 10.;
        boolean end = false;

        while (!end)
        {
            km += km * P;
            sum += km;
            day++;
            end = sum > 200.;
        }

        System.out.printf(Locale.US,"%d %.6f", day, sum);
    }
}
