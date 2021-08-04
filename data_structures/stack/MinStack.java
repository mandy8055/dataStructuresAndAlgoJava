package data_structures.stack;

import java.io.*;
import java.util.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/minimum-stack-i-official/ojquestion

public class MinStack {

    static class MinStack1 {
        Stack<Integer> allData;
        Stack<Integer> minData;

        public MinStack1() {
            allData = new Stack<>();
            minData = new Stack<>();
        }


        int size() {
            return allData.size();
        }

        void push(int x) {
            allData.push(x);
            if(minData.isEmpty()) {
                minData.push(x);
            } else {
                minData.push(Math.min(minData.peek(), x));
            }
        }

        int pop() {
            if(allData.size() == 0){
                System.out.println("Stack underflow");
                return -1;

            }else{
                minData.pop();
                return allData.pop();
            }
        }

        int top() {
            if(allData.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return allData.peek();
            }
        }

        int min(){
            if(allData.size() == 0){
                System.out.println("Stack underflow");
                return -1;
            }else{
                return minData.peek();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinStack1 st = new MinStack1();

        String str = br.readLine();
        while(!str.equals("quit")){
            if(str.startsWith("push")){
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if(str.startsWith("pop")){
                int val = st.pop();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("top")){
                int val = st.top();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(st.size());
            } else if(str.startsWith("min")){
                int val = st.min();
                if(val != -1){
                    System.out.println(val);
                }
            }
            str = br.readLine();
        }
    }
}
