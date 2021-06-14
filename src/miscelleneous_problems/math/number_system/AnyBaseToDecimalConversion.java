package miscelleneous_problems.math.number_system;

public class AnyBaseToDecimalConversion {

    public static int getValueInDecimal(int n, int b){
        return convertAnyBaseToDecimal(n, b);
    }


    private static int convertAnyBaseToDecimal(int num, int base){
        int res = 0, power = 1;
        int tempNum = num;
        while(tempNum != 0){
            int rem = tempNum % 10;
            tempNum /= 10;
            res += (rem * power);
            power *= base;
        }
        return res;
    }

}
