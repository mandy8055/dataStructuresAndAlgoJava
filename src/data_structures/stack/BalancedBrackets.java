package data_structures.stack;
import java.util.Scanner;
import java.util.Stack;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/balanced-brackets-official/ojquestion

public class BalancedBrackets {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        System.out.println(balancedBrackets(str));
        sc.close();
    }

    private static boolean balancedBrackets(String str){
        Stack<Character> st = new Stack<>();
        // Base case
        if(str.isEmpty()){
            return true;
        }
        for(char ch : str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else if(ch == ')'){
                if(st.size() != 0 && st.peek() == '('){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == '}'){
                if(st.size() != 0 && st.peek() == '{'){
                    st.pop();
                }else{
                    return false;
                }
            }else if(ch == ']'){
                if(st.size() != 0 && st.peek() == '['){
                    st.pop();
                }else{
                    return false;
                }
            }
            // Do nothing if there are other characters
        }
        return st.size() == 0;
    }
}