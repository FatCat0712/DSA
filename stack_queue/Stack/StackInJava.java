package stack_queue.Stack;

import java.util.Stack;

public class StackInJava {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        for(Integer i: myStack){
            System.out.println(i);
        }

        System.out.println("Peek: "+ myStack.peek());
        System.out.println("Pop: "+ myStack.pop());
        System.out.println("Peek: "+ myStack.pop());

        System.out.println("isEmpty: "+myStack.isEmpty());
    }
}
