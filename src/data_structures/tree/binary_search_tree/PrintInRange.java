package data_structures.tree.binary_search_tree;

public class PrintInRange {
    public static void printInRange(Node node, int d1, int d2){
        if(node == null){
            return;
        }
        if(node.data > d1 && node.data > d2){
            printInRange(node.left, d1, d2);
        }else if(node.data < d1 && node.data < d2){
            printInRange(node.right, d1, d2);
        } else{
            printInRange(node.left, d1, d2);
            System.out.println(node.data);
            printInRange(node.right, d1, d2);
        }
    }
}
