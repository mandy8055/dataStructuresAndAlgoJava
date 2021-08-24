package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class MirrorOfGenericTree {
    public static void mirror(@NotNull Node node){
        for(Node nd : node.children){
            // Faith
            mirror(nd);
        }
        Collections.reverse(node.children);
    }
}
