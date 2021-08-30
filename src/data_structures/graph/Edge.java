package data_structures.graph;

public class Edge{
    public int src;
    public int neighbor;
    public int weight;
    public Edge(int src, int neighbor, int weight){
        this.src = src;
        this.neighbor = neighbor;
        this.weight = weight;
    }
}
