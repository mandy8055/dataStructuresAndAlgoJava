package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p184029

public class Problem11 {
    public int countHi(String str) {
        // base case
        if(str.length() == 0 || str.length() == 1)return 0;
        // main case
        if(str.startsWith("hi")){
            String ros = str.substring(2);
            return 1 + countHi(ros);
        }else{
            String ros = str.substring(1);
            return countHi(ros);
        }
    }
}
