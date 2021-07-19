package data_structures.stack;
import java.util.Scanner;
import java.util.Stack;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/duplicate-brackets-official/ojquestion


public class DuplicateBrackets {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String str = sc.nextLine();
        System.out.println(duplicateBrackets(str));
        sc.close();
    }
    private static boolean duplicateBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == ')') {
                if (st.peek() == '(') {
                    return true;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            } else {
                st.push(ch);
            }
        }
        return false;
    }
}
