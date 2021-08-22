package data_structures.tree.generic_tree;

public class SizeOfGenericTree {
    public static int size(Node node) {
        // Base Case
        if(node == null){
            return 0;
        }

        // Main Case
        int sz = 1;
        for(Node nd : node.children){
            sz += size(nd);
        }
        return sz;

    }
}
