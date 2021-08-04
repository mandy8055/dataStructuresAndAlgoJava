package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p186177

public class Problem28 {
    public int strCount(String str, String sub) {
        // base case
        if (str.isEmpty()) return 0;

        // Main case
        int subLength = sub.length();
        if (str.startsWith(sub)) {
            String ros = str.substring(subLength);
            return 1 + strCount(ros, sub);
        } else {
            String ros = str.substring(1);
            return strCount(ros, sub);
        }
    }
}
