package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p105722

public class Problem20 {
    public String endX(String str) {
        // base case
        if(str.length() == 0)return "";
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == 'x'){
            return endX(ros) + ch;
        }else{
            return ch + endX(ros);
        }
    }
}
