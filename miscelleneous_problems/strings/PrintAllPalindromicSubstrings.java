package miscelleneous_problems.strings;


/* Question link: https://www.pepcoding.com/resources/online-java-foundation/string,-string-builder-and-arraylist/print-all-palindromic-substrings-official/ojquestion#!
 * */

import java.util.Scanner;

public class PrintAllPalindromicSubstrings {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.next();
        printPalindromicSubstrings(str);
        sc.close();
    }

    private static void printPalindromicSubstrings(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str.substring(i, j))) {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < str.length() && j >= 0) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
