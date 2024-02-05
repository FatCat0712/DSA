package hashtable;

import java.util.Random;

public class TestOpenAddressing {
	static final int NUMBER_OF_KEYS = 100000000;
	static final int MOD = 100000;
	static int[] keys = new int[NUMBER_OF_KEYS];
	static int[] values = new int[NUMBER_OF_KEYS];
	public static void main(String[] args) {
		Random rd = new Random();
		for(int i = 0; i < keys.length; i++) {
			keys[i] = rd.nextInt() % MOD;
			values[i] = rd.nextInt() % MOD;
		}
		testLinearProbing();
		testQuadraticProbing();
		
		
	}
	
	private static void testLinearProbing() {
		HashTableADT<Integer, Integer> hashTable = new LinearProbingHashTable<>();
		long start = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_KEYS; i++) {
			hashTable.insert(keys[i], values[i]);
			int value = hashTable.get(keys[i]);
			if(value != values[i]) System.out.println("Kiem tra lai");
			
		}
		long end = System.nanoTime();
		System.out.println("Linear Probing Table: "+(end - start)/1e9);
		
	}
	
	private static void testQuadraticProbing() {
		HashTableADT<Integer, Integer> hashTable = new QuadraticProbingHashTable<Integer, Integer>();
		long start = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_KEYS; i++) {
			hashTable.insert(keys[i], values[i]);
			int value = hashTable.get(keys[i]);
			if(value != values[i]) System.out.println("Kiem tra lai");
			
		}
		long end = System.nanoTime();
		System.out.println("Quadratic Probing Table: "+(end - start)/1e9);
		
	}
	
}
