package stack_queue.Stack;

public class TestLinkedListStack {
    public static void main(String[] args) {
        MyLinkedListStack stack = new MyLinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.show();

        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();
        System.out.println(stack.pop());
        stack.show();

    }
}
