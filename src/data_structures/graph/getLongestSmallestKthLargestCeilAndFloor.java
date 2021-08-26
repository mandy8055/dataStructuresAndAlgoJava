package data_structures.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class getLongestSmallestKthLargestCeilAndFloor {
    static String smallestPath;
    static Integer smallestPathWt = Integer.MAX_VALUE;
    static String largestPath;
    static Integer largestPathWt = Integer.MIN_VALUE;
    static String ceilPath;
    static Integer ceilPathWt = Integer.MAX_VALUE;
    static String floorPath;
    static Integer floorPathWt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        // Base Case
        if(src == dest){
            if(wsf < smallestPathWt){
                smallestPathWt = wsf;
                smallestPath = psf;
            }
            if(wsf > largestPathWt){
                largestPathWt = wsf;
                largestPath = psf;
            }
            if(wsf > criteria && wsf < ceilPathWt){
                ceilPath = psf;
                ceilPathWt = wsf;
            }
            if(wsf < criteria && wsf > floorPathWt){
                floorPath = psf;
                floorPathWt = wsf;
            }
            if(pq.size() < k){
                pq.offer(new Pair(wsf, psf));
            }else{
                assert pq.peek() != null;
                if(wsf > pq.peek().wsf){
                    pq.poll();
                    pq.offer(new Pair(wsf, psf));
                }
            }
        }
        // Main Case
        visited[src] = true;
        for(Edge edge : graph[src]){
            if(!visited[edge.neighbor]){
                multiSolver(graph, edge.neighbor, dest, visited, criteria, k, psf + edge.neighbor, wsf + edge.weight);
            }
        }
        visited[src] = false;
    }
}
