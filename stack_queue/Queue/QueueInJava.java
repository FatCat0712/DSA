package stack_queue.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInJava {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);

        for(Integer i: myQueue){
            System.out.println(i);
        }

        System.out.println("isEmpty: " + myQueue.isEmpty());

        System.out.println("Peek: "+myQueue.peek());
        System.out.println("Remove: "+myQueue.remove());
        System.out.println("Peek: "+myQueue.peek());
        System.out.println("Remove: "+myQueue.remove());
        System.out.println("Peek: "+myQueue.peek());
        System.out.println("Remove: "+myQueue.remove());

        System.out.println("isEmpty" + myQueue.isEmpty());

    }
}
