package coding_bat_problems.recursion1;

//problem link: https://codingbat.com/prob/p194781

public class Problem5 {
    public int triangle(int rows) {
        // base case
        if(rows == 0)return 0;
        // faith
        return triangle(rows - 1) + rows;
    }
}
