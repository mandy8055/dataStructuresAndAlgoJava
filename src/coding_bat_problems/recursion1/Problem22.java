package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p161124

public class Problem22 {
    public int countAbc(String str) {
        // base case
        if(str.length() <= 2)return 0;
        // Main case
        if(str.startsWith("abc") || str.startsWith("aba")){
            String ros = str.substring(2);
            return 1 + countAbc(ros);
        }else{
            String ros = str.substring(1);
            return countAbc(ros);
        }
    }
}
