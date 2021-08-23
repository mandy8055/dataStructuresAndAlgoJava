package data_structures.tree.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TraversalsInBinaryTree {
    public static class Pair{
        Node node;
        int state;
        public Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void levelOrder(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        Node marker = new Node(Integer.MIN_VALUE, null, null);
        q.add(marker);
        while(!q.isEmpty()){
            Node temp = q.remove();
            if(temp == marker){
                System.out.println();
                if(q.isEmpty()){
                    return;
                }else{
                    q.add(temp);
                }
            }else{
                System.out.print(temp.data + " ");
                if(temp.left != null && temp.right != null){
                    q.add(temp.left);
                    q.add(temp.right);
                }else if(temp.left != null){
                    q.add(temp.left);
                }else if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
    }
    public static void iterativePrePostInTraversal(Node node) {
        StringBuilder pre = new StringBuilder();
        StringBuilder in = new StringBuilder();
        StringBuilder post = new StringBuilder();
        Stack<Pair> st = new Stack<>();
        Pair p = new Pair(node, 1);
        st.push(p);
        while(!st.isEmpty()){
            Pair temp = st.peek();
            if(temp.state == 1){ // pre, s++, push left
                pre.append(temp.node.data).append(" ");
                temp.state++;
                if(temp.node.left != null){
                    st.push(new Pair(temp.node.left, 1));
                }
            } else if(temp.state == 2){ // in, s++, push right
                in.append(temp.node.data).append(" ");
                temp.state++;
                if(temp.node.right != null){
                    st.push(new Pair(temp.node.right, 1));
                }
            } else{ // state == 3 ->  post, pop
                post.append(temp.node.data).append(" ");
                st.pop();
            }
        }
        System.out.println(pre + "\n" + in + "\n" + post);
    }
}
