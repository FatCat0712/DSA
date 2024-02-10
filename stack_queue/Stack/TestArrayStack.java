package stack_queue.Stack;

import stack_queue.Stack.MyArrayStack;

public class TestArrayStack {
    public static void main(String[] args) {
        MyArrayStack myStack = new MyArrayStack(3);
        System.out.println(myStack.push(1));
        System.out.println(myStack.push(2));
        System.out.println(myStack.push(3));
        System.out.println(myStack.push(4));
        myStack.show();

        System.out.println(myStack.pop());
        myStack.show();
        System.out.println(myStack.pop());
        myStack.show();
        System.out.println(myStack.pop());
        myStack.show();
        System.out.println(myStack.pop());
    }
}
