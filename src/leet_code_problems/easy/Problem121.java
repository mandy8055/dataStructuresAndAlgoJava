package leet_code_problems.easy;

public class Problem121 {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (price < leastSoFar) {
                leastSoFar = price;
            }
            int currentMax = price - leastSoFar;
            if (currentMax > res) {
                res = currentMax;
            }
        }
        return res;
    }
}
