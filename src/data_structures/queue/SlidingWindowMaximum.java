package data_structures.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    private static int[] slidingWindowMaximum(final int[] arr, int k){
        int[] res = new int[arr.length - k + 1];
        int resIdx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < arr.length; i++){
            while(dq.size() != 0 && arr[dq.peekLast()] < arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(dq.size() != 0 && dq.peek() <= i - k){
                dq.removeFirst();
            }
            if(dq.size() != 0 && i >= k - 1){
                res[resIdx++] = arr[dq.peek()];
            }
        }
        return res;
    }
}
