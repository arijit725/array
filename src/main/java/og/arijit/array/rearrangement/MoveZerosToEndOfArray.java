package og.arijit.array.rearrangement;

import java.util.Arrays;

public class MoveZerosToEndOfArray {

    public static void main(String args[]){
        int arr[]  = {1, 2, 0, 4, 3, 0, 5, 0};
        move(arr);
        System.out.println("After Moving: "+Arrays.toString(arr));
    }

    public static void move(int array[]){
        int start = 0;
        int end = array.length-1;
        while(start<end){
            while(start<array.length && array[start]!=0){
                start++;
            }
            while(end>=0 && array[end]==0){
                end--;
            }
            if(start<=end){
                int tmp = array[start];
                array[start++] = array[end];
                array[end--] = tmp;
            }
        }
    }
}
