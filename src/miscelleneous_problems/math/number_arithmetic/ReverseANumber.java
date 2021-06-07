package miscelleneous_problems.math.number_arithmetic;

public class ReverseANumber {
    public static int reverseANumber(int num){
        // O(log n) --> base 10
        return reverseNumber(num);
    }
    private static int reverseNumber(int num){
        int temp = num;
        int rev = 0;
        while(temp != 0){
            int rem = temp % 10;
            rev = (rev * 10) + rem;
            temp /= 10;
        }
        return rev;
    }
}
