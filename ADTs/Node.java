/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/3/13
 *
 * Node.java 
 * Object currently used in Queue.java and Stack.java
 * 
 */
package ADTs;
 
public class Node<K> {
	private K data;
	private Node next;

	public Node(K data, Node next){
		this.data = data;
		this.next = next;
	}
	
	public K getData(){
		return this.data;
	}
	public Node getNext(){
		return this.next;
	}
	public void setNext(Node nextNode){
		this.next = nextNode;
	}
}