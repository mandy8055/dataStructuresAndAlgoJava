package data_structures.tree.binary_tree;

public class SizeSumMaxAndHeight {
    public static int size(Node node) {
        // Base Case
        if(node == null){
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public static int sum(Node node) {
        // Base Case
        if(node == null){
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    public static int max(Node node) {
        // Base Case
        if(node == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(node.data,
                Math.max(max(node.left),
                        max(node.right)));
    }

    public static int height(Node node) {
        // Base Case
        if(node == null){
            return -1;
        }
        int ht = -1;
        ht = Math.max(ht, Math.max(height(node.left), height(node.right)));
        return ht + 1;
    }
}
