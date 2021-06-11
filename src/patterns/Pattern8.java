package patterns;

import java.util.Scanner;

public class Pattern8 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int spaces = n - 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= spaces; j++){
                System.out.print("\t");
            }
            spaces--;
            System.out.print("*\t");
            System.out.println();
        }
    }
}