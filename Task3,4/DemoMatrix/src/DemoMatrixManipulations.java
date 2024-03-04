import java.util.Locale;
import java.util.Scanner;

import MatrixManipulations.MatrixManipulations;

public class DemoMatrixManipulations 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        int n = sc.nextInt();
        sc.close();

        MatrixManipulations m = new MatrixManipulations(n);
        System.out.println(m.toString());
    }
}
