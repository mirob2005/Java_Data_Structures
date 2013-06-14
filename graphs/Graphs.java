package graphs;

public class Graphs {

    public static void main(String[] args) {
        AdjacencyList al = new AdjacencyList();
        al.addVertex(1);
        al.addVertex(2);
        al.addVertex(3);
        al.addVertex(4);
        al.addVertex(5);
        al.addEdge(1, 2, 5);
        al.addEdge(1, 3, 5);
        al.addEdge(2, 4, 3);
        al.addEdge(3, 4, 4);
        al.addEdge(4, 5, 5);
        al.printVertexList();
        al.addEdge(4, 5, 2);
        al.printVertexList();
        System.out.println("Removing vertex 1");
        al.removeVertex(1);
        al.printVertexList();
        System.out.println("Adding vertex 6 with an edge from 5 and edges to 2,3");
        al.addVertex(6);
        al.addEdge(5, 6, 1);
        al.addEdge(6, 2, 3);
        al.addEdge(6, 3, 2);
        al.printVertexList();
        System.out.println("Removing edge from 5 to 6");
        al.removeEdge(5, 6);
        al.printVertexList();
        System.out.println("Updating edge from 6 to 2");
        al.updateEdge(6, 2, 1);
        al.printVertexList();
        al.printBFS(6);
        al.computeShortestPath(6, 5);
        System.out.println("Removing edge from 2 to 4");
        al.removeEdge(2, 4);
        al.printVertexList();
        al.printBFS(6);
        al.computeShortestPath(6, 5);
        System.out.println("Removing edge from 3 to 4");
        al.removeEdge(3, 4);
        al.printVertexList();
        al.printBFS(6);
        al.computeShortestPath(6, 5);
    }
}
