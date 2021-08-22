package data_structures.tree.generic_tree;

public class MaxValInGenericTree {
    public static int max(Node node) {
        // Base Case
        if(node == null){
            return Integer.MIN_VALUE;
        }
        // Main Case
        int currMax = node.data;
        for(Node nd : node.children){
            currMax = Math.max(currMax, max(nd));
        }
        return currMax;
    }
}
