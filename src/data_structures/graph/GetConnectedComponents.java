package data_structures.graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GetConnectedComponents {
    public static @NotNull ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge> @NotNull [] graph) {
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dft(graph, i, comp, vis);
                comps.add(comp);
            }
        }
        return comps;
    }
    // Call the below function with all unmarked visited vertex i.e. where visited arr element is false
    private static void dft(ArrayList<Edge> @NotNull [] graph, int src, @NotNull ArrayList<Integer> comp, boolean @NotNull [] visited) {
        visited[src] = true;
        comp.add(src);
        for (Edge edge : graph[src]) {
            if (!visited[edge.neighbor]) {
                dft(graph, edge.neighbor, comp, visited);
            }
        }
    }
}
