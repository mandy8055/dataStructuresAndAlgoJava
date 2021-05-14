package algos.searching;

public class LinearSearch {
    public static int linearSearch(int[] arr, int elementToSearch){
        int counter = 0;
        for(int i : arr){
           if(i == elementToSearch)return counter;
           counter++;
       }
        return -1;
    }
}
