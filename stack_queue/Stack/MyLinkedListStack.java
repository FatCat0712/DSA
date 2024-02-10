package stack_queue.Stack;

import stack_queue.IStackQueue;

import java.util.ArrayList;

public class MyLinkedListStack implements IStackQueue {

    private class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    Node topNode;
    MyLinkedListStack(){
        topNode = null;
    }

    @Override
    public boolean push(int value) {
        // Thêm một phần tử vào đầu của linked list
        if(!isFull()){
            Node newNode = new Node(value);
            newNode.next = topNode;
            topNode = newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(isEmpty())
            return -1;
        int value = topNode.value;
        topNode = topNode.next;
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return;
        }
        ArrayList<Integer> tempList = new ArrayList<>();
        Node temp = topNode;
        while (temp != null){
            //System.out.println(temp.value+" ");
            tempList.add(temp.value);
            temp = temp.next;
        }

        for(int i = tempList.size() - 1 ; i >= 0 ; i--){
            System.out.print(tempList.get(i)+" ");
        }
        System.out.println();
    }
}
