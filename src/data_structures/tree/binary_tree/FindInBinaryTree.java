package data_structures.tree.binary_tree;

public class FindInBinaryTree {
    public static boolean find(Node node, int data){
        // Null case
        if(node == null){
            return false;
        }
        // Base Case
        if(node.data == data){
            return true;
        }
        // Main Case
        boolean lAns = find(node.left, data);
        if(lAns)return true;
        return find(node.right, data);
    }
}
