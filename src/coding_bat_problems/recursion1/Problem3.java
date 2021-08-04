package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p120015

public class Problem3 {
    public int fibonacci(int n) {
        // base case
        if(n == 0 || n == 1)return n;
        // faith
        int first = fibonacci(n - 1);
        int second = fibonacci(n - 2);
        return first + second;
    }
}
