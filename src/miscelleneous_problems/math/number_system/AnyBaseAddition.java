package miscelleneous_problems.math.number_system;

public class AnyBaseAddition {
    public static int anyBaseAdditionResult(int n1, int n2, int b){
        return anyBaseAddition(n1, n2, b);
    }

    private static int anyBaseAddition(int num1, int num2, int base){
        int carry = 0;
        int sum = 0;
        int res = 0;
        int power = 1;
        while(num1 != 0 || num2 != 0 || carry > 0){
            int rem1 = num1 % 10;
            int rem2 = num2 % 10;
            num1 /= 10;
            num2 /= 10;
            sum = rem1 + rem2 + carry;
            res += power * (sum % base);
            carry = sum / base;
            power *= 10;
        }
        return res;
    }
}
