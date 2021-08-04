package miscelleneous_problems.math.fibonacci_problems;

public class PrintFibonacciNumbersTillN {
    // Iterative Approach
    public static void printFibonacciSeries(int num){
//        fibonacciIterative(num);
        for(int i = 0; i < num; i++){
            System.out.print(fibonacciRecursive(i) + " ");
        }
    }

    private static void fibonacciIterative(int num){
        int a = 0, b = 1;
        int i = 1;
        while(i <= num){
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
            i++;
        }
    }

    private static int fibonacciRecursive(int num){
        if(num == 0)return 0;
        if(num == 1 || num == 2)return 1;
        return fibonacciRecursive(num - 2) + fibonacciRecursive(num - 1);
    }
}
