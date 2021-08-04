package miscelleneous_problems.math.number_arithmetic;

public class CountDigitsOfANumber {
    public static int countNumberOfDigits(int num){
        return countNOD(num);
    }
    private static int countNOD(int num){
        int temp = num;
        int counter = 0;
        // time complexity : O(logn) --> base 10. Why?
        while(temp != 0){
          counter++;
          temp /= 10;
        }
        return counter;
    }
}
