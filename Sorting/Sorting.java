package Sorting;

public class Sorting {

    public static void main(String[] args){
        int[] unsortedNumsStored = new int[100];
        int[] unsortedNums = new int[100];
        for(int i = 0; i < 100; i++){
            unsortedNums[i] = (int) Math.round(Math.random()*100);
        }
        System.arraycopy(unsortedNums, 0, unsortedNumsStored, 0, 100);

        System.out.println("Before:");
        for(int i = 0; i < 100; i++){
            System.out.print(unsortedNums[i]+" ");
        }
        System.out.println();
        
        unsortedNums = Quicksort.quicksort(unsortedNums);
        System.out.println("After QuickSort:");
        for(int i = 0; i < 100; i++){
            System.out.print(unsortedNums[i]+" ");
        }
        System.out.println();
        
        System.arraycopy(unsortedNumsStored, 0, unsortedNums, 0, 100);

        unsortedNums = Mergesort.mergesort(unsortedNums);
        System.out.println("After MergeSort:");
        for(int i = 0; i < 100; i++){
            System.out.print(unsortedNums[i]+" ");
        }
        System.out.println();
        
        System.arraycopy(unsortedNumsStored, 0, unsortedNums, 0, 100);
        
        unsortedNums = Insertionsort.insertionsort(unsortedNums);
        System.out.println("After InsertionSort:");
        for(int i = 0; i < 100; i++){
            System.out.print(unsortedNums[i]+" ");
        }
        System.out.println();
    }
}
