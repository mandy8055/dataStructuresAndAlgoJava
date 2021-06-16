package miscelleneous_problems.arrays;

public class SubArraysOfArray {

    public static void main(String[] args){
        int[] arr = {80, 20, 50, 5};
        printSubArraysOfArray(arr);
    }

    private static void printSubArraysOfArray(int[] arr){
        int size = arr.length;
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                System.out.print("{");
                for(int k = i; k <= j; k++){
                    // To improve the printing style, this condition is added
                    if(k == j)
                        System.out.print(arr[k]);
                    else
                        System.out.print(arr[k] + ", ");

                }
                System.out.print("}");
                System.out.println();
            }
        }
    }
}
