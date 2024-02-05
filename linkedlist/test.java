package linkedlist;

public class test {
	public static void main(String[] args) {
		linkedlist.DoublyLinkedList<String> doublelinkedlist = new DefaultDoublyLinkedList<String>();
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
