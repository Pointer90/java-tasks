package Tasks_part_1;

import java.util.Locale;
import java.util.Scanner;

public class Task_489
{
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        sc.useLocale(Locale.US);

        String str=sc.nextLine();
        sc.close();
        String[] words= str.split("\\s+");
        int count = 0;

        for(String word : words){
            if (word.charAt(0) == word.charAt(word.length() - 1)) count++;
        }
        System.out.println(count);
    }
}