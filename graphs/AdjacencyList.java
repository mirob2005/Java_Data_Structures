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
    private void missingVertex(K vertex){
        System.out.println("Vertex "+vertex.toString()+" does NOT exist!");
    }
    private void missingEdge(K src, K dest){
        System.out.println("Edge "+src.toString()+"->"+dest.toString()+" does NOT exist!");
    }
}
