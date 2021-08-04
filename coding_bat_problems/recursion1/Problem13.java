package coding_bat_problems.recursion1;

// Problem link: https://codingbat.com/prob/p170924

public class Problem13 {
    public String changePi(String str) {
        // base case
        if(str.length() == 0)return "";
        if(str.length() == 1)return str;
        // Main case
        if(str.startsWith("pi")){
            String ros = str.substring(2);
            return "3.14" + changePi(ros);
        }else{
            char ch = str.charAt(0);
            String ros = str.substring(1);
            return ch + changePi(ros);
        }
    }
}
