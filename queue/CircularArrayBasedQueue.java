package queue;

import java.util.Iterator;

import javax.management.RuntimeErrorException;

public class CircularArrayBasedQueue<T> implements QueueADT<T>{
	private final T[] array;
	private int front;
	private int rear;
	private final int size;
	
	public CircularArrayBasedQueue(int maxSize) {
		front = rear = 0;
		size = maxSize + 1;
		array = (T[]) new Object[size];
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	@Override
	public void enQueue(T element) {
		array[rear] = element;
		if(++rear== size) rear = 0;
		if(rear == front) throw new RuntimeException("Queue is full");
		
	}

	@Override
	public T deQueue() {
		if(isEmpty()) throw new RuntimeException("Queue empty");
		T deQueueElem = array[front];
		if(++front == size) front = 0;
		return deQueueElem;
	}

	@Override
	public T peek() {
		if(isEmpty()) throw new RuntimeException("Queue empty");
		return array[front];
	}

	@Override
	public int size() {
		if(front > rear) return (rear - front + size);
		return rear - front;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	
	
}
