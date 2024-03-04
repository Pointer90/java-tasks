package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_643
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double x = sc.nextDouble(),
                e = 0.000001,
                posNev = -1.,
                degree = x,
                coef = 0.,
                fact = 1.,
                factCounter = 1.,
                result = 0.,
                step = 0.;
        boolean end = false;

        sc.close();

        while (!end){
            posNev *= -1.;
            coef += 2.;
            degree *= (x * x * x * x);
            factCounter += 2.;
            fact *= (factCounter - 1.) * factCounter;
            result += step;
            step = posNev * coef * degree / fact;
            double module = step;
            if (module < 0.)
                module = -module;
            end = module < e;
        }
        System.out.printf(Locale.US, "%.6f", result + step);
    }
}
