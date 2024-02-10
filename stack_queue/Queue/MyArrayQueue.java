package stack_queue.Queue;

import stack_queue.IStackQueue;

public class MyArrayQueue implements IStackQueue {

    private int[] arr;
    private int SIZE;
    private int headIndex;
    private int tailIndex;

    MyArrayQueue(int size){
        SIZE = size;
        arr = new int[SIZE];
        headIndex = tailIndex = -1;
    }
    @Override
    public boolean push(int value) {
        if(!isFull()){
            if(isEmpty()){
                headIndex++;
            }
            tailIndex++;
            arr[tailIndex] = value;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        int value = -1;
        if(!isEmpty()){
            value = arr[headIndex];
            headIndex++;
            if(headIndex > tailIndex){
                headIndex = tailIndex = -1;
            }
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return tailIndex == SIZE - 1;
    }

    @Override
    public boolean isEmpty() {
        return (headIndex == -1) && (tailIndex == -1);
    }

    public int count(){
        if(isEmpty())
            return 0;
        else
            return tailIndex - headIndex + 1;
    }
    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else{
            for(int i = headIndex; i <= tailIndex; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
    }
}
