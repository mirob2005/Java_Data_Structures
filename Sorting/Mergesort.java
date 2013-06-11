package Sorting;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {
    public static <T extends Comparable<T>> List<T> mergesort(List<T> array){
        int length = array.size();
        if(length <=1){
            return array;
        }
        int half = (int)length/2;
        List <T> left = new ArrayList<>(array.subList(0, half));
        List <T> right = new ArrayList<>(array.subList(half, array.size()));
        
        left = mergesort(left);
        right = mergesort(right);
        
        return merge(left,right);
    }
    public static <T extends Comparable <T>> List<T> merge(List<T> left, List<T> right){
        List<T> result = new ArrayList<>();
        int length = left.size() + right.size();
        
        int curLeft = 0,curRight = 0,curResult = 0;
        while(curResult < length){
            if(left.isEmpty() || curLeft==left.size()){
                result.addAll(right.subList(curRight, right.size()));
                break;
            }
            else if(right.isEmpty()|| curRight==right.size()){
                result.addAll(left.subList(curLeft, left.size()));
                break;
            }
            else{
                if(right.get(curRight).compareTo(left.get(curLeft))<0){
                    result.add(right.get(curRight));
                    curRight++;
                    curResult++;
                }
                else{
                    result.add(left.get(curLeft));
                    curLeft++;
                    curResult++;
                }
            }
        }
        return result;
    }
}
