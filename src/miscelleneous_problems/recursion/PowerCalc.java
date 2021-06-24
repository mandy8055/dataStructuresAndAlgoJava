package miscelleneous_problems.recursion;

/*Question link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/introduction-to-recursion/power-linear-official/ojquestion
* */

import java.util.Scanner;
public class PowerCalc {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int x = sc.nextInt();
        int n = sc.nextInt();
//        System.out.println(power_linear(x, n));
        System.out.println(power_logarithmic(x, n));
        sc.close();
    }
    // Space complexity : O(n)
    private static int power_linear(int x, int n){
        if(n == 0)return 1;
        return x * power_linear(x, n - 1);
    }
    // Space complexity : O(log n ) --> O(1)
    private static int power_logarithmic(int x, int n){
        if(n == 0)return 1;
        int tempPower = power_logarithmic(x, n / 2);
        if(n % 2 == 0){
            return tempPower * tempPower;
        }else{
            return x * tempPower * tempPower;
        }
    }
}
