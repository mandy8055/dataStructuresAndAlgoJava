package miscelleneous_problems.recursion.rec_in_arraylist;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-kpc-official/ojquestion#!

import java.util.*;

public class GetKPC {
    private static final Scanner sc = new Scanner(System.in);
    private static final String[] codes = {
            ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"
    };

    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        System.out.println(getKPC(str));
        sc.close();
    }

    private static ArrayList<String> getKPC(String str) {
        // Base case
        if (str.isEmpty()) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        // faith
        ArrayList<String> recursionResult = getKPC(ros);
        ArrayList<String> result = new ArrayList<>();
        String code = codes[ch - '0'];
        int codeCounter = 0;
        while (codeCounter < code.length()) {
            char ch1 = code.charAt(codeCounter);
            for (String s : recursionResult) {
                result.add(ch1 + s);
            }
            codeCounter++;
        }
        return result;
    }
}
