package patterns;

import java.util.Scanner;

public class Pattern10 {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();
        int outerSp = n / 2;
        int innerSp = -1;
        int stars = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= outerSp; j++){
                System.out.print("\t");
            }
            System.out.print("*\t");
            for(int j = 1; j <= innerSp; j++){
                System.out.print("\t");
            }
            if(i != 1 && i != n){
                System.out.print("*\t");
            }
            if(i <= n / 2){
                outerSp--;
                innerSp += 2;
            }else{
                outerSp++;
                innerSp -= 2;
            }
            System.out.println();
        }
    }
}
