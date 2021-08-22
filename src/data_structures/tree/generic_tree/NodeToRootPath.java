package data_structures.tree.generic_tree;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class NodeToRootPath {
    public static @NotNull ArrayList<Integer> nodeToRootPath(@NotNull Node node, int data){
        // Base Case
        if(node.data == data){
            ArrayList<Integer> bans = new ArrayList<>();
            bans.add(node.data);
            return bans;
        }
        // Main Case
        for(Node nd : node.children){
            ArrayList<Integer> al = nodeToRootPath(nd, data);
            if(!al.isEmpty()){
                al.add(node.data);
                return al;
            }
        }
        return new ArrayList<>();
    }
}
