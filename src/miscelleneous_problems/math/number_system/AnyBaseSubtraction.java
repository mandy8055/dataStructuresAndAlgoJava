package miscelleneous_problems.math.number_system;

public class AnyBaseSubtraction {
    public static int getDiff(int b, int n1, int n2){
        return getDifference(b, n1, n2);
    }
    private static int getDifference(int b, int n1, int n2){
        int power = 1;
        int res = 0;
        int borrow = 0;
        while(n2 != 0){
            int rem1 = n2 % 10;
            int rem2 = n1 % 10;
            n2 /= 10;
            n1 /= 10;
            rem1 -= borrow;
            int diff = rem1 - rem2;
            if(diff < 0){
                diff += b;
                borrow = 1;
            }else
                borrow = 0;
            res += (diff * power);
            power *= 10;
        }
        return res;
    }
}
