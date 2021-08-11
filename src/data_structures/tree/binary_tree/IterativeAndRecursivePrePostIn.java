package data_structures.tree.binary_tree;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;
public class IterativeAndRecursivePrePostIn {
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

  /*public static void iterativePrePostInTraversal1(Node node) {
    // Pre order
    // recursivePre(node);
    iterativePre(node);
    System.out.println();
    // In order
    recursiveIn(node);
    System.out.println();
    // Post order
    recursivePost(node);
  }*/
    // All traversals using a single method
    public static void iterativePrePostInTraversal(Node node){
        StringBuilder sbPre = new StringBuilder();
        StringBuilder sbIn = new StringBuilder();
        StringBuilder sbPost = new StringBuilder();
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node, 1));
        while(!st.isEmpty()){
            Pair top = st.peek();
            if(top.state == 1){ // Pre, state++, push the left child
                sbPre.append(top.node.data).append(" ");
                top.state++;
                if(top.node.left != null){
                    st.push(new Pair(top.node.left, 1));
                }

            }else if(top.state == 2){ // In, state++, push the right child
                sbIn.append(top.node.data).append(" ");
                top.state++;
                if(top.node.right != null){
                    st.push(new Pair(top.node.right, 1));
                }
            }else{ // Post, pop
                sbPost.append(top.node.data).append(" ");
                st.pop();
            }
        }
        System.out.println(sbPre + "\n" + sbIn + "\n" + sbPost);
    }

    private static void recursivePre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        recursivePre(node.left);
        recursivePre(node.right);
    }

    private static void iterativePre(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        st.push(node);
        while (!st.isEmpty()) {
            Node currRoot = st.pop();
            System.out.print(currRoot.data + " ");
            if (currRoot.right != null) {
                st.push(currRoot.right);
            }
            if (currRoot.left != null) {
                st.push(currRoot.left);
            }
        }
    }

    private static void recursiveIn(Node node) {
        if (node == null) {
            return;
        }
        recursiveIn(node.left);
        System.out.print(node.data + " ");
        recursiveIn(node.right);
    }

    private static void recursivePost(Node node) {
        if (node == null) {
            return;
        }
        recursivePost(node.left);
        recursivePost(node.right);
        System.out.print(node.data + " ");
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
        iterativePrePostInTraversal(root);
    }

}