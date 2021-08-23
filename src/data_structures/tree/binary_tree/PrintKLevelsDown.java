package data_structures.tree.binary_tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintKLevelsDown {
    public static void printKLevelsDown(Node node, int k){
        Queue<Node> q = new ArrayDeque<>();
        Node marker = new Node(Integer.MIN_VALUE, null, null);
        int counter = 0;
        q.add(node);
        q.add(marker);
        while(counter != k){
            Node temp = q.remove();
            if(temp == marker){
                q.add(temp);
                counter++;
            }else{ // temp is some node
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        while(q.peek() != marker){
            System.out.println(q.remove().data);
        }
    }
}
