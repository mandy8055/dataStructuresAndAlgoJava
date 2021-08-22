package data_structures.tree.binary_tree;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
public class NodeToRootPath {
    @Contract("null, _ -> new")
    public static @NotNull ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node == null){
            return new ArrayList<>();
        }
        // Base Case
        if(node.data == data){
            ArrayList<Integer> bans = new ArrayList<>();
            bans.add(node.data);
            return bans;
        }
        // Main Case
        ArrayList<Integer> lAns = nodeToRootPath(node.left, data);
        if(!lAns.isEmpty()){
            lAns.add(node.data);
            return lAns;
        }
        ArrayList<Integer> rAns = nodeToRootPath(node.right, data);
        if(!rAns.isEmpty()){
            rAns.add(node.data);
            return rAns;
        }
        return new ArrayList<>();
    }
}
