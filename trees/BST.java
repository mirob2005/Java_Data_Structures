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
        if(this.root == null){
            return false;
        }
        return this.deleteData(data, this.root);
    }
    private boolean deleteData(Comparable data, Node root){
        if(root.getData()==data){
            if(root.getLeft()==null && root.getRight()==null){
                return this.deleteLeaf(root);
            }
            else if(root == this.root){
                return this.deleteRoot(root);
            }
            else{
                return this.deleteInternal(root);
            }
        }
        if(root.getData().compareTo(data)<0){
            if(root.getRight()==null){
                return false;
            }
            return this.deleteData(data, root.getRight());
        }
        else{
            if(root.getLeft()==null){
                return false;
            }
            return this.deleteData(data, root.getLeft());
        }
    }
    private boolean deleteLeaf(Node root){
        if(root == this.root){
            this.root = null;
        }
        else{
            if(root.isLeftChild()){
                root.getParent().setLeft(null);
                root.setParent(null);
            }
            else{
                root.getParent().setRight(null);
                root.setParent(null);
            }
        }
        return true;
    }
    private boolean deleteRoot(Node root){
        if(root.getLeft()==null){
            Node right = root.getRight();
            right.setParent(null);
            root.setRight(null);
            this.root = right;
        }
        else if(root.getRight()==null){
            Node left = root.getLeft();
            left.setParent(null);
            root.setLeft(null);
            this.root = left;
        }
        else{
            Node replace = root.getLeft();
            //Inorder predecessor
            while(replace.getRight()!=null){
                replace = replace.getRight();
            }
            if(replace != root.getLeft() && replace !=root.getRight()){
                if(replace.getLeft()!=null){
                    Node grandchild = replace.getLeft();
                    replace.getParent().setRight(grandchild);
                    grandchild.setParent(replace.getParent());
                }
                else{
                    replace.getParent().setRight(null);
                }
            }
            if(replace != root.getLeft()){
                replace.setLeft(root.getLeft());
                root.getLeft().setParent(replace);
            }
            if(replace != root.getRight()){
                replace.setRight(root.getRight());
                root.getRight().setParent(replace);
            }
            root.setLeft(null);
            root.setRight(null);
            this.root = replace;
            replace.setParent(null);
        }
        return true;
    }
    private boolean deleteInternal(Node root){
        if(root.getLeft()==null){
            Node right = root.getRight();
            right.setParent(root.getParent());
            root.setRight(null);
            if(root.isLeftChild()){
                root.getParent().setLeft(right);
            }
            else{
                root.getParent().setRight(right);
            }
            root.setParent(null);
        }
        else if(root.getRight()==null){
            Node left = root.getLeft();
            left.setParent(root.getParent());
            root.setLeft(null);
            if(root.isLeftChild()){
                root.getParent().setLeft(left);
            }
            else{
                root.getParent().setRight(left);
            }
            root.setParent(null);
        }
        else{
            Node replace = root.getLeft();
            //Inorder predecessor
            while(replace.getRight()!=null){
                replace = replace.getRight();
            }
            if(root.isLeftChild()){
                root.getParent().setLeft(replace);
            }
            else{
                root.getParent().setRight(replace);
            }
            if(replace.isLeftChild()){
                replace.getParent().setLeft(replace.getLeft());
            }
            else{
                replace.getParent().setRight(replace.getLeft());
            }
            if(replace.getLeft()!=null){
                replace.getLeft().setParent(replace.getParent());
            }
            replace.setParent(root.getParent());
            root.setParent(null);
            replace.setRight(root.getRight());
            if(replace.getRight()!=null){
                replace.getRight().setParent(replace);
            }
            replace.setLeft(root.getLeft());
            if(replace.getLeft()!=null){
                replace.getLeft().setParent(replace);
            }
            root.setRight(null);
            root.setLeft(null);
        }
        return true;
    }
    public boolean find(Comparable data){
        if(this.root == null){
            return false;
        }
        return findData(data,this.root);
    }
    private boolean findData(Comparable data, Node root){
        if(root.getData()==data){
            return true;
        }
        if(root.getData().compareTo(data)<0){
            if(root.getRight()==null){
                return false;
            }
            return this.findData(data, root.getRight());
        }
        else{
            if(root.getLeft()==null){
                return false;
            }
            return this.findData(data, root.getLeft());
        }
    }
    public Comparable findMin(){
        if(this.root == null){
            return null;
        }
        Node root = this.root;
        while(root.getLeft()!=null){
            root = root.getLeft();
        }
        return root.getData();
    }
    public Comparable findMax(){
        if(this.root == null){
            return null;
        }
        Node root = this.root;
        while(root.getRight()!=null){
            root = root.getRight();
        }
        return root.getData();
    }
    public BST copyTree(){
        BST copy = new BST();
        copy.root = new Node(this.root.getData(),null);
        this.copyNode(copy.root, this.root);
        return copy;
    }
    private void copyNode(Node copyRoot, Node root){
        // Traverse Preorder
        if(root.getLeft()!=null){
            copyRoot.setLeft(new Node(root.getLeft().getData(),copyRoot));
            this.copyNode(copyRoot.getLeft(),root.getLeft());
        }
        if(root.getRight()!=null){
            copyRoot.setRight(new Node(root.getRight().getData(),copyRoot));
            this.copyNode(copyRoot.getRight(),root.getRight());
        }
    }
    public void deleteTree(){
        this.deleteNode(this.root);
    }
    private void deleteNode(Node root){
        //Traverse Postorder
        if(root.getLeft()!=null){
            this.deleteNode(root.getLeft());
        }
        if(root.getRight()!=null){
            this.deleteNode(root.getRight());
        }
        this.clearData(root);
    }
    private void clearData(Node root){
        System.out.println("Deleting "+root.getData());
        root.setData(null);
        if(root.getParent()!=null){
            if(root.isLeftChild()){
                root.getParent().setLeft(null);
            }
            else{
                root.getParent().setRight(null);
            }
        }
        else{
            this.root = null;
        }
        root.setParent(null);
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
    public void printBranches(){
        System.out.println("Traversing tree branches");
        Queue<Node> q = new LinkedList<>();
        Node current = this.root;
        while(current != null){
            if(current.getParent()!=null){
                System.out.print(current.getParent().getData());
            }
            else{
                System.out.print("null");
            }
            System.out.print("->"+current.getData()+"->");
            if(current.getLeft()!=null){
                q.add(current.getLeft());
                System.out.print(current.getLeft().getData());
            }
            else{
                System.out.print("null");
            }
            if(current.getRight()!=null){
                q.add(current.getRight());
                System.out.print("|"+current.getRight().getData());
            }
            else{
                System.out.print("|null");
            }
            current = q.poll();
            System.out.println();
        }
        System.out.println();
    }
}
