package miscelleneous_problems.recursion.rec_intro;

/*Question Link:https://classroom.pepcoding.com/myClassroom/the-switch-program-3/introduction-to-recursion/print-increasing-official/ojquestion
*
* */
import java.util.Scanner;
public class PrintIncreasing {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int numToPrint = sc.nextInt();
        printIncreasing(numToPrint);
        sc.close();
    }
    private static void printIncreasing(int num){
        // Boundary Case(1st assumption of PMI)
        if(num == 0)return;
        printIncreasing(num - 1);
        System.out.println(num);
    }

}
