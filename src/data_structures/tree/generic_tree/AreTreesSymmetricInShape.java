package data_structures.tree.generic_tree;

public class AreTreesSymmetricInShape {
    public static boolean areTreesSymmetricInShape(Node node){
        return AreTreesMirrorInShape.areMirror(node, node); // Every symmetric things are mirror image of themselves.
    }
}
