package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p101409

public class Problem7 {
    public int count7(int n) {
        // base case
        if(n == 0)return 0;
        // faith
        int rem = n % 10;
        if(rem == 7)return 1 + count7(n / 10);
        else return count7(n / 10);
    }
}
