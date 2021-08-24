package data_structures.tree.binary_search_tree;

public class TargetSumPair {
    public static void targetSumPair(Node root, Node node, int target){
        // Base Case
        if(node == null){
            return;
        }
        targetSumPair(root, node.left, target);
        int complement = target - node.data;
        if(node.data < complement){
            if(SizeSumMaxMinFind.find(root, complement)){
                System.out.println(node.data + " " + complement);
            }
        }
        targetSumPair(root, node.right, target);
    }
}
