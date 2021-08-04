package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p158888

public class Problem9 {
    // TC --> O(N)
    public int powerN1(int base, int n) {
        // base case
        if (n == 0) return 1;
        // faith
        return base * powerN1(base, n - 1);
    }
    // TC --> O(log N)
    public int powerN2(int base, int n) {
        // base case
        if (n == 0) return 1;
        // faith
        int powerBy2 = powerN2(base, n / 2);
        if (n % 2 == 0) {
            return powerBy2 * powerBy2;
        } else {
            return base * powerBy2 * powerBy2;
        }
    }
}
