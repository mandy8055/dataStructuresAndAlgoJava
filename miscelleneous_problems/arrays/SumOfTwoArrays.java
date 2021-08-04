package miscelleneous_problems.arrays;

public class SumOfTwoArrays{
    private static void findSum(int[] arr1, int[] arr2){
        // Getting the size of arrays and determining the size of resultant array
        int size1 = arr1.length;
        int size2 = arr2.length;
        int size3 = size1 + 1;
        if(size1 < size2){
            size3 = size2 + 1;
        }

        int[] resArr = new int[size3];
        int i = size1 - 1;
        int j = size2 - 1;
        int k = size3 - 1;
        int carry = 0;
        while(k >= 0){
            int sum = carry;
            if(i >= 0){
                sum += arr1[i];
            }
            if(j >= 0){
                sum += arr2[j];
            }
            resArr[k] = sum % 10;
            carry = sum / 10;
            i--;
            j--;
            k--;
        }
        for(int l = 0; l < size3; l++){
            if(l == 0 && resArr[l] == 0){}
            else{
                System.out.println(resArr[l]);
            }
        }
    }
}
