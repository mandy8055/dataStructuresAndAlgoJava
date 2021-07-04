package miscelleneous_problems.recursion.rec_intro;

import java.util.Scanner;

public class PrintIncreasingDecreasing {
    private static final Scanner sc = new Scanner(System.in);
    static int value = 1;
    public static void main(String[] args){
        int num = sc.nextInt();
        printIncreasingDecreasing(num);
        sc.close();
    }
    private static void printIncreasingDecreasing(int num){
        if((2 * num) - value == 0){
            System.out.println("1");
            return;
        }
        if(value > num){
            System.out.println(2 * num - value + 1);
        }else{
            System.out.println(value);
        }
        value++;
        printIncreasingDecreasing(num);
    }
}
