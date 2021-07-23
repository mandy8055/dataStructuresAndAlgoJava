package data_structures.stack;

import java.util.Stack;

public class CelebrityProblem {
    private static void celebrityProblem(int[][] arr){
        Stack<Integer> st = new Stack<>();
        // Push all the indices onto the stack.
        for(int i = 0; i < arr.length; i++){
            st.push(i);
        }
        // Eliminate people who are not the celebrity
        while(st.size() >= 2){
            int p1 = st.pop();
            int p2 = st.pop();
            if(arr[p1][p2] == 1){
                // P1 knows P2 -> P1 cannot be the celebrity
                st.push(p2);
            }else{
                // P1 doesn't know P2 -> P2 cannot be a celebrity
                st.push(p1);
            }
        }
        int potentialCandidate = st.pop();
        for(int i = 0; i < arr.length; i++){
            if(i != potentialCandidate){
                if(arr[potentialCandidate][i] == 1 || arr[i][potentialCandidate] == 0){
                    System.out.println("none");
                    return;
                }
            }
        }
        System.out.println(potentialCandidate);
    }
}
