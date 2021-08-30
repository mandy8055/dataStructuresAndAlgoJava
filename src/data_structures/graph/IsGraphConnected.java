package data_structures.graph;

import java.util.ArrayList;

public class IsGraphConnected {
    public static boolean isConnected(ArrayList<Edge>[] graph){
        return GetConnectedComponents.gcc(graph).size() == 1;
    }
}
