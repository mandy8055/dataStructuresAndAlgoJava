package miscelleneous_problems.math.number_system;

public class AnyBaseMultiplication {
    public static int getFinalProductResult(int b, int n1, int n2){
        return getProduct(b, n1, n2);
    }
    private static int getProduct(int b, int n1, int n2){
        int res = 0;
        int power = 1;
        while(n2 != 0){
            int getProdSingle = getProductFromSingleDigit(b, n1, n2 % 10);
            n2 /= 10;
            getProdSingle *= power;
            res = AnyBaseAddition.anyBaseAdditionResult(getProdSingle, res, b);
            power *= 10;
        }
        return res;
    }
    private static int getProductFromSingleDigit(int b, int n1, int singleDigitN2){
        int power = 1;
        int carry = 0;
        int result = 0;
        while(n1 != 0 || carry > 0){
            int rem1 = n1 % 10;
            n1 /= 10;
            int prod = (rem1 * singleDigitN2) + carry;
            carry = prod / b;
            result += (power * (prod % b));
            power *= 10;
        }
        return result;
    }
}
