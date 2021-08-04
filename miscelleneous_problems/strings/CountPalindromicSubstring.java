package miscelleneous_problems.strings;
import java.util.Scanner;
public class CountPalindromicSubstring {
    private static final Scanner sc = new Scanner(System.in);
    int count = 0;
    public static void main(String[] args){
        String str = sc.next();
        CountPalindromicSubstring countPalindromicSubstring = new CountPalindromicSubstring();
        System.out.println(countPalindromicSubstring.countPalindromicSubstrings(str));
        sc.close();
    }
    private int countPalindromicSubstrings(String str){
        if(str.length() == 0)return 0;
        for(int i = 0; i < str.length(); i++){ // This loop is from mid-point
            isPalindrome(str, i, i); // Count Odd length palindromes
            isPalindrome(str, i, i + 1); // Count even length palindromes
        }
        return count;
    }
    private void isPalindrome(String str, int left, int right){
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            count++;
            left--;
            right++;
        }
    }
}
