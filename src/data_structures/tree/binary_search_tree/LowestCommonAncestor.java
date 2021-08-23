package data_structures.tree.binary_search_tree;

import java.util.ArrayList;
import java.util.Objects;

public class LowestCommonAncestor {
    public static int lca(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = NodeToRootPath.nodeToRootPath(node, d1);
        ArrayList<Integer> path2 = NodeToRootPath.nodeToRootPath(node, d2);
        int i = path1.size() - 1;
        int j = path2.size() - 1;
        while(i >= 0 && j >= 0 && Objects.equals(path1.get(i), path2.get(j))){
            i--;
            j--;
        }
        return path1.get(i + 1);
    }
}
