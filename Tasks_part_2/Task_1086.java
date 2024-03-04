package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_1086
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double m = sc.nextDouble();
        double n = sc.nextDouble();
        sc.close();

        final int cost_bull = 10;
        final int cost_cow = 5;
        final double cost_calf = 0.5;
        int count_bull = 0;
        int count_cow = 0;
        double count_calf = 0.;
        boolean result = false;

        for (int sum_bull = 0; sum_bull <= m; sum_bull += cost_bull, count_bull++)
        {
            for (int sum_cow = 0; sum_cow <= m; sum_cow += cost_cow, count_cow++)
            {
                for(double sum_calf = 0; sum_calf <= m; sum_calf += cost_calf, count_calf++)
                    if ( sum_bull + sum_cow + sum_calf == m && count_bull + count_cow + count_calf == n) 
                        result = true; 

                count_calf = 0.;
            }

            count_cow = 0;
        }

        String answer = result ? "yes" : "no";
        System.out.print(answer);
    }
}
