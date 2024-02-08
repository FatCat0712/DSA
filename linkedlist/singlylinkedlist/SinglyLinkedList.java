package linkedlist.singlylinkedlist;

import java.util.LinkedList;

public class SinglyLinkedList{
    public static Node addFirst(Node head,int value){
        Node newNode = new Node(value);
        if(head != null){
            newNode.next = head;

        }
        return newNode;
    }

    public static Node addLast(Node head,int value){
        Node newNode = new Node(value);
        if(head == null){
            return newNode;
        }
        else{
            //B1. Xac dinh last Node
            Node currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            //B2. Gan next cua currentNode = newNOde
            currentNode.next = newNode;
        }
        return head;
    }

    public static Node addnewNode(Node head, int value,int index){

        if(index == 0){
           return addFirst(head,value);
        }
        else{
            //B1. Tim vi tri can them
            Node newNode = new Node(value);
            Node currentNode = head;
            int count = 0;
            while(currentNode.next != null){
                count++;
                if(count == index){
                    newNode.next = currentNode.next;
                    currentNode.next = newNode;
                }
                currentNode = currentNode.next;
            }
        }
        return head;

    }

    public static Node removeFirst(Node head){
        if(head != null){
            return head.next;
        }
        return head;
    }

    public static Node removeLast(Node head){
        if(head == null)
            return null;
        Node prev = null;
        Node currentNode = head;
        while(currentNode.next != null){
            prev = currentNode;
            currentNode = currentNode.next;
        }
        // trường hợp chỉ có 1 node
        if(prev == null){
            return null;
        }
        else{
            prev.next = currentNode.next;
        }
        return head;
    }

    public static Node removeNode(Node head,int index){
        if(head == null || index < 0)
            return null;
        if(index == 0)
            return removeFirst(head);
        Node prev = null;
        Node currentNode = head;
        int count = 0;
        while (currentNode.next != null){
            prev = currentNode;
            currentNode = currentNode.next;
            count++;
            if(count == index){
                prev.next = currentNode.next;
            }
        }
        // trường hợp currentNode là lastNode
        if(prev == null){
            return null;
        }
        return head;
    }
    public static void printLinkedList(Node head){
        if(head == null){
            System.out.println("Empty list");
        }
        else{

            Node currentNode = head;
            while(currentNode != null){
                System.out.print(currentNode.value);
                currentNode = currentNode.next;
                if(currentNode != null){
                    System.out.print("->");
                }
                else{
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        n1.next = n2;
        n2.next = n3;

        printLinkedList(n1);
        n1 = removeNode(n1,0);
        printLinkedList(n1);
        n1 = removeNode(n1,1);
        printLinkedList(n1);
        n1 = removeNode(n1,0);
        printLinkedList(n1);

    }

}
