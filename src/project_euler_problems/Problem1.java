package project_euler_problems;

public class Problem1 {
    public static void main(String[] args){
        System.out.println(sumDivisible(999, 3) +
                sumDivisible(999, 5) - sumDivisible(999, 15));
    }
    private static int sumDivisible(int num, int divisor){
        int sumNatural = num / divisor;
        return divisor * ((sumNatural * (sumNatural + 1))) / 2;
    }
}
