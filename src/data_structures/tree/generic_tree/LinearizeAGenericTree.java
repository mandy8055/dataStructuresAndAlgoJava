package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class LinearizeAGenericTree {
    public static void linearize(@NotNull Node node){
        for(Node nd : node.children){
            linearize(nd);
        }
        while(node.children.size() > 1){
            Node lc = node.children.remove(node.children.size() - 1);
            Node sc = node.children.get(node.children.size() - 1);
            Node tsc = getTail(sc);
            tsc.children.add(lc);
        }
    }
    private static Node getTail(@NotNull Node node){
        while(node.children.size() == 1){
            node = node.children.get(0);
        }
        return node;
    }
}
