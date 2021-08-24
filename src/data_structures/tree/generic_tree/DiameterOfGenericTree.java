package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class DiameterOfGenericTree {
    public static int dia; // Gets the diameter
    public static int calculateDiameter(@NotNull Node node){
        int maxHt = -1;
        int secondMaxHt = -1;
        for(Node nd : node.children){
            int currHeight = calculateDiameter(nd);
            if(currHeight > maxHt){
                secondMaxHt = maxHt;
                maxHt = currHeight;
            }else if(currHeight > secondMaxHt){
                secondMaxHt = currHeight;
            }
        }
        dia = Math.max(dia, maxHt + secondMaxHt + 2);
        return maxHt + 1; // Total height will be including the current node also.
    }
}
