package Tasks_part_2;

import java.util.Locale;
import java.util.Scanner;

public class Task_565
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        double n = sc.nextInt();
        sc.close();

        double ui, vi = 0.;
        double  ui_1 = 0.,
                ui_2 = 0.,
                vi_1 = 1.,
                vi_2 = 1.;

        for (int i = 3; i <= n; i++)
        {
            ui = (ui_1 - ui_2 * vi_1 - vi_2) / (1. + ui_1 * ui_1 + vi_1 * vi_1);
            vi = (ui_1 - vi_1) / (Math.abs(ui_2 + vi_1) + 2.);
            ui_2 = ui_1;
            ui_1 = ui;
            vi_2 = vi_1;
            vi_1 = vi;
        }
        System.out.printf(Locale.US," %.6f", vi);
    }
}
