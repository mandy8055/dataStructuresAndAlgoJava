package data_structures.tree.generic_tree;

public class FindInGenericTree {
    public static boolean find(Node node, int data) {
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        for(Node nd : node.children){
            boolean fnd = find(nd, data);
            if(fnd){
                return true;
            }
        }
        return false;
    }
}
