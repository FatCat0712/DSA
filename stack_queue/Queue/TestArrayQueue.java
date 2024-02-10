package stack_queue.Queue;

import stack_queue.Stack.MyArrayStack;

public class TestArrayQueue {
    public static void main(String[] args) {
        MyArrayQueue myQueue = new MyArrayQueue(3);
        System.out.println( myQueue.push(1));
        System.out.println(myQueue.count());
        System.out.println(myQueue.push(2));
        System.out.println(myQueue.count());
        System.out.println(myQueue.push(3));
        System.out.println(myQueue.count());
        System.out.println(myQueue.push(4));
        System.out.println(myQueue.count());
        myQueue.show();

        System.out.println(myQueue.pop());
        System.out.println(myQueue.count());
        myQueue.show();
        System.out.println(myQueue.pop());
        System.out.println(myQueue.count());
        myQueue.show();
        System.out.println(myQueue.pop());
        System.out.println(myQueue.count());
        myQueue.show();
        System.out.println(myQueue.pop());
        System.out.println(myQueue.count());
        myQueue.show();

    }
}
