package miscelleneous_problems.recursion.rec_intro;
import java.util.Scanner;
/*Question link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/introduction-to-recursion/print-decreasing-official/ojquestion
* */
public class PrintDecreasing {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int num = sc.nextInt();
        printDecreasing(num);
        sc.close();
    }
    private static void printDecreasing(int num){
        if(num == 0)return;
        System.out.println(num);
        printDecreasing(num - 1);
    }
}
