package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorting {
    public static void testDoubles(){
        List<Double> unsortedDoubles = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            unsortedDoubles.add(Math.random()*100);
        }
        System.out.println("Testing Doubles:");
        test(unsortedDoubles);
    }
    public static void testIntegers(){
        List<Integer> unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            unsorted.add((int)Math.round(Math.random()*100));
        }
        System.out.println("Testing Integers:");
        test(unsorted);
    }
    public static void testStrings(){
        List<String> unsorted = new ArrayList<>();
        unsorted.add("one");
        unsorted.add("two");
        unsorted.add("three");
        unsorted.add("four");
        unsorted.add("five");
        unsorted.add("six");
        unsorted.add("seven");
        unsorted.add("eight");
        unsorted.add("nine");
        unsorted.add("ten");
        System.out.println("Testing Strings:");
        test(unsorted);
    }
    public static void testBytes(){
        List<Byte> unsorted = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            unsorted.add((byte)Math.round(Math.random()*100));
        }
        System.out.println("Testing Bytes:");
        test(unsorted);
    }
    public static <T extends Comparable<T>> void test(List<T> unsorted){
        
        List<T>sortedQ,sortedM,sortedI;
        System.out.println("Before:");
        System.out.println(unsorted);
        
        sortedQ = Quicksort.quicksort(unsorted);
        System.out.println("After QuickSort:");
        System.out.println(sortedQ);
        
        System.out.println();

        System.out.println("Before:");
        System.out.println(unsorted);
        
        sortedM = Mergesort.mergesort(unsorted);
        System.out.println("After MergeSort:");
        System.out.println(sortedM);
        
        System.out.println();
        
        System.out.println("Before:");
        System.out.println(unsorted);
        
        System.out.println("After InsertionSort:");
        sortedI = Insertionsort.insertionsort(unsorted);
        System.out.println(sortedI);
        
        if(sortedQ.equals(sortedM) && sortedQ.equals(sortedI)){
            System.out.println("\n->All  3 methods agree");
        }
        else{
            System.out.println("\n->All  3 methods DO NOT agree");
        } 
        System.out.println("---------------------------------------");
    }
    
    public static void main(String[] args){
        testDoubles();
        testIntegers();
        testBytes();
        testStrings();
    }
}
