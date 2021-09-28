package data_structures.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class IsGraphCyclic {
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean flag = false;
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                flag = bft(graph, i, vis);
                if (flag) {
                    break;
                }
            }
        }
        return flag;
    }
    private static boolean bft(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(src);
        while (!q.isEmpty()) {
            int rem = q.remove();
            if (!vis[rem]) {
                vis[rem] = true;
            } else {
                return true;
            }
            for (Edge e : graph[src]) {
                if (!vis[e.neighbor]) {
                    q.add(e.neighbor);
                }
            }
        }
        return false;
    }
}
