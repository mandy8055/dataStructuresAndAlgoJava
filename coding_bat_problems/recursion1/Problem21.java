package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p154048

public class Problem21 {
    public int countPairs(String str) {
        // base case
        if(str.length() < 3)return 0;
        // Main case
        String ros = str.substring(1);
        if(str.charAt(0) == str.charAt(2)){
            return 1 + countPairs(ros);
        }else{
            return countPairs(ros);
        }
    }
}
