package coding_bat_problems.recursion1;

// Problem link: https://codingbat.com/prob/p101372

public class Problem12 {
    public String changeXY(String str) {
        // base case
        if(str.length() == 0)return "";
        // main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == 'x'){
            return 'y' + changeXY(ros);
        }else{
            return ch + changeXY(ros);
        }
    }
}
