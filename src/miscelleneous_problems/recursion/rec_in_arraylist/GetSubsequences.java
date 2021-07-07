package miscelleneous_problems.recursion.rec_in_arraylist;

// Problem link: https://www.pepcoding.com/resources/online-java-foundation/recursion-with-arraylists/get-subsequence-official/ojquestion#!


import java.util.ArrayList;
import java.util.Scanner;
public class GetSubsequences {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        String str = sc.nextLine();
        System.out.println(getSubSequence(str));
        sc.close();
    }
    private static ArrayList<String> getSubSequence(String str){
        // base case
        if(str.isEmpty()){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        // faith
        ArrayList<String> recursionResult = getSubSequence(ros);
        // Not include ch
        ArrayList<String> result = new ArrayList<>(recursionResult);
        // Include ch
        for(String s : recursionResult){
            result.add(ch + s);
        }
        return result;
    }
}
