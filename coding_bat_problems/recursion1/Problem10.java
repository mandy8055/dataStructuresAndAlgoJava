package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p170371

public class Problem10 {
    public int countX(String str) {
        // base case
        if(str.length() == 0)return 0;
        // faith
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == 'x'){
            return 1 + countX(ros);
        }else{
            return countX(ros);
        }
    }
}
