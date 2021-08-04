package patterns;

import java.util.Scanner;

public class Pattern11 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int counter = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
               System.out.print(counter++ + "\t");
            }
            System.out.println();
        }
    }
}
