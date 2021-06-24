package miscelleneous_problems.recursion;

import java.util.Scanner;

public class PrintDecreasingAndIncreasing {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int num = sc.nextInt();
        printDecreasingIncreasing(num);
        sc.close();
    }
    private static void printDecreasingIncreasing(int num){
        if(num == 0)return;
        System.out.println(num);
        printDecreasingIncreasing(num - 1);
        System.out.println(num);
    }
}
