package data_structures.graph;

import java.util.ArrayList;
import java.util.Set;

public class PrintHamiltonian {
    private static void hamiltonian(ArrayList<Edge>[] graph, int src, Set<Integer> visited,
                                    String psf, int originalSrc){
        // Base Case
        if(visited.size() == graph.length - 1){ // There exist a hamiltonian path
            boolean isHamiltonianCycle = false;
            for(Edge e : graph[src]){
                if(e.neighbor == originalSrc){ // Cycle exists
                    isHamiltonianCycle = true;
                    break;
                }
            }
            System.out.println(psf + (isHamiltonianCycle ? "*" : "."));
            return;
        }
        // Main Case
        visited.add(src);
        for(Edge e : graph[src]){
            if(!visited.contains(e.neighbor)){
                hamiltonian(graph, e.neighbor, visited, psf + e.neighbor, originalSrc);
            }
        }
        visited.remove(src);
    }
}
