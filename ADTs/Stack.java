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
		System.out.println("Stack Data:");
		Node current = this.head;
		while(current != null){
			System.out.println("Data = "+current.getData());
			current = current.getNext();
		}
	}
	public static void main(String[] args){
		Stack s = new Stack();
		s.push("Test1");
		s.push(2);
		s.push("Test2");
		s.print();
		System.out.println("Stack returned: "+s.pop().getData());
		s.print();
		System.out.println("END");
	}
}
