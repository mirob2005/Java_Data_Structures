package Sorting;

public class Quicksort {
    public static int[] quicksort(int[] array){
        int length = array.length;
        if(length <=1){
            return array;
        }
        int pivot = array[(int)length/2];
        int[] less = new int[length];
        int[] more = new int[length];
        int lessCount = 0;
        int moreCount = 0;
        
        for(int i = 0; i <length;i++){
            if(i == (int)length/2)
                continue;
            if(array[i]<=pivot){
                less[lessCount] = array[i];
                lessCount++;
            }
            else{
                more[moreCount] = array[i];
                moreCount++;
            }
        }
        int[] low = new int[lessCount];
        System.arraycopy(less, 0, low, 0, lessCount);
        int[] high = new int[moreCount];
        System.arraycopy(more, 0, high, 0, moreCount);

        low = quicksort(low);
        high = quicksort(high);
        
        int[] returnMe = new int[length];
        System.arraycopy(low, 0, returnMe, 0, low.length);
        returnMe[low.length] = pivot;
        System.arraycopy(high, 0, returnMe, low.length+1, high.length);
        return returnMe;
    }
}
