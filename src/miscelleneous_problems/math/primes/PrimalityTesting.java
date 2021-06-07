package miscelleneous_problems.math.primes;

public class PrimalityTesting {
    private int num;
    public static boolean isPrime(int num){
        return checkPrime(num);
    }
    // Time complexity --> O(sqrt(num))
    private static boolean checkPrime(int num){
        if(num == 2)return true;
        if(num % 2 == 0)return false;
        int i = 3;
        while(i * i <= num) // Why the loop runs till sqrt(num) times?
        {
            if(num % i == 0)return false;
            i += 2;
        }
        return true;
    }
}
