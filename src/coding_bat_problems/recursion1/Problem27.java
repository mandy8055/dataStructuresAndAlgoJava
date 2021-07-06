package coding_bat_problems.recursion1;
// problem link: https://codingbat.com/prob/p183174

public class Problem27 {
    public boolean nestParen(String str) {
        if (str != null) {
            if (str.isEmpty()) return true;

            if (str.charAt(0) == '(' &&
                    str.charAt(str.length() - 1) == ')') {
                String ros = str.substring(1, str.length() - 1);
                return nestParen(ros);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}
