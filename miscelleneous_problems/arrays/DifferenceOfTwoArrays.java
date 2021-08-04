package miscelleneous_problems.arrays;

public class DifferenceOfTwoArrays {
    public static void getDifference(int[] arr1, int[] arr2){
        int size3 = arr2.length;
        int[] resArr = new int[size3];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = size3 - 1;
        int borrow = 0;
        while(j >= 0){
            int diff = arr2[j] - borrow;
            if(i >= 0){
                diff -= arr1[i];
            }
            if(diff < 0){
                diff += 10;
                borrow = 1;
            }else{
                borrow = 0;
            }
            resArr[k] = diff;
            k--;
            i--;
            j--;
        }
        int l = 0;
        while(resArr[l] == 0){
            l++;
        }
        for(; l < resArr.length; l++) {
            System.out.println(resArr[l]);
        }
    }
}
