//Неверные ответы (не вижу ошибку)
package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_632
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        double x = sc.nextDouble();
        double e = sc.nextDouble();
        sc.close();

        double sum = x;
        double old = 0.;
        double k = 3.;
        double a = x * x * x;

        boolean end = false;

        while (!end)
        {
            sum += a / k;
            k += 2.;
            a *= x * x;

            end = Math.abs(sum - old) < e;
            if (!end) old = sum;
        }

        System.out.printf(Locale.US, "%.6f", old);
    }   
}
