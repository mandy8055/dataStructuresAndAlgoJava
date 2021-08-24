package data_structures.tree.generic_tree;

public class PredecessorAndSuccessor {
    static Node predecessor;
    static Node successor;
    static int state;
    public static void predecessorAndSuccessor(Node node, int data){
        if(state == 0){
            if(node.data == data){
                state = 1;
            }else{
               predecessor = node;
            }
        } else if(state == 1){
            successor = node;
            state = 2;
        }
        for(Node nd : node.children) {
            predecessorAndSuccessor(nd, data);
        }
    }
}
