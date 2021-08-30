package data_structures.graph;

/* Documentation of the approach
 *** HIGH-level approach:
 * 1. We will use recursion to achieve our result.
 * 2. When at source vertex, we will keep faith that the neighbouring vertices of source already know at most 1 path to destination. Also, if they know the path to destination, they'll surely print it
 * 3. If there exist at least 1 neighbour which has the path to destination then you have the node from source to neighbour and in turn to destination. So add the source vertex to the answer and print the answer.
 **** LOW-level approach:
 * 1. BASE CASE: if source == destination; you are already at destination so print the answer so far and return.
 * 2. Recursively call printAllPath() to all your neighbours, so that they can find and print the path(if any) to destination.
 * 3. if at least one neighbour has path => there is a path between source to destination. Store all such paths in the asf variable.
 * 4. CAVEAT 1: When we are recursively calling hasPath(), do not recurse through the same neighbour again and again which might result in STACK OVERFLOW ERROR. To avoid it keep a visited array to mark the vertices which are already visited and do not visit them again. TRY TO UNDERSTAND COUNT-TO-INFINITY problem in routers.
 * 5. CAVEAT 2: After completing the recursive calls to a particular vertex, mark that vertex as UNVISITED again, so that we can get the answer from that vertex directly. If not done we will miss some paths which also leads us to the destination from source.
 * */

import java.util.ArrayList;
public class PrintAllPaths {
    /* @params asf : String type answer so far which contains src vertex already appended to it.
    *  @params visited: boolean array to keep track of the vertices that are already visited.
    * */
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String asf){ // answer so far.
        // Base Case
        if(src == dest){
            System.out.println(asf);
            return;
        }
        // Main Case
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){
                printAllPaths(graph, edge.neighbor, dest, visited, asf + edge.neighbor);
            }
        }
        // Refer point CAVEAT 2 in documentation
        visited[src] = false;
    }
}
