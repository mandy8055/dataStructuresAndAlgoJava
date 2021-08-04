package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p137918

public class Problem26 {
    public String parenBit(String str) {
        // Main case
        char ch = str.charAt(0);
        String ros = str.substring(1);
        if(ch == '('){
            return ch + parenBit(ros);
        }else if(ch == ')'){
            return ch + "";
        }else if(!str.contains("(")){
            return ch + parenBit(ros);
        }else{
            return parenBit(ros);
        }
    }
}
