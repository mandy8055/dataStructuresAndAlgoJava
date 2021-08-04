package leet_code_problems.hard;
import org.jetbrains.annotations.NotNull;

import java.util.*;
public class Problem239 {
//     public int[] maxSlidingWindow(int[] arr, int k) {
//         int[] ngr = new int[arr.length];
//       int[] res = new int[arr.length - k + 1];
//       Stack<Integer> st = new Stack<>();
//       for(int i = arr.length - 1; i >= 0; i--){
//           // Pop all smaller elements
//           while(st.size() > 0 && arr[st.peek()] < arr[i]){
//               st.pop();
//           }
//           // Update your ans
//           if(st.size() == 0){
//               ngr[i] = arr.length;
//           }else{
//               ngr[i] = st.peek();
//           }
//           // Push Current index
//           st.push(i);
//       }
//       for(int i = 0, j = 0, l = 0; i <= arr.length - k; i++){
//           if(j < i){
//             j = i;
//           }
//           while(ngr[j] < (i + k)){
//               j = ngr[j];
//           }

//           res[l++] = arr[j];
//       }
//       return res;
//     }

    // public int[] maxSlidingWindow(int[] arr, int k){
    //     Deque<Integer> dq = new ArrayDeque<>();
    // int[] res = new int[arr.length - k + 1];
    // int resIdx = 0;
    // for (int i = 0; i < arr.length; i++) {
    //   // remove numbers out of range k
    //   while (!dq.isEmpty() && dq.peek() < i - k + 1) {
    //     dq.removeFirst();
    //   }
    //   // remove smaller numbers in k range as they are useless
    //   while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
    //     dq.removeLast();
    //   }
    //   // dq contains index... r contains content
    //   dq.addLast(i);
    //   if (i >= k - 1) {
    //     res[resIdx++] = arr[dq.peek()];
    //   }
    // }
    // return res;
    // }


    public int[] maxSlidingWindow(int @NotNull [] arr, int k){
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[arr.length - k + 1];
        int reIdx = 0;
        for(int i = 0; i < arr.length; i++){
            while(dq.size() > 0 && arr[dq.peekLast()] < arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.peek() <= i - k){
                dq.removeFirst();
            }
            if(i >= k - 1){
                res[reIdx++] = arr[dq.peek()];
            }
        }
        return res;
    }
}