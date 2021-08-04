package leet_code_problems.hard;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Problem84 {
    public int largestRectangleArea(int @NotNull [] arr) {
        // Left boundary
        int[] lb = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }

        // Right boundary
        int[] rb = new int[arr.length];
        st = new Stack<>();
        st.push(rb.length - 1);
        rb[rb.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = arr.length;

            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }


        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int width = rb[i] - lb[i] - 1;
            int area = arr[i] * width;
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
