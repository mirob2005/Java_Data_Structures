package trees;

public class Node{
    private Comparable data;
    private Node left;
    private Node right;
    private Node parent;
    public Node(Comparable data, Node parent){
        this.data = data;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }
    public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }
    public void setParent(Node parent){
        this.parent = parent;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getRight(){
        return this.right;
    }
    public Node getParent(){
        return this.parent;
    }
    public Comparable getData(){
        return this.data;
    }
}
