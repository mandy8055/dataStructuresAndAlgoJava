package data_structures.tree.binary_tree;
public class RemoveLeaves {
    public static Node removeLeaves(Node node){
        // Base Case
        if(node == null){
            return null;
        }
        if(node.left == null && node.right == null){
            return null;
        }
        Node lst = removeLeaves(node.left);
        Node rst = removeLeaves(node.right);
        // Attach the returned nodes(null once leaves are removed) back to its parent.
        node.left = lst;
        node.right = rst;
        return node;
    }
}
