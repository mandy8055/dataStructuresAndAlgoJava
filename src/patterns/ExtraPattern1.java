package patterns;

import java.util.Scanner;

public class ExtraPattern1 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int tempNum = n;
        // First half
        for(int i = 1; i <= n; i+= 2)
        {
            int counter = (i - 1) * n + 1;
            for(int j = 1; j <= n; j++)
            {
                System.out.print(counter++ + "\t");
            }
            System.out.println();
        }
        // Condition for second half
        if(n % 2 != 0)
        {
            tempNum = n - 1;
        }
        // Second half
        for(int i = tempNum; i >= 1; i-= 2)
        {
            int counter = (i - 1) * n + 1;
            for(int j = 1; j <= n; j++)
            {
                System.out.print(counter++ + "\t");
            }
            System.out.println();
        }
    }
}
