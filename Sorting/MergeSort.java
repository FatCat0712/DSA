package Sorting;

import java.util.Arrays;

public class MergeSort {
    public int[] merge(int[] leftArray, int[] rightArray){
        // Tron Vao leftArray va rightArray la cac mang da duoc sap xep
        int n = leftArray.length + rightArray.length;
        int[] result = new int[n];
        int mergeIndex = 0, leftIndex = 0, rightIndex = 0;
        while(mergeIndex < n){
            if(leftIndex < leftArray.length && rightIndex < rightArray.length){
                // leftArray va rightArray khac rong
                if(leftArray[leftIndex] <= rightArray[rightIndex]){
                    // neu phan tu mang trai nho hon phan tu mang phai
                    result[mergeIndex] = leftArray[leftIndex];
                    leftIndex++;
                    mergeIndex++;
                }
                else{
                    // neu phan tu mang phai nho hon phan tu mang trai
                    result[mergeIndex] = rightArray[rightIndex];
                    rightIndex++;
                    mergeIndex++;
                }

            }
            else{ // mang trai rong hoac mang phai rong
                if(leftIndex < leftArray.length){
                    // mang phai rong
                    result[mergeIndex] = leftArray[leftIndex];
                    leftIndex++;
                    mergeIndex++;
                }
                else{
                    // mang trai rong
                    result[mergeIndex] = rightArray[rightIndex];
                    rightIndex++;
                    mergeIndex++;
                }
            }
        }
        return  result;
    }
    public int[] mergeSort(int a[], int L, int R){
        // tim dieu kien dung
        if(L > R) return new int[0];
        if(L == R){
            int[] singElement = {a[L]};
            return singElement;
        }
        // Truong hop tong quat

        //Chia ra
        //System.out.println("Chia: "+ L + " - " + R);
        int k = (L+R)/2;
        int[] leftArray = mergeSort(a,L,k);
        int[] rightArray = mergeSort(a,k+1,R);

        // tron vao
        int[] result =  merge(leftArray,rightArray);
        //System.out.println("Ket qua Merge: "+Arrays.toString(result));
        return result;
    }
    public int[] sortArray(int[] nums){
        return mergeSort(nums,0,nums.length -1);
    }

    public static void main(String[] args) {
        MergeSort s = new MergeSort();
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        int[] c = {1,5,3,2,8,7,6,4};
        System.out.println(Arrays.toString(s.mergeSort(c,0,c.length-1)));
    }
}
