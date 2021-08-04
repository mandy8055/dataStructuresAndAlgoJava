package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p158175

public class Problem19 {
    public String pairStar(String str) {
        // base case
        if(str.length() == 0)return "";
        if(str.length() == 1)return str;
        // Main case
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(1);
        String ros = str.substring(1);
        if(ch1 == ch2){
            return ch1 + "*" + pairStar(ros);
        }else{
            return ch1 + pairStar(ros);
        }
    }
}
