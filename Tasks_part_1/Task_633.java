package Tasks_part_1;

import java.util.Scanner;
import java.util.Locale;

public class Task_633
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double x = sc.nextDouble();
        double e = sc.nextDouble();
        sc.close();

        double  num_up = 1.,
                num_down = 2.,
                x_down = 3.,
                q = -1.,
                y0 = x,
                x_up = x * x * x,
                num = (num_up / num_down),
                y1 = y0 + q * num * (x_up / x_down);

        while(Math.abs(y1 - y0) > e)
        {
            y0 = y1;
            num_up += 2.;
            num_down += 2.;
            x_down += 2.;
            q *= -1.;
            num *= (num_up / num_down);
            x_up *= x * x;
            y1 += q * num * (x_up / x_down);
        }

        System.out.printf(Locale.US, "%.6f", y0);
    }
    
}