package data_structures.stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/next-greater-element-official/ojquestion

public class NextGreaterElementRight {

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] nge = solve1(a);
        display(nge);
    }
    private static int[] solve(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        st.push(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() != 0 && st.peek() < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return res;
    }
    private static int[] solve1(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        res[arr.length - 1] = -1;
        // Pushing the index onto the Stack
        st.push(arr.length - 1);
        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() != 0 && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            if (st.size() == 0) {
                res[i] = -1;
            } else {
                res[i] = arr[st.peek()];
            }
            st.push(i);
        }
        return res;
    }
}
