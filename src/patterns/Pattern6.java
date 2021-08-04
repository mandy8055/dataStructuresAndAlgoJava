package patterns;

import java.util.Scanner;

public class Pattern6 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int spaces = 1;
        int stars = n / 2 + 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= stars; j++){
                System.out.print("*\t");
            }
            for(int j = 1; j <= spaces; j++){
                System.out.print("\t");
            }
            for(int j = 1; j <= stars; j++){
                System.out.print("*\t");
            }
            if(i <= (n / 2)){
                stars--;
                spaces += 2;
            }else {
                stars++;
                spaces -= 2;
            }
            System.out.println();
        }
    }
}
