package data_structures.tree.generic_tree;

import org.jetbrains.annotations.NotNull;

public class AreTreesSimilarInShape {
    public static boolean areSimilar(@NotNull Node n1, @NotNull Node n2){
        if(n1.children.size() != n2.children.size()){
            return false;
        }
        for(int i = 0; i < n1.children.size(); i++){
            Node t1 = n1.children.get(i);
            Node t2 = n2.children.get(i);
            if(!areSimilar(t1, t2)){
                return false;
            }
        }
        return true;
    }
}
