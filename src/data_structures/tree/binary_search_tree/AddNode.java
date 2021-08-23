package data_structures.tree.binary_search_tree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class AddNode {
    @Contract("null, _ -> new")
    public static @NotNull Node add(Node node, int data) {
        // Base Case
        if(node == null) {
            return new Node(data, null, null);
        }
        if(data > node.data){
            node.right = add(node.right, data);
        }else if(data < node.data){
            node.left = add(node.left, data);
        }
        return node;
    }
}
