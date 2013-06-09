/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/3/13
 *
 * Queue.java 
 * Uses the Node class in a linked list.
 * EnQueue adds the node to the end of the linked list.
 * DeQueue removes and returns the head node from the list.
 * 
 */
package ADTs;
 
public class Queue{
	private Node head;
	
	public Queue(){
		this.head = null;
	}
	
	public <K> void enQueue(K data){
		if(this.head == null){
			this.head = new Node(data,null);
		}
		else{
			Node current = this.head;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(new Node(data,null));
		}
	}
	
	public Node deQueue(){
		Node returnNode = this.head;
		if(this.head != null){
			this.head = this.head.getNext();
		}
		return returnNode;
	}
	public void printQueue(){
		Node current = this.head;
		System.out.println("Queue:\nTOP");
		while(current!= null){
				System.out.println("Data: "+current.getData());
				current = current.getNext();
		}
		System.out.println("END");
	}
		
	public static void main(String[] args){
		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2.12);
		q.enQueue("Test3");
		q.printQueue();
		Node returned = q.deQueue();
		while(returned != null){
			System.out.println("Queue returned: "+returned.getData());
			q.printQueue();
			returned = q.deQueue();
		}
	}
	
	
}