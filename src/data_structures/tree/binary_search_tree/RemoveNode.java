package data_structures.tree.binary_search_tree;

public class RemoveNode {
    public static Node remove(Node node, int data) {
        // Base Case
        if(node == null){
            return null;
        }
        if(data < node.data){
            node.left = remove(node.left, data);
        }else if(data > node.data){
            node.right = remove(node.right, data);
        }else{
            // Main Case
            if(node.left == null && node.right == null){ // Leaf
                return null;
            }else if(node.left == null){ // Single child
                return node.right;
            }else if(node.right == null){ // Single child
                return node.left;
            }else{ // Node is with two child
                Node predecessor = getMaxNodeAsPredecessor(node.left);
                node.data = predecessor.data;
                remove(node.left, predecessor.data);
            }
        }
        return node;
    }

    private static Node getMaxNodeAsPredecessor(Node node){
        // Base Case
        if(node == null) {
            return null;
        }
        Node lMax = getMaxNodeAsPredecessor(node.left);
        Node rMax = getMaxNodeAsPredecessor(node.right);
        if(lMax == null && rMax == null){
            return node;
        }else if(lMax == null){
            int max = Math.max(node.data, rMax.data);
            return max == node.data ? node : rMax;
        }else if(rMax == null){
            int max = Math.max(node.data, lMax.data);
            return max == node.data ? node : lMax;
        }else{
            int max = Math.max(node.data, Math.max(lMax.data, rMax.data));
            return max == node.data ? node : max == lMax.data ? lMax : rMax;
        }
    }
}
