package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p154669

public class Problem1 {
    public int factorial(int n) {
        // base case
        if(n == 0) return 1;
        // faith
        return n * factorial(n - 1);
    }
}
