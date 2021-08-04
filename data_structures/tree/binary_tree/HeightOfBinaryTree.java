package data_structures.tree.binary_tree;

import data_structures.tree.TreeNode;

public class HeightOfBinaryTree {
    public static<T extends Comparable<?>> int computeMaxHeight(TreeNode<T> node){
        if(node == null)return 0;
        int leftSubtreeDepth = computeMaxHeight(node.left);
        int rightSubtreeDepth = computeMaxHeight(node.right);

        if(leftSubtreeDepth < rightSubtreeDepth)
            return (rightSubtreeDepth + 1);
        else
            return (leftSubtreeDepth + 1);
    }
}
