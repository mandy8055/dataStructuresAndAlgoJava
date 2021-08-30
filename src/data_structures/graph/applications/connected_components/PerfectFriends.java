package data_structures.graph.applications.connected_components;

import data_structures.graph.Edge;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PerfectFriends {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int e = 0; e < k; e++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2, 1));
            graph[v2].add(new Edge(v2, v1, 1));
        }
        System.out.println(perfectFriends(graph));
    }

    private static int perfectFriends(ArrayList<Edge>[] graph) {
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dft(graph, i, comp, vis);
                comps.add(comp);
            }
        }
        int pairs = 0;
        for (int i = 0; i < comps.size(); i++) {
            for (int j = i + 1; j < comps.size(); j++) {
                pairs += comps.get(i).size() * comps.get(j).size();
            }
        }
        return pairs;
    }

    private static void dft(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] vis) {
        vis[src] = true;
        comp.add(src);
        for (Edge e : graph[src]) {
            if (!vis[e.neighbor]) {
                dft(graph, e.neighbor, comp, vis);
            }
        }
    }
}
