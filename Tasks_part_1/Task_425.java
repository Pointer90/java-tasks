package Tasks_part_1;

import java.util.Locale;
import java.util.Scanner;

public class Task_425
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        double max = -999999999;

        for (int i = 1; i <= n; i++)
        {
            double elem = sc.nextDouble();
            max = elem > max ? elem : max;
        }
        sc.close();

        String answer = Math.abs(max) > 1 ? "Yes" : "No";

        System.out.print(answer);
    }
}
