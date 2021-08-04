package coding_bat_problems.recursion1;

// problem link: https://codingbat.com/prob/p183649

public class Problem2 {
    public int bunnyEars(int bunnies) {
        // base case
        if(bunnies == 0)return 0;
        //faith
        return bunnyEars(bunnies - 1) + 2;
    }
}
