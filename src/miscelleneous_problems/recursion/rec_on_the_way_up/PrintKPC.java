package miscelleneous_problems.recursion.rec_on_the_way_up;

/* Question link: https://pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-kpc-official/ojquestion#!
* */

import java.util.Scanner;
public class PrintKPC {
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        printKPC(str, "");
        sc.close();
    }

    public static void printKPC(String str, String asf) {
        // Base Case
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }
        // faith
        char ch = str.charAt(0);
        String ros = str.substring(1);
        String reqCode = codes[ch - '0'];
        for(char ch1 : reqCode.toCharArray()){
            printKPC(ros, asf + ch1);
        }
    }

}
