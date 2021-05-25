package data_structures.tree.binary_tree;

import data_structures.tree.TreeNode;

public class DiameterOfBinaryTree {
    static class DiameterHeightPair{
        public int ht;
        public int dia;
    }
    public static <T extends Comparable<?>> int getDiameter(TreeNode<T> node){
        return getDiameter1(node).dia;
    }
    private static <T extends Comparable<?>> DiameterHeightPair getDiameter1(TreeNode<T> node){
        DiameterHeightPair dp = new DiameterHeightPair();
        if(node == null){
            dp.ht = -1;
            dp.dia = 0;
            return dp;
        }
        DiameterHeightPair ld = getDiameter1(node.left);
        DiameterHeightPair rd = getDiameter1(node.right);
        dp.ht = Math.max(ld.ht, rd.ht) + 1;
        int factor = ld.ht + rd.ht + 2;
        dp.dia = Math.max(factor, Math.max(ld.dia, rd.dia));
        return dp;

    }

}
