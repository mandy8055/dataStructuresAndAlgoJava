package miscelleneous_problems.math;

public class EuclideanGCD {
    public static int getGCD(int num1, int num2){
        if(num1 > num2)
            return calcGCD(num1, num2);
        else
            return calcGCD(num2, num1);
    }
    // Euclidean algorithm
    private static int calcGCD(int num1, int num2){
        if(num2 == 0)return num1;
        return calcGCD(num2, num1 % num2);
    }
//    public static void main(String[] args){
//        System.out.println(getGCD(105, 30));
//    }
}
