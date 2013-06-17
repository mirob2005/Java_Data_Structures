package graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    public class Edge{
        private Vertex dest;
        private int weight;
        public Edge(Vertex dest, int weight){
           this.dest = dest;
           this.weight = weight;
        }
        public Vertex getDest(){
            return this.dest;
        }
        public int getWeight(){
            return this.weight;
        }
        public void updateWeight(int weight){
            this.weight = weight;
        }
        @Override
        public String toString(){
            String returnStr = "->"+this.dest.getName();
            return returnStr;
        }
    }
    private String name;
    private List<Edge> next;
    //For exploration 0 - not visited, 1 - visted, not explored, 2 - explored
    private byte visit;
    private Vertex predecessor;
    private int distance;
    
    public Vertex(String name){
        this.name = name;
        this.next = new ArrayList<>();
        this.visit = 0;
        this.distance = Integer.MAX_VALUE;
        this.predecessor = null;
    }
    @Override
    public String toString(){
        String returnStr = "";
        returnStr += this.name + " -> ";
        if(!this.next.isEmpty()){
            for(Edge e: this.next){
                returnStr += e.getDest().getName() + "("+e.getWeight()+"), ";
            }
            returnStr = returnStr.substring(0, returnStr.length()-2);
        }
        else{
            returnStr += "None";
        }
        return returnStr;
    }
    public void print(){
        System.out.println("Vertex "+this.name+" Distance: "+this.distance);
    }
    public void addEdge(Vertex dest, int weight){
        this.next.add(new Edge(dest,weight));
    }
    public Edge findEdge(Vertex dest){
        for(Edge e:this.next){
            if(e.getDest()==dest){
                return e;
            }
        }
        return null;
    }
    public void updateEdge(Vertex y, int weight) {
        for(Edge e:this.next){
            if(e.getDest()==y){
                e.updateWeight(weight);
            }
        }
    }
    public void removeEdge(Vertex dest){
        Edge removeMe = null;
        for(Edge e:this.next){
            if(e.getDest()==dest){
                removeMe = e;
                break;
            }
        }
        this.next.remove(removeMe);
    }
    public void removeAllEdges() {
        this.next.clear();
    }
    public String getName(){
        return this.name;
    }
    public List<Edge> getEdges(){
        return this.next;
    }
    public void unexplore(){
        this.visit = 0;
    }
    public boolean visited(){
        return (this.visit==1 || this.visit ==2);
    }
    public boolean explored(){
        return this.visit==2;
    }
    public void visit(){
        this.visit = 1;
    }
    public void explore(){
        this.visit = 2;
    }
    public void clearDistance(){
        this.distance = Integer.MAX_VALUE;
    }
    public void setDistance(int dist){
        this.distance = dist;
    }
    public int getDistance(){
        return this.distance;
    }
    public void clearPredecessor(){
        this.predecessor = null;
    }
    public void setPredecessor(Vertex pre){
        this.predecessor = pre;
    }
    public Vertex getPredecessor(){
        return this.predecessor;
    }
}
