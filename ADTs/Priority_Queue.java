/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/9/13
 *
 * Priority_Queue.java 
 * Implements a priority queue using Binary_Heap_Array_Structure.java
 * 
 */

package ADTs;

class Priority_Queue<K extends Comparable<K>>{
    private Binary_Heap_Array_Structure <K> bh;
    
    public Priority_Queue(){
        bh = new Binary_Heap_Array_Structure<>();
    }
    public void enQueue(K data){
        this.bh.insert(data);
    }
    public K deQueue(){
        return this.bh.delete();
    }
    public void print(){
        Binary_Heap_Array_Structure copy = this.bh.copyHeap();
        
        System.out.print("FRONT < "+copy.delete());
        while(copy.peek()!=null){
            System.out.print(", " + copy.delete());
        }
        System.out.print("> BACK\n");
    }
    
    public static void main(String[] args){
        Priority_Queue <String> qs = new Priority_Queue<>();
        qs.enQueue("one");
        qs.enQueue("ten");
        qs.enQueue("five");
        qs.enQueue("seven");
        qs.print();
        
        Priority_Queue <Integer> qi = new Priority_Queue<>();
        qi.enQueue(1);
        qi.enQueue(10);
        qi.enQueue(5);
        qi.enQueue(7);
        qi.print();
    }
}