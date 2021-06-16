package miscelleneous_problems.arrays;

import miscelleneous_problems.math.number_system.DecimalToAnyBaseConversion;

public class SubsetsOfArray {
    // Method 1:By using bit manipulation
    private static void printSubsets(int[] arr){
        int size = arr.length;
        int numberOfSubsets = (int)Math.pow(2, size);
        for(int i = 0; i < numberOfSubsets; i++) {
            for (int j = size - 1; j >= 0; j--) {
                if ((i & (1 << j)) > 0) {
                    System.out.print(arr[size - 1 - j] + "\t");
                } else {
                    System.out.print("-\t");
                }
            }
            System.out.println();
        }
    }
//  Method 2: By using general binary mapping approach
    private static void printSubsetsUsingBinaryMapping(int[] arr){
        int size = arr.length;
        int numberOfSubsets = (int)Math.pow(2, size);
        for(int i = 0; i < numberOfSubsets; i++){
            int bin = DecimalToAnyBaseConversion.getValueInAnyBase(i, 2);
            int divisorPower = (int)Math.pow(10, size - 1);
            for (int k : arr) {
                int rem = bin / divisorPower;
                bin %= divisorPower;
                divisorPower /= 10;
                if (rem == 0) {
                    System.out.print("-\t");
                } else {
                    System.out.print(k + "\t");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[] arr = {10, 20, 30};
        printSubsetsUsingBinaryMapping(arr);
    }
}
