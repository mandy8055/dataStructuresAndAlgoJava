package miscelleneous_problems.math.number_arithmetic;

public class RotateANumber {
    public static int rotateANumber(int num, int k){
        return rotateKTimes(num, k);
    }
    private static int rotateKTimes(int num, int k){
        int numberOfDigits = CountDigitsOfANumber.countNumberOfDigits(num);
        k %= numberOfDigits; // What if we write this line below the if statement?
        if(k < 0){
            k += numberOfDigits;
        }
        int divisor = (int)Math.pow(10, k);
        int quotient =  num / divisor;
        int remainder = num % divisor;
        remainder = (remainder * (int)Math.pow(10, numberOfDigits - k) + quotient); // Significance of this line
        return remainder;
    }
}
