package data_structures.tree.binary_tree;

import data_structures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseOfLevelOrderTraversalTree {
    public static <T extends Comparable<?>> void printReverseOfLevelOrder(TreeNode<T> root){
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            stack.push(temp);

            if(temp.right != null)
                queue.add(temp.right);
            if(temp.left != null)
                queue.add(temp.left);
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }
    }
}
