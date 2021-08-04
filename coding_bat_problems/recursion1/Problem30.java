package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p195413

public class Problem30 {
    public int strDist(String str, String sub) {
        if (str != null) {
            if (str.length() < sub.length()) {
                return 0;
            }
            if (str.startsWith(sub)) {
                return str.lastIndexOf(sub) + sub.length();
            }
            return strDist(str.substring(1), sub);
        } else {
            return 0;
        }
    }
}
