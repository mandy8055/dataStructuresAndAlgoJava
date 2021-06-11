package patterns;

import java.util.Scanner;

public class Pattern4 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        for(int i = n; i >= 1; i--){
            for(int gap = 1; gap <= n - i; gap++){
                System.out.print("\t");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
