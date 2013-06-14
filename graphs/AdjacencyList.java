package graphs;

import java.util.ArrayList;
import java.util.List;

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
    public void addEdge(K src, K dest){
        Vertex x = this.findVertex(src);
        Vertex y = this.findVertex(dest);
        if(x!= null && y!=null){
            if(x.findEdge(y)){
                System.out.println("Edge from "+src.toString()+" to "+dest.toString()+" already exists!");
            }
            else{
                x.addEdge(y);
            }
        }
    }
    public void removeVertex(Vertex V){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    public void removeEdge(Vertex src, Vertex dest){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    private Vertex findVertex(K name){
        for(Vertex v: this.vertexList){
            if(v.getName().equals(name.toString())){
                return v;
            }
        }
        return null;
    }
    public void traverseBFS(){
        throw new UnsupportedOperationException("Not Yet Implemented!");
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
}
