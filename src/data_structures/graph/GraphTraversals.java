package data_structures.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class GraphTraversals {
    static class Pair{
        int v;
        String psf;
        public Pair(int v, String psf){
            this.v = v;
            this.psf = psf;
        }
    }
    // Breadth First Traversal
    public static void bft(ArrayList<Edge>[] graph, int src, boolean[] visited){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, src + ""));
        while(!q.isEmpty()){
            // r, m*, w, a*
            Pair rem = q.remove();
            if(!visited[rem.v]){
                visited[rem.v] = true;
            }else{
                continue;
            }
            System.out.println(rem.v + "@" + rem.psf);
            for(Edge e : graph[rem.v]){
                if(!visited[e.neighbor]){
                    q.add(new Pair(e.neighbor, rem.psf + e.neighbor));
                }
            }
        }
    }
}
