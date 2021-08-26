package data_structures.tree.generic_tree;

public class KthLargestElement {
    public static int kthLargest(Node node, int k){
        CeilAndFloorOfGenericTree.floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++){
            CeilAndFloorOfGenericTree.ceilAndFloor(node, factor);
            factor = CeilAndFloorOfGenericTree.floor; // Set the value of factor to current floor.
            CeilAndFloorOfGenericTree.floor = Integer.MIN_VALUE; // Reset the value of static variable. Check in CeilAndFloorOfGenericTree.java
        }
        return factor;
    }
}
