package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p167015

public class Problem23 {
    public int count11(String str) {
        // base case
        if(str.length() == 0)return 0;

        // Main case
        if(str.startsWith("11")){
            String ros = str.substring(2);
            return 1 + count11(ros);
        }else{
            String ros = str.substring(1);
            return count11(ros);
        }
    }
}
