package data_structures.tree.binary_search_tree;

public class ReplaceWithSumOfLarger {
    static int sum = 0;
    // Also known as reverse morris traversal
    public static void rwsol(Node node){
        if(node == null){
            return;
        }
        // Right traversal
        rwsol(node.right);
        // Work
        int temp = node.data;
        node.data = sum;
        sum += temp;
        // left traverse
        rwsol(node.left);
    }
}
