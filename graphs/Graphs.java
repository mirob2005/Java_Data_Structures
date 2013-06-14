package graphs;

public class Graphs {

    public static void main(String[] args) {
        AdjacencyList al = new AdjacencyList();
        al.addVertex(1);
        al.addVertex(2);
        al.addVertex(3);
        al.addVertex(4);
        al.addVertex(5);
        al.addEdge(1, 2);
        al.addEdge(1, 3);
        al.addEdge(2, 4);
        al.addEdge(3, 4);
        al.addEdge(4, 5);
        al.printVertexList();
    }
}
