package Sorting;

public class Insertionsort {
    public static int[] insertionsort(int[] array){
        if(array.length <=1){
            return array;
        }
        int curIndex = 1;
        int curNum;
        while(curIndex < array.length){
            curNum = array[curIndex];
            int compareIndex = curIndex-1;
            boolean moved = false;
            while(compareIndex >=0 && curNum < array[compareIndex]){
                array[compareIndex+1] = array[compareIndex];
                compareIndex--;
                moved = true;
            }
            if(moved){
                array[compareIndex+1] = curNum;
            }
            curIndex++;
        }
        return array;
    }
}
