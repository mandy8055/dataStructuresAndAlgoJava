package data_structures.queue;

import java.io.*;
import java.util.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/queue-to-stack-adapter-push-efficient-official/ojquestion

public class QueueToStackAdapterPushEfficient {

    static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public QueueToStackAdapter() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            while (mainQ.size() != 1) {
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            mainQ = helperQ;
            helperQ = new ArrayDeque<>();
            return val;
        }

        int top() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack underflow");
                return -1;
            }
            while (mainQ.size() != 1) {
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            helperQ.add(val);
            mainQ = helperQ;
            helperQ = new ArrayDeque<>();
            return val;

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        QueueToStackAdapter st = new QueueToStackAdapter();

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
            }
            str = br.readLine();
        }
    }
}
