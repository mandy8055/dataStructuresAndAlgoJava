package miscelleneous_problems.math.number_system;

public class DecimalToAnyBaseConversion {
    public static int getValueInAnyBase(int n, int b){
        return convertDecimalToAnyBase(n, b);
    }
    private static int convertDecimalToAnyBase(int num, int base){
        int res = 0;
        int power = 1;
        int tempNum = num;
        while(tempNum != 0) {
            int rem = tempNum % base;
            tempNum /= base;
            res += (rem * power);
            power *= 10;
        }
        return res;
    }
}
