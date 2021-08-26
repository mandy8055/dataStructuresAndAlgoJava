package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class CeilAndFloorOfGenericTree {
    static int ceil;
    static int floor;
    public static void ceilAndFloor(@NotNull Node node, int data) {
        if(node.data > data){
            ceil = Math.min(ceil, node.data);
        }else if(node.data < data){
            floor = Math.max(floor, node.data);
        }
        for(Node nd : node.children){
            ceilAndFloor(nd, data);
        }
    }
}
