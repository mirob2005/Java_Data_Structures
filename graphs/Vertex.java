package graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    class Visit{
        //For exploration 0 - not visited, 1 - visted, not explored, 2 - explored
        private byte visit;
        public Visit(){
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
    }
    private String name;
    private List<Vertex> next;
    private Visit node;
    private Vertex predecessor;
    private int distance;
    
    public Vertex(String name){
        this.name = name;
        this.next = new ArrayList<>();
        this.node = new Visit();
        this.distance = Integer.MAX_VALUE;
        this.predecessor = null;
    }
    @Override
    public String toString(){
        String returnStr = "";
        returnStr += this.name + " -> ";
        if(!this.next.isEmpty()){
            for(Vertex v: this.next){
                returnStr += v.getName() + ", ";
            }
            returnStr = returnStr.substring(0, returnStr.length()-2);
        }
        else{
            returnStr += "None";
        }
        return returnStr;
    }
    public void addEdge(Vertex dest){
        this.next.add(dest);
    }
    public boolean findEdge(Vertex dest){
        return this.next.contains(dest);
    }
    public String getName(){
        return this.name;
    }
}
