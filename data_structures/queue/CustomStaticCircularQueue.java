package data_structures.queue;

import java.io.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/normal-queue-official/ojquestion

public class CustomStaticCircularQueue {

    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }
        // Adding an element
        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue overflow");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }
        int remove() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                int rv = data[front];
                front = (front + 1) % data.length;
                size--;
                return rv;
            }
        }

        void display() {
            /* Function to display status of Circular Queue */
            int i;
            int rear = (front + size) % data.length;
            for (i = 0; i < size; i++)
                System.out.print(data[(front +  i) % data.length] + " ");
            System.out.println();
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue underflow");
                return -1;
            } else {
                return data[front];

            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomQueue qu = new CustomQueue(n);

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
            } else if (str.startsWith("display")) {
                qu.display();
            }
            str = br.readLine();
        }
    }
}
