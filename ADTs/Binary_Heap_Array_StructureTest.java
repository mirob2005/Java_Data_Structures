/*
 * Michael Robertson
 * mirob2005@gmail.com
 * Completed: 6/9/13
 *
 * Binary_Heap_Array_StructureTest.java
 * Set of JUnit tests to test Binary_Heap_Array_Structure.java
 * 
 */

package ADTs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Binary_Heap_Array_StructureTest {
    
    public Binary_Heap_Array_StructureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Tests of insert method, of class Binary_Heap_Array_Structure.
     */
    @Test
    public void testInsertInteger() {
        System.out.println("Testing Insert Integer");
        Binary_Heap_Array_Structure instance = new Binary_Heap_Array_Structure();
        instance.insert(1);
        assertEquals(instance.getArray().toString(),"[1]");
        instance.insert(2);
        assertEquals(instance.getArray().toString(),"[2, 1]");
        instance.insert(3);
        assertEquals(instance.getArray().toString(),"[3, 1, 2]");
        instance.insert(4);
        assertEquals(instance.getArray().toString(),"[4, 3, 2, 1]");
        instance.insert(5);
        assertEquals(instance.getArray().toString(),"[5, 4, 2, 1, 3]");
        instance.insert(6);
        assertEquals(instance.getArray().toString(),"[6, 4, 5, 1, 3, 2]");
        instance.insert(7);
        assertEquals(instance.getArray().toString(),"[7, 4, 6, 1, 3, 2, 5]");
        instance.insert(8);
        assertEquals(instance.getArray().toString(),"[8, 7, 6, 4, 3, 2, 5, 1]");
        instance.insert(9);
        assertEquals(instance.getArray().toString(),"[9, 8, 6, 7, 3, 2, 5, 1, 4]");
        instance.insert(10);
        assertEquals(instance.getArray().toString(),"[10, 9, 6, 7, 8, 2, 5, 1, 4, 3]");
        instance.insert(11);
        assertEquals(instance.getArray().toString(),"[11, 10, 6, 7, 9, 2, 5, 1, 4, 3, 8]");
        instance.insert(12);
        assertEquals(instance.getArray().toString(),"[12, 10, 11, 7, 9, 6, 5, 1, 4, 3, 8, 2]");
        instance.insert(13);
        assertEquals(instance.getArray().toString(),"[13, 10, 12, 7, 9, 11, 5, 1, 4, 3, 8, 2, 6]");
        instance.insert(14);
        assertEquals(instance.getArray().toString(),"[14, 10, 13, 7, 9, 11, 12, 1, 4, 3, 8, 2, 6, 5]");
        instance.insert(15);
        assertEquals(instance.getArray().toString(),"[15, 10, 14, 7, 9, 11, 13, 1, 4, 3, 8, 2, 6, 5, 12]");
        instance.insert(10);
        assertEquals(instance.getArray().toString(),"[15, 10, 14, 10, 9, 11, 13, 7, 4, 3, 8, 2, 6, 5, 12, 1]");
        instance.insert(-1);
        assertEquals(instance.getArray().toString(),"[15, 10, 14, 10, 9, 11, 13, 7, 4, 3, 8, 2, 6, 5, 12, 1, -1]");
        System.out.println("Testing Insert Integer PASSED");
    }

    /**
     * Test of delete method, of class Binary_Heap_Array_Structure.
     */
    @Test
    public void testDelete() {
        System.out.println("Testing Delete");
        Binary_Heap_Array_Structure instance = new Binary_Heap_Array_Structure();
        instance.insert(1);
        instance.insert(2);
        instance.insert(3);
        instance.insert(4);
        instance.insert(5);
        instance.insert(6);
        instance.insert(7);
        instance.insert(8);
        instance.insert(9);
        instance.insert(10);
        instance.insert(11);
        instance.insert(12);
        instance.insert(13);
        instance.insert(14);
        instance.insert(15);
        instance.insert(10);
        instance.insert(-1);
        assertEquals(instance.getArray().toString(),"[15, 10, 14, 10, 9, 11, 13, 7, 4, 3, 8, 2, 6, 5, 12, 1, -1]");
        
        assertEquals(instance.delete(),15);
        assertEquals(instance.getArray().toString(),"[14, 10, 13, 10, 9, 11, 12, 7, 4, 3, 8, 2, 6, 5, -1, 1]");
        assertEquals(instance.delete(),14);
        assertEquals(instance.getArray().toString(),"[13, 10, 12, 10, 9, 11, 5, 7, 4, 3, 8, 2, 6, 1, -1]");
        assertEquals(instance.delete(),13);
        assertEquals(instance.getArray().toString(),"[12, 10, 11, 10, 9, 6, 5, 7, 4, 3, 8, 2, -1, 1]");
        assertEquals(instance.delete(),12);
        assertEquals(instance.getArray().toString(),"[11, 10, 6, 10, 9, 2, 5, 7, 4, 3, 8, 1, -1]");
        assertEquals(instance.delete(),11);
        assertEquals(instance.getArray().toString(),"[10, 10, 6, 7, 9, 2, 5, -1, 4, 3, 8, 1]");
        assertEquals(instance.delete(),10);
        assertEquals(instance.getArray().toString(),"[10, 9, 6, 7, 8, 2, 5, -1, 4, 3, 1]");
        assertEquals(instance.delete(),10);
        assertEquals(instance.getArray().toString(),"[9, 8, 6, 7, 3, 2, 5, -1, 4, 1]");
        assertEquals(instance.delete(),9);
        assertEquals(instance.getArray().toString(),"[8, 7, 6, 4, 3, 2, 5, -1, 1]");
        assertEquals(instance.delete(),8);
        assertEquals(instance.getArray().toString(),"[7, 4, 6, 1, 3, 2, 5, -1]");
        assertEquals(instance.delete(),7);
        assertEquals(instance.getArray().toString(),"[6, 4, 5, 1, 3, 2, -1]");
        assertEquals(instance.delete(),6);
        assertEquals(instance.getArray().toString(),"[5, 4, 2, 1, 3, -1]");
        assertEquals(instance.delete(),5);
        assertEquals(instance.getArray().toString(),"[4, 3, 2, 1, -1]");
        assertEquals(instance.delete(),4);
        assertEquals(instance.getArray().toString(),"[3, 1, 2, -1]");
        assertEquals(instance.delete(),3);
        assertEquals(instance.getArray().toString(),"[2, 1, -1]");
        assertEquals(instance.delete(),2);
        assertEquals(instance.getArray().toString(),"[1, -1]");
        assertEquals(instance.delete(),1);
        assertEquals(instance.getArray().toString(),"[-1]");
        assertEquals(instance.delete(),-1);
        assertEquals(instance.getArray().toString(),"[]");
        assertEquals(instance.delete(),null);
        assertEquals(instance.getArray().toString(),"[]");
        System.out.println("Testing Delete PASSED");
    }


    /**
     * Test of peek method, of class Binary_Heap_Array_Structure.
     */
    @Test
    public void testPeek() {
        System.out.println("Testing Peek");
        Binary_Heap_Array_Structure instance = new Binary_Heap_Array_Structure();
        assertEquals(instance.peek(),null);
        instance.insert(1);
        assertEquals(instance.peek(),1);
        instance.insert(2);
        assertEquals(instance.peek(),2);
        instance.insert(3);
        assertEquals(instance.peek(),3);
        instance.insert(4);
        assertEquals(instance.peek(),4);
        instance.insert(5);
        assertEquals(instance.peek(),5);
        instance.insert(6);
        assertEquals(instance.peek(),6);
        instance.insert(7);
        assertEquals(instance.peek(),7);
        instance.insert(8);
        assertEquals(instance.peek(),8);
        instance.insert(9);
        assertEquals(instance.peek(),9);
        instance.insert(10);
        assertEquals(instance.peek(),10);
        instance.insert(11);
        assertEquals(instance.peek(),11);
        instance.insert(12);
        assertEquals(instance.peek(),12);
        instance.insert(13);
        assertEquals(instance.peek(),13);
        instance.insert(14);
        assertEquals(instance.peek(),14);
        instance.insert(15);
        assertEquals(instance.peek(),15);
        instance.insert(10);
        assertEquals(instance.peek(),15);
        instance.insert(-1);
        assertEquals(instance.peek(),15);
        System.out.println("Testing Peek PASSED");
    }
}