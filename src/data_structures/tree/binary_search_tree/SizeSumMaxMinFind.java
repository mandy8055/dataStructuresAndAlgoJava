package data_structures.tree.binary_search_tree;

public class SizeSumMaxMinFind {
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
        int mx = node.data;
        return Math.max(mx, Math.max(max(node.left), max(node.right)));
    }

    public static int min(Node node) {
        // Base Case
        if(node == null){
            return Integer.MAX_VALUE;
        }
        int mn = node.data;
        return Math.min(mn, Math.min(min(node.left), min(node.right)));
    }

    public static boolean find(Node node, int data){
        // Base Case
        if(node == null){
            return false;
        }
        if(data == node.data){
            return true;
        }else if(data > node.data){
            return find(node.right, data);
        }else {
            return find(node.left, data);
        }
    }
}
