package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p183394

public class Problem18 {
    public String allStar(String str) {
        // base case
        if(str.length() == 0)return "";
        if(str.length() == 1)return str;

        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        return ch + "*" + allStar(ros);
    }
}
