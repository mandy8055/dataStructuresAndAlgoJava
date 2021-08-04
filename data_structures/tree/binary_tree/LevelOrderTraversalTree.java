package data_structures.tree.binary_tree;

import data_structures.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalTree {

    // Time complexity: O(n)
    // Space complexity: O(n) because of using queue

    public static <T extends Comparable<?>> void getLevelOrder(TreeNode<T> root){
        if(root == null)return;
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode<T> temp = queue.poll();
            System.out.print(temp.data + " ");

            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }
}
