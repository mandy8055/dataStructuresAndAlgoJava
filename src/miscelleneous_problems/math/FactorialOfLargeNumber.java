package miscelleneous_problems.math;

import java.util.ArrayList;
import java.util.Arrays;

public class FactorialOfLargeNumber{
    public static void main(String[] args){
//        int num = 1000;
//        int[] primes = new int[num + 1];
//        Arrays.fill(primes, 1);
//        primes[0] = primes[1] = 0;
//        for(int i = 2; i * i <= num; i++){
//            if(primes[i] == 1)
//                for(int j = i * i; j <= num; j += i)
//                    primes[j] = 0;
//        }
//
//        for(int i = 2; i < num; i++)
//            if(primes[i] == 1)
//                System.out.print(i + " ");
        int i = 10;
        if(i++ == i){
            System.out.println(i + " is good");
        }else
            System.out.println(i + " is bad");

    }
}
