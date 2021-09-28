package data_structures.graph;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphBipartite {
    static class Pair{
        int vtx;
        String psf;
        int lvl;
        public Pair(int vtx, String psf, int lvl){
            this.vtx = vtx;
            this.psf = psf;
            this.lvl = lvl;
        }
    }
    // 2-color property(DFT/BFT)
    public static boolean isGraphBipartite1(ArrayList<Edge> @NotNull [] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < vis.length; i++){
            if(!vis[i]){
                boolean valid = modifiedDft(graph, i, vis, new int[graph.length], 0);
                if(!valid){
                    return false;
                }
            }
        }
        return true;
    }
    // Odd cycle property(DFT/BFT)
    public static boolean isGraphBipartite2(ArrayList<Edge> @NotNull [] graph){
         int[] vis = new int[graph.length];
         Arrays.fill(vis, -1);
        for(int i = 0; i < vis.length; i++){
            if(vis[i] == -1){
                 boolean valid = modifiedBft(graph, i, vis);
                if(!valid){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean modifiedBft(ArrayList<Edge>[] graph, int src, int[] vis){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + "", 0));
        while(!q.isEmpty()){
            Pair rem = q.remove();
            if(vis[rem.vtx] == -1){
                vis[rem.vtx] = rem.lvl;
            }else{
                // Work to do here
                if(vis[rem.vtx] != rem.lvl){
                    // Odd cycle
                    return false;
                }
            }
            for(Edge e : graph[rem.vtx]){
                if(vis[e.neighbor] == -1){
                    q.add(new Pair(e.neighbor, rem.psf + e.neighbor, rem.lvl + 1));
                }
            }
        }
        return true;
    }
    private static boolean modifiedDft(ArrayList<Edge> @NotNull [] graph, int src, boolean @NotNull [] vis, int @NotNull [] colors, int col){
        vis[src] = true;
        colors[src] = col;
        for(Edge e : graph[src]){
            if(!vis[e.neighbor]){
                if(!modifiedDft(graph, e.neighbor, vis, colors, col ^ 1)){
                    return false;
                }
            }else if(colors[e.neighbor] == colors[src]){
                // Two adjacent nodes are marked with the same color
                return false;
            }
        }
        return true;
    }
}
