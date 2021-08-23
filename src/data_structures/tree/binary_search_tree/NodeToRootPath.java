package data_structures.tree.binary_search_tree;

import java.util.ArrayList;

public class NodeToRootPath {
    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        // Null Case
        if(node == null){
            return null;
        }
        // Base case
        if(data == node.data){
            ArrayList<Integer> bans = new ArrayList<>();
            bans.add(node.data);
            return bans;
        }else if(data < node.data){
            ArrayList<Integer> lst = nodeToRootPath(node.left, data);
            if(!lst.isEmpty()){
                lst.add(node.data);
            }
            return lst;
        } else{ // data > node.data
            ArrayList<Integer> rst = nodeToRootPath(node.right, data);
            if(!rst.isEmpty()){
                rst.add(node.data);
            }
            return rst;
        }
    }
}
