package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p143900

public class Problem25 {
    // Efficient way needed
    public int countHi2(String str) {
        // Base case
        if(str.length() <= 1)return 0;
        if(str.length() == 2 && str.startsWith("hi"))
            return 1;
        if(str.length() == 2)return 0;

        // Main case
        if(str.startsWith("x")){
            if(str.startsWith("hi", 1)){
                String ros = str.substring(3);
                return countHi2(ros);
            }else{
                String ros = str.substring(1);
                return countHi2(ros);
            }
        }else if(str.startsWith("hi")){
            String ros = str.substring(2);
            return 1 + countHi2(ros);
        }else{
            String ros = str.substring(1);
            return countHi2(ros);
        }
    }
}
