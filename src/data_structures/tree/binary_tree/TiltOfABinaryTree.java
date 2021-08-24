package data_structures.tree.binary_tree;

public class TiltOfABinaryTree {
    static int tilt = 0;
    public static int tilt(Node node){
        if(node == null){
            return 0;
        }
        int lst = tilt(node.left);
        int rst = tilt(node.right);
        tilt += Math.abs(lst - rst);
        return (lst + rst + node.data);
    }
}
