package stack_queue.Queue;

import stack_queue.IStackQueue;

public class MyLinkedListQueue implements IStackQueue {

    public class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    Node headNode, tailNode;
    MyLinkedListQueue(){
        headNode = tailNode = null;
    }
    @Override
    public boolean push(int value) {
        //thêm phần tử vào tailNode <=> thêm phần tử vào cuối linkedlist
        if(!isFull()){
            Node newNode = new Node(value);
            if(isEmpty()){
                tailNode = headNode = newNode;
            }
            tailNode.next = newNode;
            tailNode = newNode;
        }
        return false;
    }

    @Override
    public int pop() {
        if(isEmpty()){
            return -1;
        }
        int value = headNode.value;
        if(headNode == tailNode){
            headNode = tailNode = null;
        }
        else {
            headNode = headNode.next;
        }
        return value;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (headNode == null) && (tailNode == null);
    }

    @Override
    public void show() {
        if(isEmpty()){
            System.out.println("Queue is empty!");
        }
        Node currentNode = headNode;
        while(currentNode != null){
            System.out.print(currentNode.value+" ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
