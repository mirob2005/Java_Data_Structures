package binary_heap_array_structure;

/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/--/13
 *
 * Binary_Heap_Array_Structure.java
 * 
 * Implements a max heap
 * Children are at [2i+1] and [2i+2]
 * Parent is at [floor((i-1)/2)]
 * where the array goes from 0 to n-1 and the root is at index 0
 * 
 */
import java.util.List;
import java.util.ArrayList;
 
class Binary_Heap_Array_Structure<K extends Comparable<K>> {
	private List<K> list;
	public Binary_Heap_Array_Structure(){
	  this.list = new ArrayList<K>();
	}
	public void insert(K value){
	 this.list.add(value);
	 this.heapifyUp();
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
	public static void main(String[] args){
		Binary_Heap_Array_Structure <Integer>bh = new Binary_Heap_Array_Structure<>();
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
		bhs.insert("ONe");
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
	}
}