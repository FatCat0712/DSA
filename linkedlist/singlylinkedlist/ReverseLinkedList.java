package linkedlist.singlylinkedlist;

public class ReverseLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head){
        ListNode currentNode = head;

        while(currentNode != null && currentNode.next != null){
            ListNode nextNode = currentNode.next;
            currentNode.next = nextNode.next;
            nextNode.next = head;
            head = nextNode;
        }
        return head;

    }

    public static void printLinkedList(ListNode head){
        if(head == null){
            System.out.println("Empty list");
        }
        else{
            ListNode currentNode = head;
            while(currentNode != null){
                System.out.print(currentNode.val);
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
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        printLinkedList(a1);
        reverseList(a1);
        printLinkedList(a3);


    }

}
