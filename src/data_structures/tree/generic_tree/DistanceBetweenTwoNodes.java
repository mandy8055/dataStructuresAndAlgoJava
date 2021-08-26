package data_structures.tree.generic_tree;

import java.util.ArrayList;
import java.util.Objects;

public class DistanceBetweenTwoNodes {
    public static int distanceBetweenNodes(Node node, int d1, int d2){
        ArrayList<Integer> p1 = NodeToRootPath.nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = NodeToRootPath.nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while(i >= 0 && j >= 0 && Objects.equals(p1.get(i), p2.get(j))){
            i--;
            j--;
        }
        return ((i + 1) + (j + 1));
    }
}
