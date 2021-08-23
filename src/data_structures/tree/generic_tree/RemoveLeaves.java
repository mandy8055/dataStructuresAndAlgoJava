package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class RemoveLeaves {
    public static void removeLeaves(@NotNull Node node) {
        for(int i = node.children.size() - 1; i >= 0; i--){ // Caveat: ConcurrentUnModifiableException if replaced with foreach
            Node child = node.children.get(i);
            if(child.children.isEmpty()){ // if child is leaf node
                node.children.remove(child);
            }
        }
        for(Node nd : node.children){
            removeLeaves(nd);
        }
    }
}
