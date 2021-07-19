package data_structures.stack;

import java.io.*;
import java.util.Stack;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/lah-official/ojquestion

public class MaxHistogramArea {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(findMaxArea(a));
    }

    private static int findMaxArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        // Get the left boundary
        int[] lb = new int[arr.length];
        lb[0] = -1;
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                lb[i] = -1;
            } else {
                lb[i] = st.peek();
            }
            st.push(i);
        }
        st = new Stack<>();
        // Get the right boundary
        int[] rb = new int[arr.length];
        rb[arr.length - 1] = arr.length;
        st.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                rb[i] = arr.length;
            } else {
                rb[i] = st.peek();
            }
            st.push(i);
        }

        // Calculate the maximum
        int maxArea = Integer.MIN_VALUE;
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
