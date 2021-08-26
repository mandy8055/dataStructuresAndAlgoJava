package data_structures.graph;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.ArrayList;
public class AdjacencyListRepresentation {
    public static void display(ArrayList<Edge> @NotNull [] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].size() > 0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < graph[i].size(); j++) {
                    System.out.print(graph[i].get(j).neighbor + "(wt: " + graph[i].get(j).weight + ")");
                    if(j != graph[i].size() - 1){
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
//        int numOfVertices = sc.nextInt();
        int numOfVertices = 7;
        ArrayList<Edge>[] graph = new ArrayList[numOfVertices];
        // Initializing every graph element(i.e. element is an ArrayList)
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // Working with edges
//        int edges = sc.nextInt();
        /*for(int i = 0; i < edges; i++){
            int src = sc.nextInt();
            int neighbour = sc.nextInt();
            int weight = sc.nextInt();
            graph[src].add(new Edge(src, neighbour, weight));
            // Since the graph is undirected graph so path is available from both source to neighbour and vice-versa.
            graph[neighbour].add(new Edge(neighbour, src, weight));
        }*/
        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 40));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 40));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5,6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        display(graph);
//        sc.close();
    }
}