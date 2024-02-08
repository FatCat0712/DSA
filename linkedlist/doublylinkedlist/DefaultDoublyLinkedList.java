package linkedlist.doublylinkedlist;


import java.util.Iterator;

public class DefaultDoublyLinkedList<T> implements DoublyLinkedList<T> {
	private int size;
	private Node<T> head = null;
	private Node<T> tail = null;
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<>() {
			
			private boolean isEntering = true;
			private Node<T> currentNode = null;
			@Override
			public boolean hasNext() {
				if(isEntering) {
					return head != null;
				}
				// TODO Auto-generated method stub
				return currentNode.getNext() != null;
			}

			@Override
			public T next() {
				T data = null;
				if(isEntering) {
					data = head.getData();
					currentNode = head;
					isEntering = false;
				}
				else {
					currentNode = currentNode.getNext();
					data = currentNode.getData();
				}
				
				
				return data;
			}
		};
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node<T> currentNode = head;
		while(currentNode != null) {
			Node<T> nextNode = currentNode.getNext();
			currentNode.setNext(null);
			currentNode.setPrev(null);
			currentNode.setData(null);
			currentNode = nextNode;
		}
		head = tail = null;
		size = 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}

	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		addLast(element);
		
	}

	@Override
	public void addFirst(T element) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = tail = new Node<>(element, null, null);
		}
		else {
			Node<T> newNode = new Node<>(element,null,head);
			head.setPrev(newNode);
			head = head.getPrev();
		}
		size++;
	}

	@Override
	public void addLast(T element) {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			head = tail = new Node<>(element, null, null);
		}
		else {
			Node<T> newNode = new Node<>(element, tail, null);
			tail.setNext(newNode);
			tail = tail.getNext();
		}
		size++;
	}

	@Override
	public T peekFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new RuntimeException("Empty Linked list");
		return head.getData();
	}

	@Override
	public T peekLast() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new RuntimeException("Empty Linked list");
		return tail.getData();
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new RuntimeException("Empty linked list");
		T data = head.getData();
		head = head.getNext();
		size--;
		if(isEmpty()) tail = null;
		else head.setPrev(null);
		
		return data;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		if(isEmpty()) throw new RuntimeException("Empty linked list");
		T data = tail.getData();
		tail = tail.getPrev();
		size--;
		if(isEmpty()) head = null;
		else tail.setNext(null);
		
		return data;
	}

	@Override
	public T remove(Node<T> node) {
		// TODO Auto-generated method stub
		if(node.getPrev() == null) removeFirst();
		if(node.getNext() == null) removeLast();
		
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		
		T data = node.getData();
		size--;
		
		node.setData(null);
		node.setNext(null);
		node.setPrev(null);
		node = null;
		
		return data;
	}

	@Override
	public boolean remove(Object object) {
		// TODO Auto-generated method stub
		Node<T> currentNode = head;
		if(object == null) {
			while(currentNode != null) {
				if(currentNode.getData() == null) {
					remove(currentNode);
					return true;
				}
				currentNode = currentNode.getNext();
			}
		}
		else {
			while(currentNode != null) {
				if(currentNode.getData() == object) {
					remove(currentNode);
					return true;
				}
				currentNode = currentNode.getNext();
			}
		}
		return false;
		
	}

	@Override
	public T removeAt(int index) {
		// TODO Auto-generated method stub
		if(index < 0 || index >= size) throw new IllegalArgumentException();
		int i;
		Node<T> currentNode;
		if(index < size/2) {
			i = 0;
			currentNode = head;
			while(i != index) {
				currentNode = currentNode.getNext();
				i++;
			}
			
		}
		else {
			i = size - 1;
			currentNode = tail;
			while(i != index) {
				currentNode = currentNode.getPrev();
				i--;
			}
		}
		
		return remove(currentNode);
	}

	@Override
	public int indexOf(Object object) {
		// TODO Auto-generated method stub
		int index = 0;
		Node<T> currentNode = head;
		if(object == null) {
			while(currentNode != null) {
				if(currentNode.getData() == null) {
					return index;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
		else {
			while(currentNode != null) {
				if(currentNode.getData() == object){
					return index;
				}
				currentNode = currentNode.getNext();
				index++;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(Object object) {
		// TODO Auto-generated method stub
		return indexOf(object) != -1;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(isEmpty()) return "[]";
		else {
			StringBuilder sb = new StringBuilder(size);
			sb.append("[");
			
			Node<T> currentNode = head;
			while(currentNode != null) {
				sb.append(currentNode.getData());
				if(currentNode.getNext() != null) sb.append(",");
				currentNode = currentNode.getNext();
			}
			
			sb.append("]");
			return sb.toString();
		}
		
	}
	
	

}
