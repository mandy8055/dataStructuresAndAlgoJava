package data_structures.stack;
import java.io.*;
import java.util.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/stack-to-queue-adapter-remove-efficient-official/ojquestion

public class StackToQueueAdapterRemoveEfficient {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public StackToQueueAdapter() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            // Move all elements from s1 to s2
            while (!mainS.isEmpty())
            {
                helperS.push(mainS.pop());
                //s1.pop();
            }

            // Push item into s1
            mainS.push(val);

            // Push everything back to s1
            while (!helperS.isEmpty())
            {
                mainS.push(helperS.pop());
                //s2.pop();
            }
        }

        int remove() {
            if (mainS.isEmpty())
            {
                System.out.println("Queue underflow");
                return -1;
            }

            // Return top of s1
            int x = mainS.peek();
            mainS.pop();
            return x;
        }

        int peek() {
            if(mainS.isEmpty()){
                System.out.println("Queue underflow");
                return -1;
            }
            return mainS.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = br.readLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
            str = br.readLine();
        }
    }
}
