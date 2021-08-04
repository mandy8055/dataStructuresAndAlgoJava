package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p104029

public class Problem24 {
    public String stringClean(String str) {
        // base case
        if(str.length() == 0)return "";
        if(str.length() == 1)return str;
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == str.charAt(1)){
            return stringClean(ros);
        }else{
            return ch + stringClean(ros);
        }
    }
}
