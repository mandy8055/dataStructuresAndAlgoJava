package miscelleneous_problems.recursion.rec_on_the_way_up;

/* Question link: https://pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion#!
* */

import java.util.Scanner;
public class PrintSubsequences {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        printSS(str, "");
        sc.close();
    }

    public static void printSS(String str, String ans) {
        // Base Case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        // Faith
        char ch = str.charAt(0);
        String ros = str.substring(1);
        printSS(ros, ans + ch);
        printSS(ros, ans);
    }
}
