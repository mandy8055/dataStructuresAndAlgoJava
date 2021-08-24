package data_structures.tree.binary_tree;

import org.jetbrains.annotations.NotNull;

public class DiameterOfBinaryTree {
    public static class DiaPair{
        int height;
        int diameter;
    }
    // Time Complexity : O(n^2)
    public static int diameter1(Node node){
        // Base Case
        if(node == null){
            return 0;
        }
        int ld = diameter1(node.left);
        int rd = diameter1(node.right);
        // if root is the point to get the diameter
        int fac = SizeSumMaxAndHeight.height(node.left) + SizeSumMaxAndHeight.height(node.right) + 2;
        return Math.max(fac, Math.max(ld, rd));
    }
    // Time Complexity : O(n)
    public static @NotNull DiaPair diameter2(Node node){
        // Base Case
        if(node == null){
            DiaPair bans = new DiaPair();
            bans.height = -1;
            return bans;
        }
        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);
        DiaPair mp = new DiaPair();
        mp.height = Math.max(lp.height, rp.height) + 1; // Updating the height to be used by the parent.
        int fac = lp.height + rp.height + 2;
        mp.diameter = Math.max(fac, Math.max(lp.diameter, rp.diameter));
        return mp;
    }
}
