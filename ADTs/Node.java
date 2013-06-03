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
