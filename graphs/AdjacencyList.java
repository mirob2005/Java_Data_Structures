package graphs;

import graphs.Vertex.Edge;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyList<K>{
    private List<Vertex> vertexList;
    public AdjacencyList(){
        this.vertexList = new ArrayList<>();
    }
    public void addVertex(K name){
        if(this.findVertex(name) != null){
            System.out.println("Vertex "+name.toString()+" already exists!");
        }
        else{
            this.vertexList.add(new Vertex(name.toString()));
        }
    }
    public void addEdge(K src, K dest, int weight){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null && y!=null){
            if(x.findEdge(y)!=null){
                System.out.println("Edge from "+src.toString()+" to "+dest.toString()+" already exists!");
                System.out.println("Updating weight");
                x.updateEdge(y,weight);
            }
            else{
                x.addEdge(y,weight);
            }
        }
    }
    public void removeVertex(K vertex){
        Vertex x = this.findVertex(vertex);
        if(x==null){
            this.missingVertex(vertex);
        }
        else{
            x.removeAllEdges();
            for(Vertex v:this.vertexList){
                if(v.findEdge(x)!=null){
                    v.removeEdge(x);
                }
            }
            this.vertexList.remove(x);
        }
    }
    public void removeEdge(K src, K dest){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null){
            if(y!=null){
                if(x.findEdge(y)!=null){
                    x.removeEdge(y);
                }
                else{
                    this.missingEdge(src, dest);
                }
            }
            else{
                this.missingVertex(dest);
            }
        }
        else{
            this.missingVertex(src);
        }
    }
    public void updateEdge(K src, K dest, int weight){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null){
            if(y!=null){
                if(x.findEdge(y)!=null){
                    x.updateEdge(y, weight);
                }
                else{
                    this.missingEdge(src, dest);
                }
            }
            else{
                this.missingVertex(dest);
            }
        }
        else{
            this.missingVertex(src);
        }
    }
    private Vertex findVertex(K name){
        for(Vertex v: this.vertexList){
            if(v.getName().equals(name.toString())){
                return v;
            }
        }
        return null;
    }
    public void printBFS(K source){
        Vertex src = this.findVertex(source);
        if(src==null){
            this.missingVertex(source);
            return;
        }
        System.out.println("Traversing graph BFS starting from "+src.getName());
        System.out.print(this.traverseBFS(src));
    }
    private String traverseBFS(Vertex src){
        String BFS = "";
        Queue<Vertex> q = new LinkedList<>();
        for(Vertex v:this.vertexList){
            v.unexplore();
            v.clearDistance();
            v.clearPredecessor();
        }
        src.visit();
        src.setDistance(0);
        q.add(src);
        Vertex current = q.poll();
        Vertex last = current;
        while(current!=null){
            BFS+=current.getName()+"(dist: "+current.getDistance()+")\n";
            for(Edge e: current.getEdges()){
                Vertex v = e.getDest();
                if(!v.visited() || v.getDistance()>current.getDistance()+e.getWeight()){
                    q.add(v);
                    v.visit();
                    v.setPredecessor(current);
                    v.setDistance(current.getDistance()+e.getWeight());
                }
            }
            current.explore();
            current = q.poll();
            if(current!=null){
                last = current;
            }
        }
        return BFS;
    }
    public void traverseDFS(){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    public AdjacencyList copyGraph(){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    public void deleteGraph(){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    public void printVertexList(){
        for(Vertex v:this.vertexList){
            System.out.println(v);
        }
    }
    public void computeShortestPath(K source, K destination){
        System.out.print("Shortest Path from "+source.toString()+" to "+destination.toString()+" is: ");
        Vertex src = this.findVertex(source);
        Vertex dest = this.findVertex(destination);
        if(src==null){
            this.missingVertex(source);
            return;
        }
        if(dest==null){
            this.missingVertex(destination);
            return;
        }
        this.traverseBFS(src);
        this.printShortestPath(src,dest);
        System.out.println();
    }

    private void printShortestPath(Vertex src, Vertex dest) {
        System.out.print(dest.getName()+"<-");
        if(dest.getPredecessor()==null){
            System.out.println("No path from "+src.getName()+" to "+dest.getName()+" exists!");
            return;
        }
        else if(dest.getPredecessor()==src){
            System.out.print(src.getName());
        }
        else{
            this.printShortestPath(src, dest.getPredecessor());
        }
    }
    private void missingVertex(K vertex){
        System.out.println("Vertex "+vertex.toString()+" does NOT exist!");
    }
    private void missingEdge(K src, K dest){
        System.out.println("Edge "+src.toString()+"->"+dest.toString()+" does NOT exist!");
    }
}
