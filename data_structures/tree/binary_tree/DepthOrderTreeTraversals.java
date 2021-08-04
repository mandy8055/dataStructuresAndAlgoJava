package data_structures.tree.binary_tree;

import data_structures.tree.TreeNode;

import java.util.Stack;

public class DepthOrderTreeTraversals {

    // time complexity O(n) every case
    // Space complexity O(n) in worst case i.e. for skewed trees.

    public static <T extends Comparable<?>> void preorderRecursive(TreeNode<T> root){
        if(root == null)return;
        // Root --> left --> Right
        System.out.print(root.data + " ");
        preorderRecursive(root.left);
        preorderRecursive(root.right);
    }

    public static <T extends Comparable<?>> void inorderRecursive(TreeNode<T> root){
        if(root == null)return;
        // left --> Root --> Right
        inorderRecursive(root.left);
        System.out.print(root.data + " ");
        inorderRecursive(root.right);
    }

    public static <T extends Comparable<?>> void postorderRecursive(TreeNode<T> root){
        if(root == null)return;
        // left --> Right --> Root
        postorderRecursive(root.left);
        postorderRecursive(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative preorder
    public static <T extends Comparable<?>> void preorderIterative(TreeNode<T> root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode<T> temp = stack.pop();
            System.out.print(temp.data + " ");

            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }

    // Iterative inorder
    public static <T extends Comparable<?>> void inorderIterative(TreeNode<T> root){
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return;
        TreeNode current = root;
        while(!stack.isEmpty() || current != null){

            if(current != null){
                stack.push(current);
                current = current.left;
            }else{
                current = stack.pop();
                System.out.print(current.data + " ");
                current = current.right;
            }
        }
    }

    // Iterative postorder
    public static <T extends Comparable<?>> void postorderIterative(TreeNode<T> root){
        if(root == null)return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> outStack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            outStack.push(temp);
            if(temp.left != null)
                stack.push(temp.left);
            if(temp.right != null)
                stack.push(temp.right);
        }
        while(!outStack.isEmpty()){
            System.out.print(outStack.pop().data + " ");
        }
    }


}
