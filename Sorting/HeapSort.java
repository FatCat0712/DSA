package Sorting;

import java.util.Scanner;

public class HeapSort {
    public static class MinHeap{
        private static int MAX_SIZE = 100000;
        private int[] arr = new int[MAX_SIZE + 1];
        private int size;

        MinHeap(){
            size = 0;
        }

        public boolean isEmpty(){
            return size <= 0;
        }

        public int peek(){
            if(isEmpty()){
                //Throw exceptions
                System.out.println("Error: Heap is empty");
                return -1;
            }
            return arr[1];
        }

        public void swap(int i, int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        public void add(int v){
            size++;
            arr[size] = v;
            //heapify up
            int currIndex = size;
            int parentIndex = currIndex / 2;
            while(parentIndex != 0 && arr[parentIndex] > arr[currIndex]){
                // doi cho
                swap(parentIndex,currIndex);
                currIndex = parentIndex;
                parentIndex = currIndex / 2;
            }
        }

        public int poll(){
            if(isEmpty()){
                System.out.println("Error: Heap is empty");
                return -1;
            }
            int min = arr[1];


            arr[1] = arr[size];
            size--;

            heapifyDown(1);


            return min;
        }

        private void heapifyDown(int currIndex) {
            //heapify down
            while((2 * currIndex) <= size ){
                int leftChild = currIndex * 2;
                int rightChild = leftChild + 1;
                int smallerChildIndex = leftChild;

                if(rightChild <= size && arr[rightChild] < arr[leftChild] ){
                    smallerChildIndex = rightChild;
                }

                if(arr[currIndex] > arr[smallerChildIndex]){
                    swap(currIndex,smallerChildIndex);
                    currIndex = smallerChildIndex;

                }
                else{
                    // OK => Good!
                    break;
                }
            }
        }

        public void remove(int v){
            int currIndex = -1;
            for(int i = 1; i <= size; i++){
                if(arr[i] == v) {
                    currIndex = i;
                    break;
                }

            }
            if(currIndex == -1) {
                System.out.println("Error: Element not found");
                return;
            }
            arr[currIndex] = arr[size];
            size--;
            //heapify
            heapifyDown(currIndex);

        }
    }
    public static void main(String[] args) {
        MinHeap myHeap = new MinHeap();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        do{
            int r = sc.nextInt();
            if(r == 1){
                int v = sc.nextInt();
                myHeap.add(v);

            }
            else if(r == 2){
                int v = sc.nextInt();
                myHeap.remove(v);

            }
            else if(r == 3){
                System.out.println(myHeap.peek());

            }
            q--;
        }
        while (q > 0);
    }


}
