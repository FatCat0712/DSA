package Sorting;

public class BubbleSort {
    public static void BubbleSort(int[] A){
        for(int i = 0 ; i < A.length -1; i++){
            for(int j = A.length - 1; j > i ; j--){
                if(A[j] < A[j-1]){
                    // swap elements
                    int temp = A[j-1];
                    A[j-1] = A[j];
                    A[j] = temp;
                }
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {8,6,34,22,40,5,11,23,44,18};
        long start = System.currentTimeMillis();
        BubbleSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
