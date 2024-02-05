package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void SelectionSort(int [] arr){
        int i,j, min,t;
        for(i = 0; i < arr.length - 1;i++){
            min = i;
            for(j = i + 1; j < arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            if(min != i){
                t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
            }
        }
    }
    public static void main(String[] args) {
       int[] arr = {8,6,34,22,40,5,11,23,44,18};
       SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
