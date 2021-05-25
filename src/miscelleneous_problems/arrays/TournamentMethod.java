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
            miniMax.min = Math.min(arr[i], arr[j]);
            miniMax.max = Math.max(arr[i], arr[j]);
        }else{
            int mid = (int)(Math.floor(i + j) / 2);
            miniMaxLeft = findMaxAndMin(arr, i, mid);
            miniMaxRight = findMaxAndMin(arr, mid + 1, j);
            miniMax.min = Math.min(miniMaxLeft.min, miniMaxRight.min);
            miniMax.max = Math.max(miniMaxLeft.max, miniMaxRight.max);
        }
        return miniMax;
    }

}
