package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_614 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        long num = sc.nextLong();
        sc.close();

        boolean end = false;
        boolean exists = false;

        while (!end)
        {
            end = num == 0 || num % 10 == 2;
            exists = num % 10 == 2 || num / 10 == 2;
            num /= 10;
        }

        String answer = exists ? "True" : "False";
        System.out.print(answer);
    }
}
