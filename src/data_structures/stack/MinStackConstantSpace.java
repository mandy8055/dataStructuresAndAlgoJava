package data_structures.stack;

import java.io.*;
import java.util.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/min-stack-ii-official/ojquestion


public class MinStackConstantSpace {

    static class MinStack {
        Stack<Integer> data;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            // If val is less than or equal to min, push min and update min
            if(val <= min){
                data.push(min);
                min = val;
            }
            // else just push the val
            data.push(val);
        }

        int pop() {
            if(data.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                // pop the data
                int dat = data.pop();
                // if the previous popped data is equal to min,
                if(dat == min) {
                    min = data.pop();
                }
                return dat;
            }
        }

        int top() {
            if(data.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return data.peek();
            }
        }

        int min() {
            return min;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack st = new MinStack();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("min")) {
                int val = st.min();
                if (val != -1) {
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
