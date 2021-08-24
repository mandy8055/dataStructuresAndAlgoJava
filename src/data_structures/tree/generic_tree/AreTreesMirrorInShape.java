package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class AreTreesMirrorInShape {
    public static boolean areMirror(@NotNull Node n1, @NotNull Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++){
            int j = n1.children.size() - 1 - i;
            Node t1 = n1.children.get(i);
            Node t2 = n2.children.get(j);
            if(!areMirror(t1, t2)) {
                return false;
            }
        }
        return true;
    }
}
