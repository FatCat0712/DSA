package stack_queue.Queue;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.show();

        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.pop());
        queue.show();
        System.out.println(queue.pop());
        queue.show();
    }
}
