package coding_bat_problems.recursion1;

// problem link : https://codingbat.com/prob/p192383

public class Problem8 {
    public int count8(int n) {
        // base case
        if (n == 0) return 0;
        // faith
        int rem = n % 10;
        if (rem == 8) {
            if (n % 100 == 88) {
                return 2 + count8(n / 10);
            } else {
                return 1 + count8(n / 10);
            }
        } else {
            return count8(n / 10);
        }

    }
}
