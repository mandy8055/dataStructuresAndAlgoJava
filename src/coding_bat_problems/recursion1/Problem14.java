package coding_bat_problems.recursion1;

// Problem link: https://codingbat.com/prob/p118230

public class Problem14 {
    public String noX(String str) {
        // base case
        if(str.length() == 0)return "";
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == 'x'){
            return noX(ros);
        }else{
            return ch + noX(ros);
        }
    }
}
