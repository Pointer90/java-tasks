package Tasks_part_1;

import java.util.Scanner;
import java.util.Locale;

public class Task_387{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        sc.close();

        float x = sc.nextFloat();
        float y = sc.nextFloat();

        boolean d1 = x >= -1 && x <= 1 && y <= 0 && y >= -2;
        boolean d2 = (x >= -1 && x <= 1) && (y <= x || y <= -x);

        String answer = d1 || d2 ? "Yes" : "No";
        System.out.println(answer);
    }
}