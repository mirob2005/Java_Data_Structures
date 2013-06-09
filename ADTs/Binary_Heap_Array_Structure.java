/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/9/13
 *
 * Binary_Heap_Array_Structure.java
 * Object currently used in Priority_Queue.java
 * 
 * Implements a max heap
 * Children are at [2i+1] and [2i+2]
 * Parent is at [floor((i-1)/2)]
 * where the array goes from 0 to n-1 and the root is at index 0
 * 
 */
package ADTs;

import java.util.List;
import java.util.ArrayList;
 
class Binary_Heap_Array_Structure<K extends Comparable<K>> {
    private List<K> list;
    public Binary_Heap_Array_Structure(){
        this.list = new ArrayList<K>();
    }
    public void insert(K value){
        try{
            this.list.add(value);
            this.heapifyUp();
        }
        catch(ClassCastException e){
            System.out.println("CAUGHT: "+e);
            this.list.remove(this.list.size()-1);
        }
    }
    public void heapifyUp(){
        int childIndex = this.list.size()-1;
        int parentIndex = this.getParentIndex(childIndex);
        K child = list.get(childIndex);
        K parent = list.get(parentIndex);
        while(child.compareTo(parent)>0){
            K temp = child;
            list.set(childIndex,parent);
            list.set(parentIndex,temp);
            childIndex = parentIndex;
            parentIndex = this.getParentIndex(childIndex);
            child = list.get(childIndex);
            parent = list.get(parentIndex);
        }
    }
    public K delete(){
        if(this.list.isEmpty()){
            return null;
        }
        K deleted = this.list.get(0);
        this.list.set(0,this.list.get(this.list.size()-1));
        this.list.remove(this.list.size()-1);
        if(!this.list.isEmpty()){
            this.heapifyDown(0);
        }
        return deleted;
    }
    public void heapifyDown(int index){
        K rightChild = this.getRightChild(index);
        K leftChild = this.getLeftChild(index);
        K parent = this.list.get(index);
        int nextIndex = index;
        if(rightChild == null && leftChild == null){
            return;
        }
        else if(rightChild == null || leftChild.compareTo(rightChild)>0){
            if(parent.compareTo(leftChild)<0){
                this.list.set(index,leftChild);
                nextIndex = this.getLeftChildIndex(index);
                this.list.set(nextIndex,parent);
            }
            else{
                return;
            }
        }
        else{
            if(parent.compareTo(rightChild)<0){
                this.list.set(index,rightChild);
                nextIndex = this.getRightChildIndex(index);
                this.list.set(nextIndex,parent);
            }
            else{
                return;
            }
        }
        this.heapifyDown(nextIndex);
    }
    public K peek(){
        if(!list.isEmpty()){
            return list.get(0);
        }
        else{
            return null;
        }
    }
    public void print(){
        System.out.println(this.list.toString());
    }
    public void traverseBFS(){
        System.out.println("Heap:");
        for(int index = 0; index < this.list.size(); index++){
            K parent = this.getParent(index);
            System.out.println("Parent: " + parent);
            K leftChild = this.getLeftChild(index);
            System.out.println("Node: " + this.list.get(index));
            System.out.println("leftChild: " + leftChild);
            K rightChild = this.getRightChild(index);
            System.out.println("rightChild: " + rightChild);
            System.out.println();
        }
    }
    public boolean validChild(int index){
        if(index < this.list.size()){
            return true;
        }
        else{
            return false;
        }
    }
    public int getParentIndex(int index){
        return (index-1)/2;
    }
    public K getParent(int index){
        if(index == 0){
            return null;
        }
        else{
            return this.list.get(this.getParentIndex(index));
        }
    }
    public int getLeftChildIndex(int index){
        return ((2*index)+1);
    }
    public K getLeftChild(int index){
        int childIndex = this.getLeftChildIndex(index);
        if(this.validChild(childIndex)){
            return this.list.get(childIndex);
        }
        else{
            return null;
        }
    }
    public int getRightChildIndex(int index){
        return ((2*index)+2);
    }
    public K getRightChild(int index){
        int childIndex = this.getRightChildIndex(index);
        if(this.validChild(childIndex)){
            return this.list.get(childIndex);
        }
        else{
            return null;
        }
    }
    public List<K> getArray(){
        return this.list;
    }
    private void setHeap(List<K> copyList){
        for(int i=0;i<copyList.size();i++){
            this.list.add(copyList.get(i));
        }
    }
    public Binary_Heap_Array_Structure copyHeap(){
        Binary_Heap_Array_Structure copy = new Binary_Heap_Array_Structure();
        copy.setHeap(this.list);
        return copy;
    }
    public static void main(String[] args){
        Binary_Heap_Array_Structure bh = new Binary_Heap_Array_Structure();
        bh.insert(3);
        bh.print();
        bh.insert(1);
        bh.print();
        bh.insert(4);
        bh.print();
        bh.insert(0);
        bh.print();
        bh.traverseBFS();
        System.out.println("Peek returned: "+bh.peek());
        System.out.println("Delete Returned: " + bh.delete());
        bh.print();
        bh.traverseBFS();

        Binary_Heap_Array_Structure <String>bhs = new Binary_Heap_Array_Structure<>();
        bhs.insert("Three");
        bhs.print();
        bhs.insert("One");
        bhs.print();
        bhs.insert("Four");
        bhs.print();
        bhs.insert("Zero");
        bhs.print();
        bhs.traverseBFS();
        System.out.println("Peek returned: "+bhs.peek());
        System.out.println("Delete Returned: " + bhs.delete());
        bhs.print();
        bhs.traverseBFS();

        System.out.println("------------");
        Binary_Heap_Array_Structure copyHeap = bh.copyHeap();
        copyHeap.print();
        copyHeap.insert(10);
        copyHeap.print();
        bh.print();
    }
}