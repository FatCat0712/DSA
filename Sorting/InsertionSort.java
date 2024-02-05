package Sorting;

public class InsertionSort {
    public static void InsertionSort(int[] a){
        int j,temp;
        for(int i = 1; i < a.length;i++){
            j = i -1;
            temp = a[i];

            while(temp < a[j] && j >= 1){
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,6,34,22,40,5,11,23,44,18};
        long start = System.currentTimeMillis();
        InsertionSort(arr);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
