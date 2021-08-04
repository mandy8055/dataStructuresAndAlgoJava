package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p107330

public class Problem4 {
    public int bunnyEars2(int bunnies) {
        // base case
        if(bunnies == 0)return 0;
        // faith
        return bunnies % 2 == 0? bunnyEars2(bunnies - 1) + 3 :  bunnyEars2(bunnies - 1) + 2;
    }
}
