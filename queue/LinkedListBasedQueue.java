package queue;

import java.util.Iterator;

import linkedlist.DefaultDoublyLinkedList;
import linkedlist.DoublyLinkedList;

public class LinkedListBasedQueue<T> implements QueueADT<T>{
	private final DoublyLinkedList<T> linkedList = new DefaultDoublyLinkedList<>();
	
	public LinkedListBasedQueue() {
		
	}
	
	public LinkedListBasedQueue(T firstElem) {
		enQueue(firstElem);
	}

	@Override
	public Iterator<T> iterator() {
		return linkedList.iterator();
	}

	@Override
	public void enQueue(T element) {
		linkedList.addLast(element);
		
	}

	@Override
	public T deQueue() {
		if(isEmpty()) throw new RuntimeException("Queue empty");
		return linkedList.removeFirst();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new RuntimeException("Queue empty");
		return linkedList.peekFirst();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return linkedList.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return linkedList.size()==0;
	}
	
	
}
