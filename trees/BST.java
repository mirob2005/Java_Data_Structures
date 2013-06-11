package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST{
    private Node root;
    public BST(){
        this.root = null;
    }
    public void add(Comparable data){
        if(this.root == null){
            this.root = new Node(data,null);
        }
        else{
            this.addNode(data,this.root);
        }
    }
    private void addNode(Comparable data, Node root){
        try{
            if(data.compareTo(root.getData())<0){
                 if(root.getLeft()!=null){
                     this.addNode(data, root.getLeft());
                 }
                 else{
                     root.setLeft(new Node(data,root));
                 }
             }
             else if(data.compareTo(root.getData())>0){
                 if(root.getRight()!=null){
                     this.addNode(data, root.getRight());
                 }
                 else{
                     root.setRight(new Node(data,root));
                 }
             }
        }
        catch(ClassCastException e){
            System.out.println("<"+data +">is of wrong type: "+e);
        }
    }
    public boolean delete(Comparable data){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public boolean find(Comparable data){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Comparable findMin(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public Comparable findMax(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public BST copyTree(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void deleteTree(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void traverseDFSpreorder(){
        System.out.println("Traversing tree in preorder");
        this.DFSpreorder(this.root);
        System.out.println();
    }
    private void DFSpreorder(Node root){
        System.out.print(root.getData()+" ");
        if(root.getLeft()!=null){
            this.DFSpreorder(root.getLeft());
        }
        if(root.getRight()!=null){
            this.DFSpreorder(root.getRight());
        }
    }
    public void traverseDFSinorder(){
        System.out.println("Traversing tree inorder");
        this.DFSinorder(this.root);
        System.out.println();
    }
    private void DFSinorder(Node root){
        if(root.getLeft()!=null){
            this.DFSinorder(root.getLeft());
        }
        System.out.print(root.getData()+" ");
        if(root.getRight()!=null){
            this.DFSinorder(root.getRight());
        }
    }
    public void traverseDFSpostorder(){
        System.out.println("Traversing tree in postorder");
        this.DFSpostorder(this.root);
        System.out.println();
    }
    private void DFSpostorder(Node root){
        if(root.getLeft()!=null){
            this.DFSpostorder(root.getLeft());
        }
        if(root.getRight()!=null){
            this.DFSpostorder(root.getRight());
        }
        System.out.print(root.getData()+" ");
    }
    public void traverseBFS(){
        System.out.println("Traversing tree BFS");
        Queue<Node> q = new LinkedList<>();
        Node current = this.root;
        while(current != null){
            System.out.print(current.getData()+" ");
            if(current.getLeft()!=null){
                q.add(current.getLeft());
            }
            if(current.getRight()!=null){
                q.add(current.getRight());
            }
            current = q.poll();
        }
        System.out.println();
    }
}
