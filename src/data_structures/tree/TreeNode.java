package data_structures.tree;

public class TreeNode<T extends Comparable<?>> {
    public TreeNode<T> left, right;
    public T data;

    public TreeNode(T data) {
        this.data = data;
    }
}
