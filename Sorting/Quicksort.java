package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {
    public static <T extends Comparable <T>> List<T> quicksort(List<T> array){
        int length = array.size();
        if(length <=1){
            return array;
        }
        T pivot = array.get((int)length/2);
        List<T> less = new ArrayList<>();
        List<T> more = new ArrayList<>();
        
        for(int i = 0; i <length;i++){
            if(i == (int)length/2)
                continue;
            if(array.get(i).compareTo(pivot)<=0){
                less.add(array.get(i));
            }
            else{
                more.add(array.get(i));
            }
        }
        less = quicksort(less);
        more = quicksort(more);
        List<T> returnMe = new ArrayList<>();
        returnMe.addAll(less);
        returnMe.add(pivot);
        returnMe.addAll(more);
        return returnMe;
    }
}
