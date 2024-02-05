package Sorting;

public class QuickSort {
    public static int Partition(int A[], int left,int right){
        int X = A[left];
        int i = left + 1;
        int j = right;
        int temp;
        do{
            while((i <= j ) && (A[i] <= X))
                i++;
            while((i <= j) && (A[j] > X))
                j--;
            if(i < j){
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }while(i <= j);
        temp = A[left];
        A[left] = A[j];
        A[j] = temp;

        return j;

    }
    public static void QuickSort(int A[], int left, int right){
        int k;
        if(left < right){
            k = Partition(A,left,right);

            QuickSort(A,left,k-1);
            QuickSort(A,k+1,right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,6,34,22,40,5,11,23,44,18};
        long start = System.currentTimeMillis();
        QuickSort(arr,0, arr.length-1);
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000);
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}

