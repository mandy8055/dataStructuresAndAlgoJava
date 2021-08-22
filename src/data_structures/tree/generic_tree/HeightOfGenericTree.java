package data_structures.tree.generic_tree;

public class HeightOfGenericTree {
    public static int height(Node node) {
        // Base Case
        if(node == null){
            return 0;
        }
        // Main Case
        int ht = -1;
        for(Node nd : node.children){
            ht = Math.max(ht, height(nd));
        }
        return ht + 1;
    }
}
