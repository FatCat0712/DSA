package linkedlist.doublylinkedlist;

import linkedlist.doublylinkedlist.DefaultDoublyLinkedList;
import linkedlist.doublylinkedlist.DoublyLinkedList;

public class test {
	public static void main(String[] args) {
		DoublyLinkedList<String> doublelinkedlist = new DefaultDoublyLinkedList<String>();
		doublelinkedlist.add("h1");
		doublelinkedlist.add("h2");
		doublelinkedlist.add("h3");
		doublelinkedlist.add("h4");
		doublelinkedlist.add("h5");
		System.out.println(doublelinkedlist.toString());
		
		doublelinkedlist.addFirst("first");
		doublelinkedlist.addLast("last");
		System.out.println(doublelinkedlist.toString());
		
		System.out.println(doublelinkedlist.contains("h1"));
		System.out.println(doublelinkedlist.indexOf("h2"));
		
		doublelinkedlist.removeAt(2);
		System.out.println(doublelinkedlist.toString());
		
	}
}
