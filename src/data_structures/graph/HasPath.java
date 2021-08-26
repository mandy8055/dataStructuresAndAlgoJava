package data_structures.graph;

/* Documentation of the approach
*** HIGH-level approach:
* 1. We will use recursion to achieve our result.
* 2. When at source vertex, we will keep faith that the neighbouring vertices of source already know at most 1 path to destination.
* 3. If there exist at least 1 neighbour which has the path to destination then you have the node from source to neighbour and in turn to destination.
**** LOW-level approach:
* 1. BASE CASE: if source == destination; you are already at destination so return true.
* 2. Recursively call hasPath() to all your neighbours, so that they can find a path to destination.
* 3. if at least one neighbour has path => there is a path between source to destination.
* 4. CAVEAT: When we are recursively calling hasPath(), do not recurse through the same neighbour again and again which might result in STACK OVERFLOW ERROR. To avoid it keep a visited array to mark the vertices which are already visited and do not visit them again. TRY TO UNDERSTAND COUNT-TO-INFINITY problem in routers.
* */

import java.util.ArrayList;

public class HasPath {
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited){
        // Base Case
        if(src == dest){
            return true;
        }
        // Main Case
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){ // true -> vertex is already visited, false -> vertex is not visited yet
                boolean ifNeighbourHasPath = hasPath(graph, edge.neighbor, dest, visited);
                if(ifNeighbourHasPath){
                    return true;
                }
            }
        }
        return false;
    }
}
