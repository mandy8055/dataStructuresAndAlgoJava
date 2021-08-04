package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p118182

public class Problem29 {
    public boolean strCopies(String str, String sub, int n) {
        if (str != null) {
            // Base case
            if (n == 0) return true;
            if (str.length() < sub.length()) return false;
            // Main case
            String ros = str.substring(1);
            if (str.startsWith(sub)) {
                return strCopies(ros, sub, n - 1);
            } else {
                return strCopies(ros, sub, n);
            }
        } else {
            return false;
        }
    }
}
