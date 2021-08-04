package algos.searching.binary_search_applications;

public class MedianOfSortedArraysOfSameSize {
    private static double getMedian(int[] arr1, int[] arr2, int start_a, int end_a, int start_b, int end_b){
        if((end_a - start_a == 1) && (end_b - start_b == 1))
            return (1.0 * ((Math.max(arr1[start_a], arr2[start_b]) + Math.min(arr1[end_a], arr2[end_b]))) / 2);
        int m1_index = (end_a + start_a) / 2;
        int m2_index = (end_b + start_b) / 2;
        int m1 = arr1[m1_index];
        int m2 = arr2[m2_index];

        if(m1 == m2)return m1;

        if(m1 < m2){
            start_a = m1_index;
            end_b = m2_index;
        }else{
            start_b = m2_index;
            end_a = m1_index;
        }
        return getMedian(arr1, arr2, start_a, end_a, start_b, end_b);
    }
    public static void main(String[] args){
        int[] arr1 = {1, 12, 15, 26, 38};
        int[] arr2 = {2, 13, 17, 30, 33};
        System.out.println("Median of above two arrays are " + getMedian(arr1, arr2, 0, arr1.length, 0, arr2.length));
    }
}
