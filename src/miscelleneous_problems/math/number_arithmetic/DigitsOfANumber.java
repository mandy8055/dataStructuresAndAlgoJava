package miscelleneous_problems.math.number_arithmetic;

public class DigitsOfANumber {
    public static void getDigitsOfNumber(int num){
        getDigits(num);
    }
    private static void getDigits(int num){
        int numberOfDigits = CountDigitsOfANumber.countNumberOfDigits(num);
        int tempNum = num;
        int divisor = (int)Math.pow(10, numberOfDigits - 1);
        while(divisor > 0) // why divisor is taken instead of number itself
        {
           System.out.println(tempNum / divisor);
           tempNum %= divisor;
           divisor /= 10;
        }
    }
}
