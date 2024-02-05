package queue;

public class test {
	public static void main(String[] args) {
		int numberOfOperations = 10000000;
		//Array based queue
		QueueADT<Integer> circularArrayBasedQueue = new CircularArrayBasedQueue<Integer>(numberOfOperations);
		
		long startTime = System.nanoTime();
		for(int i = 0; i < numberOfOperations; i++) {
			circularArrayBasedQueue.enQueue(i);
		}
		for(int i = 0; i < numberOfOperations/2; i++) {
			circularArrayBasedQueue.deQueue();
		}
		for(int i = 0; i < numberOfOperations/4; i++) {
			circularArrayBasedQueue.enQueue(i);
		}
		for(int i = 0; i < 3*numberOfOperations/4; i++) {
			circularArrayBasedQueue.deQueue();
		}
		long endTime = System.nanoTime();
		long arrayTime = endTime - startTime;
		System.out.println("Circular array based queue took: "+ arrayTime);
		
		//linked list based queue
		QueueADT<Integer> linkedlistBasedQUeue = new LinkedListBasedQueue<>();
		startTime = System.nanoTime();
		for(int i = 0; i < numberOfOperations; i++) {
			linkedlistBasedQUeue.enQueue(i);
		}
		for(int i = 0; i < numberOfOperations; i++) {
			linkedlistBasedQUeue.deQueue();
		}
		endTime = System.nanoTime();
		long linkedList = endTime -startTime;
		System.out.println("Linked list based queue took: "+linkedList+"\n");
		System.out.println("The difference: "+(linkedList - arrayTime)+"\n");
	}
}
