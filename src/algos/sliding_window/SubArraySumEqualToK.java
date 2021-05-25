package algos.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArraySumEqualToK {
    public static void main(String[] args){
        int[] arr = {1, 4, -20, 3, 10, 5};
//        int[] arr = {10, 2, -2, -20, 10};
        int givenSum = -15; // 0, 5, 15 --> Edge cases
        System.out.println(subArraySumEqualToK(arr, givenSum));
    }

    private static ArrayList<Integer> subArrayForNonNegativeValuesOnly(int[] arr, int givenSum){
        ArrayList<Integer> arrayList = new ArrayList<>();
        int start = 0;
        int end = 1;
        int sum = arr[0];
        while(end <= arr.length){
            if(sum == givenSum){
                arrayList.add(start);
                arrayList.add(end - 1);
                return arrayList;
            }else if(sum > givenSum && start < end - 1){
                sum -= arr[start++];
            }else if(end < arr.length)
                sum += arr[end++];
        }
        arrayList.add(-1);
        arrayList.add(-1);
        return arrayList;
    }

    private static ArrayList<Integer> subArraySumEqualToK(int[] arr, int givenSum){
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currentSum = 0;
        for(int i =  0; i < arr.length; i++){
            currentSum += arr[i];
            if((currentSum - givenSum) == 0){
                arrayList.add(0);
                arrayList.add(i);
                return arrayList;
            }
            if(hashMap.containsKey(currentSum - givenSum)){
               arrayList.add(hashMap.get(currentSum - givenSum) + 1);
               arrayList.add(i);
               return arrayList;
            }
            hashMap.put(currentSum, i);
        }
        arrayList.add(-1);
        arrayList.add(-1);
        return arrayList;
    }
}
