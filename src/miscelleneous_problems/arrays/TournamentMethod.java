package miscelleneous_problems.arrays;

public class TournamentMethod {
    private static final int[] ARRAY = {80, 20, 50, 5, 90, 23, 15};
    static class MiniMax{
        int min;
        int max;
    }

    // Total number of comparisons 3n/2 - 2, and time complexity O(n)



    public static void main(String[] args){
        MiniMax minAndMax = findMaxAndMin(ARRAY, 0, ARRAY.length - 1);
         System.out.println("The minimum element in the array is " + minAndMax.min + " and the maximum element in the array is " + minAndMax.max);
    }
    private static MiniMax findMaxAndMin(int[] arr, int i, int j){
        MiniMax miniMax = new MiniMax();
        MiniMax miniMaxLeft = new MiniMax();
        MiniMax miniMaxRight = new MiniMax();
        // Array contains only one element
        if(i == j){
            miniMax.min = arr[i];
            miniMax.max = arr[j];
        }else if(i == j - 1){ //Array contains two elements
            if(arr[i] < arr[j]){
                miniMax.min = arr[i];
                miniMax.max = arr[j];
            }else{
                miniMax.min = arr[j];
                miniMax.max = arr[i];
            }
        }else{
            int mid = (int)(Math.floor(i + j) / 2);
            miniMaxLeft = findMaxAndMin(arr, i, mid);
            miniMaxRight = findMaxAndMin(arr, mid + 1, j);

            if(miniMaxLeft.min < miniMaxRight.min)miniMax.min = miniMaxLeft.min;
            else miniMax.min = miniMaxRight.min;
            if(miniMaxLeft.max < miniMaxRight.max)miniMax.max = miniMaxRight.max;
            else miniMax.max = miniMaxLeft.max;
        }
        return miniMax;
    }

}
