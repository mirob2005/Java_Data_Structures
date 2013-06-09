/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/3/13
 *
 * Stack.java 
 * Uses the node class in a linked list
 * Push/Pop operation only affects the head of the list
 * 
 */
package ADTs;

public class Stack{
	private Node head;
	public Stack(){
		this.head = null;
	}
	public <K> void push(K data){
		Node<K> node = new Node(data,this.head);
		this.head = node;
	}
	public Node pop(){
		if(this.head != null){
			Node oldData = this.head;
			this.head = this.head.getNext();
			return oldData;
		}
		return null;
	}
	public void print(){
		System.out.println("Stack Data:\nTOP");
		Node current = this.head;
		while(current != null){
			System.out.println("Data = "+current.getData());
			current = current.getNext();
		}
		System.out.println("END");
	}
	public static void main(String[] args){
		Stack s = new Stack();
		s.push("Test1");
		s.push(2);
		s.push(3.14);
		s.print();
		Node returned = s.pop();
		while(returned != null){
			System.out.println("Stack returned: "+returned.getData());
			s.print();
			returned = s.pop();
		}
	}
}