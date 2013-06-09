/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/9/13
 *
 * RunALL.java 
 * Runs the main methods for Queue, Stack, Binary Heap Array Structure, and Priority Queue
 * 
 */

package ADTs;

public class RunALL {
    public RunALL(){
    }
    
    public static void main(String[] args){
        System.out.println("Running Queue\n----------");
        Queue.main(args);
        System.out.println("\nRunning Stack\n----------");
        Stack.main(args);
        System.out.println("\nRunning Binary Heap Array Structure\n----------");
        Binary_Heap_Array_Structure.main(args);
        System.out.println("\nRunning Priority Queue\n----------");
        Priority_Queue.main(args);
    }
}
