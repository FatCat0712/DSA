package hashtable;

import java.util.Random;

public class Test {
	static final int NUMBER_OF_KEYS = 10000;
	static final int MOD = 100;
	static int[] keys = new int[NUMBER_OF_KEYS];
	static int[] values = new int[NUMBER_OF_KEYS];
	public static void main(String[] args) {
		Random rd = new Random();
		for(int i = 0; i < keys.length; i++) {
			keys[i] = rd.nextInt() % MOD;
			values[i] = rd.nextInt() % MOD;
		}
		testSeperateChaining();
	}
	
	private static void testSeperateChaining() {
		HashTableADT<Integer, Integer> hashTable = new SeperateChainingHashTable<>(MOD);
		long start = System.nanoTime();
		for(int i = 0; i < NUMBER_OF_KEYS; i++) {
			hashTable.insert(keys[i], values[i]);
			int value = hashTable.get(keys[i]);
			if(value != values[i]) System.out.println("Kiem tra lai");
			
		}
		long end = System.nanoTime();
		System.out.println("Seperate Chaining: "+(end - start)/1e9);
		System.out.println(hashTable.toString());
		
		
	}
}
