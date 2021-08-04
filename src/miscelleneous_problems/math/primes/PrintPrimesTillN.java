package miscelleneous_problems.math.primes;

import java.util.Arrays;

public class PrintPrimesTillN {
    public static void printPrimes(int num){
        eratosthenesSieve(num);
    }
    // Time complexity --> O(nloglogn). Please do read how? It is interesting
    // Space complexity --> O(n)
    private static void eratosthenesSieve(int num){
        // 1. Take the auxiliary array and fill with all 1 indicating all are initially primes.
        int[] primes = new int[num + 1];
        Arrays.fill(primes, 1);
        // 2. Make 0 and 1 as zero initially. They are not primes
        primes[0] = primes[1] = 0;
        // 3. Main case
        for(int i = 2; i * i <= num; i++){
            if(primes[i] == 1){
                for(int j = i * i; j <= num; j += i){
                    primes[j] = 0;
                }
            }
        }
        for(int i = 2; i <= num; i++){
            if(primes[i] == 1)
                System.out.print(i + " ");
        }
    }
}
