package graphs;

import java.util.List;

public class Vertex {
    private String name;
    private List next;
    
    
    public Vertex(){
        throw new UnsupportedOperationException("Not Yet Implemented!");
    }
    @Override
    public String toString(){
        return this.name;
    }
}
