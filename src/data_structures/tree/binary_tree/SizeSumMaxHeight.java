package data_structures.tree.binary_tree;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;

// Problem link: https://classroom.pepcoding.com/myClassroom/the-switch-program-3/binary-tree/size-sum-max-height-binarytree-official/ojquestion

public class SizeSumMaxHeight {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static @NotNull Node construct(Integer @NotNull [] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        int sz = 0;
        sz += size(node.left);
        sz += size(node.right);
        sz += 1; // Size of current node
        return sz;
    }

    public static int sum(Node node) {
        // Negative base case
        if(node == null){
            return 0;
        }
        // Base Case (leaf)
        if(node.left == null && node.right == null){
            return node.data;
        }
        // faith
        int totalSum = node.data;
        totalSum += sum(node.left);
        totalSum += sum(node.right);
        return totalSum;
    }

    public static int max(Node node) {
        // Negative base case
        if(node == null)return Integer.MIN_VALUE;
        // Base Case (If leaf node)
        if(node.left == null && node.right == null){
            return node.data;
        }
        int max = node.data;
        // faith
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        return Math.max(max, Math.max(leftMax, rightMax));
    }

    public static int height(Node node) {
        if(node == null || (node.left == null && node.right == null)){
            return 0;
        }
        int lht = height(node.left);
        int rht = height(node.right);
        return (Math.max(lht, rht) + 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (!values[i].equals("n")) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }

        Node root = construct(arr);

        int size = size(root);
        int sum = sum(root);
        int max = max(root);
        int ht = height(root);
        System.out.println(size);
        System.out.println(sum);
        System.out.println(max);
        System.out.println(ht);
    }
}
