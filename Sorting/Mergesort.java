package Sorting;

public class Mergesort {
    public static int[] mergesort(int[] array){
        int length = array.length;
        if(length <=1){
            return array;
        }
        int half = (int)length/2;
        int[] left = new int[half];
        int[] right= new int[length-half];
        
        System.arraycopy(array,0,left,0,left.length);
        System.arraycopy(array,left.length,right,0,right.length);

        left = mergesort(left);
        right = mergesort(right);
        
        return merge(left,right);
    }
    public static int[] merge(int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        
        int curLeft = 0,curRight = 0,curResult = 0;
        while(curResult < result.length){
            if(left.length == 0 || curLeft==left.length){
                System.arraycopy(right,curRight,result,curResult,right.length-curRight);
                break;
            }
            else if(right.length == 0|| curRight==right.length){
                System.arraycopy(left,curLeft,result,curResult,left.length-curLeft);
                break;
            }
            else{
                if(right[curRight] < left[curLeft]){
                    result[curResult] = right[curRight];
                    curRight++;
                    curResult++;
                }
                else{
                    result[curResult] = left[curLeft];
                    curLeft++;
                    curResult++;
                }
            }
        }
        return result;
    }
}
