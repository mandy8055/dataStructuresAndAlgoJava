package data_structures.tree.binary_tree;

import org.jetbrains.annotations.NotNull;
import java.util.Stack;

public class ConstructAndDisplayBinaryTreeUsingArray {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node treeNode;
        int state;
        public Pair(Node treeNode, int state){
            this.treeNode = treeNode;
            this.state = state;
        }
    }
    public static @NotNull Node construct(Integer @NotNull [] arr){
        Node root = new Node(arr[0], null, null);
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));
        for(int i = 1; i < arr.length; i++) {
            if (arr[i] == null) {
                st.peek().state++;
                if (st.peek().state == 2) {
                    st.pop();
                }
            } else {
                Node newNode = new Node(arr[i], null, null);
                if (st.peek().state == 0) {
                    // Store the newNode as left child
                    st.peek().treeNode.left = newNode;
                } else if (st.peek().state == 1) {
                    // Store the newNode as right child
                    st.peek().treeNode.right = newNode;
                }
                st.peek().state++;
                if(st.peek().state == 2){
                    // State value = 2, means the node has max children i.e. 2; therefore the work of node is done.
                    st.pop();
                }
                st.push(new Pair(newNode, 0));
            }
        }
        return root;
    }
    public static void display(Node root){
        // Base Case
        if(root == null){
            return;
        }
        String sb = (root.left == null ? ". <-- " : root.left.data + " <-- ") +
                root.data +
                (root.right == null ? " --> ." : " --> " + root.right.data);
        System.out.println(sb);
        // faith
        display(root.left);
        display(root.right);
    }

    public static void main(String[] args){
        Integer[] arr = {10, 20, 40, null, 80, null, null,
                50, null, null, 30, null, 60, 70, null, null, null};
        Node root = construct(arr);
        display(root);
    }

}
