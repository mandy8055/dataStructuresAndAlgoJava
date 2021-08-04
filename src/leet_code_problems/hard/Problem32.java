package leet_code_problems.hard;
import java.util.*;
public class Problem32 {
    public int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>(s.length());
        int res = Integer.MIN_VALUE;
        deque.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && deque.size() != 1 && s.charAt(deque.peekLast()) == '(') {
                deque.removeLast();
                if(res < i - deque.peekLast()){
                    res = i - deque.peekLast();
                }
            } else {
                deque.add(i);
            }
        }
        return res == Integer.MIN_VALUE ? 0: res;
    }
}
