package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p163932

public class Problem6 {
    public int sumDigits(int n) {
        // base case
        if(n == 0)return n;
        // faith
        int rem = n % 10;
        return sumDigits(n / 10) + rem;
    }
}
