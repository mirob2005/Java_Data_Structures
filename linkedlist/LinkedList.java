package linkedlist;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    
    public LinkedList(){
        this.head = null;
        this.tail = null;
    };
    public void addLast(T data){
        if(this.head == null){
            this.head = new Node<>(data,null);
            this.tail = this.head;
        }
        else{
            Node<T> back = new Node<>(data, null);
            this.tail.setNext(back);
            this.tail = back;
        }
    }
    public void addFirst(T data){
        Node<T> front = new Node<>(data,this.head);
        if(this.head==null){
            this.tail = front;
        }
        this.head = front;
    }
    public T removeFirst(){
        if(this.head==null){
            return null;
        }
        T data = this.head.getData();
        if(this.head==this.tail){
            this.tail = null;
            this.head = null;
        }
        else{
            this.head = this.head.getNext();
        }
        return data;
    }
    public T removeLast(){
        if(this.tail==null){
            return null;
        }
        T data = this.tail.getData();
        if(this.tail==this.head){
            this.tail = null;
            this.head = null;
        }
        else{
            Node<T> ptr = this.head;
            while(ptr.getNext()!=null && ptr.getNext()!=this.tail){
                ptr = ptr.getNext();
            }
            ptr.setNext(null);
            this.tail = ptr;
        }
        return data;
    }
    public void insertAtIndex(T data, int index) throws IndexOutOfBoundsException{
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            addFirst(data);
        }
        else{
            int counter = 0;
            Node<T> ptr = this.head;
            while(ptr.getNext()!=null&&(counter+1)!=index){
                ptr = ptr.getNext();
                counter++;
            }
            if((counter+1)==index){
                Node<T> next = ptr.getNext();
                ptr.setNext(new Node<>(data,next));
                if(this.tail==ptr){
                    //next==null
                    this.tail=ptr.getNext();
                }
            }
            else{
                throw new IndexOutOfBoundsException();
            }
        }
    }
    public T removeAtIndex(int index) throws IndexOutOfBoundsException{
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            return removeFirst();
        }
        else{
            int counter = 0;
            Node<T> ptr = this.head;
            while(ptr.getNext()!=null && (counter+1)!=index){
                ptr = ptr.getNext();
                counter++;
            }
            if((counter+1)==index){
                Node<T> next = ptr.getNext();
                if(next==null){
                    throw new IndexOutOfBoundsException();
                }
                else{
                    T data = next.getData();
                    if(this.tail==next){
                        this.tail = ptr;
                    }
                    ptr.setNext(next.getNext());
                    return data;
                }
            }
            else{
                throw new IndexOutOfBoundsException();
            }
        }
    }
    public T getDataAtIndex(int index) throws IndexOutOfBoundsException{
        if(index<0){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        Node<T> ptr = this.head;
        while(ptr.getNext()!=null && counter!=index){
            ptr = ptr.getNext();
            counter++;
        }
        if(counter==index){
            return ptr.getData();
        }
        throw new IndexOutOfBoundsException();
    }
    public int getIndex(T data){
        if(this.head == null){
            return -1;
        }
        else{
            int counter = 0;
            Node<T> ptr = this.head;
            while(ptr.getData()!=data && ptr.getNext()!=null){
                ptr = ptr.getNext();
                counter++;
            }
            if(ptr.getData()==data){
                return counter;
            }
            else{
                return -1;
            }
        }
    }
    public T peekFront(){
        return this.head.getData();
    }
    public T peekBack(){
        return this.tail.getData();
    }
    public boolean contains(T data){
        if(this.head == null){
            return false;
        }
        Node<T> ptr = this.head;
        while(ptr.getData()!=data && ptr.getNext()!=null){
            ptr = ptr.getNext();
        }
        if(ptr.getData()==data){
            return true;
        }
        return false;
    }
    
    @Override
    public String toString(){
        StringBuilder list = new StringBuilder();
        if(this.head==null){
            list.append("(EMPTY)");
        }
        else{
            Node<T> ptr = this.head;
            list.append((this.head.getData()+"->"));
            while(ptr.getNext()!=null){
                ptr = ptr.getNext();
                list.append((ptr.getData()+"->"));
            }
            list.append("null");
            list.append(("(tail="+this.tail.getData()+")"));
        }
        
        return list.toString();
    }
    
    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        System.out.println(ll);
        ll.addFirst(6);
        System.out.println(ll);
        System.out.println("Removed first: "+ ll.removeFirst());
        System.out.println(ll);
        System.out.println("Removed last: " + ll.removeLast());
        System.out.println(ll);
        while(ll.removeFirst()!=null){
            System.out.println(ll);
        }
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addLast(5);
        while(ll.removeLast()!=null){
            System.out.println(ll);
        }
        
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addFirst(6);
        System.out.println(ll);
        System.out.println("Peeking at front: "+ll.peekFront());
        System.out.println("Peeking at back: "+ll.peekBack());
        try{
            System.out.println("Getting index -1: " + ll.getDataAtIndex(-1));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index -1 out of bounds!");
        }
        try{
            System.out.println("Getting index 0: " + ll.getDataAtIndex(0));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 0 out of bounds!");
        }
        try{
            System.out.println("Getting index 1: " + ll.getDataAtIndex(1));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 1 out of bounds!");
        }
        try{
            System.out.println("Getting index 5: " + ll.getDataAtIndex(5));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 5 out of bounds!");
        }
        try{
            System.out.println("Getting index 6: " + ll.getDataAtIndex(6));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 6 out of bounds!");
        }
        System.out.println(ll);
        System.out.println();
        try{
            System.out.println("Inserting at index -1: ");
            ll.insertAtIndex(11, -1);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index -1 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Inserting at index 0: ");
            ll.insertAtIndex(11, 0);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 0 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Inserting at index 1: ");
            ll.insertAtIndex(11, 1);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 1 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Inserting at index 8: ");
            ll.insertAtIndex(11, 8);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 8 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Inserting at index 10: ");
            ll.insertAtIndex(11, 10);
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 10 out of bounds!");
        }
        System.out.println(ll);
        System.out.println();
        System.out.println("Linked list contains 0: " + ll.contains(0));
        System.out.println("At index: " + ll.getIndex(0));
        System.out.println("Linked list contains 11: " + ll.contains(11));
        System.out.println("At index: " + ll.getIndex(11));
        System.out.println("Linked list contains 6: " + ll.contains(6));
        System.out.println("At index: " + ll.getIndex(6));
        System.out.println("Linked list contains 5: " + ll.contains(5));
        System.out.println("At index: " + ll.getIndex(5));
        System.out.println();
        try{
            System.out.println("Removing at index -1: "+ll.removeAtIndex(-1));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index -1 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Removing at index 0: "+ll.removeAtIndex(0));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 0 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Removing at index 1: "+ll.removeAtIndex(1));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 1 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Removing at index 5: "+ll.removeAtIndex(5));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 5 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Removing at index 5: "+ll.removeAtIndex(5));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 5 out of bounds!");
        }
        System.out.println(ll);
        try{
            System.out.println("Removing at index 5: "+ll.removeAtIndex(5));
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("Index 5 out of bounds!");
        }
        System.out.println(ll);
        while(ll.removeAtIndex(0)!=null){
            System.out.println(ll);
        }
        ll.addFirst(5);
        System.out.println(ll);
    }
}
