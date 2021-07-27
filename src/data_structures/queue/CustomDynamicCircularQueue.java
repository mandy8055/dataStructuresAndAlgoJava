package data_structures.queue;

import java.io.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/stack-and-queue/dynamic-queue-official/ojquestion

public class CustomDynamicCircularQueue {

    static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            // write ur code here
            return size;
        }

        void display() {
            // write ur code here
            for(int i = 0; i < size; i++){
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        // change this code
        void add(int val) {
            // write ur code here
            if(size == data.length){
                increaseCapacity();
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;

            } else {
                int idx = (front + size) % data.length;
                data[idx] = val;
                size++;
            }
        }

        void increaseCapacity(){
            //Create new array with double size as the current one.
            int[] newArr = new int[data.length * 2];
            //Copy elements to new array
            int tmpFront = front;
            int index = -1;
            do {
                newArr[++index] = this.data[tmpFront];
                tmpFront++;
                if (tmpFront == this.data.length) {
                    tmpFront = 0;
                }
            } while (size != index + 1);
            //Convert new array as queue
            this.data = newArr;
            //Reset front and rear values
            this.front = 0;
            this.size = index + 1;
        }

        int remove() {
            // write ur code here
            if(size == 0){
                System.out.println("Queue underflow");
                return -1;
            } else {
                int val = data[front];

                front = (front + 1) % data.length;
                size--;

                return val;
            }
        }

        int peek() {
            // write ur code here
            if(size == 0){
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
        while(!str.equals("quit")){
            if(str.startsWith("add")){
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if(str.startsWith("remove")){
                int val = qu.remove();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("peek")){
                int val = qu.peek();
                if(val != -1){
                    System.out.println(val);
                }
            } else if(str.startsWith("size")){
                System.out.println(qu.size());
            } else if(str.startsWith("display")){
                qu.display();
            }
            str = br.readLine();
        }
    }
}
