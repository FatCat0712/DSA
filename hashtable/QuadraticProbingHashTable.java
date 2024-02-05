package hashtable;

public class QuadraticProbingHashTable<K,V> extends OpenAddressingHashTableBase<K, V>{
	
	public QuadraticProbingHashTable() {
		super();
	}

	public QuadraticProbingHashTable(double loadFactor, int capacity) {
		super(loadFactor, capacity);
	}

	public QuadraticProbingHashTable(int capacity) {
		super(capacity);
	}
	
	private static int nextPowerOfTwo(int n) {
		// lay so co luy thua hai lon nhat nhung thap hon so n : highestOneBit
		return Integer.highestOneBit(n) << 1;
	}
	
	@Override
	protected void setupProbing(K key) {
		
	}

	@Override
	protected int probe(int x) {
		//(x^2 + x)/2 => size: 2^x
		return (x * x + x) >> 1 ;
	}
	
	@Override
	protected void increaseCapacity() {
		capacity = nextPowerOfTwo(capacity);
	}

	@Override
	protected void adjustCapacity() {
		int po2 = Integer.highestOneBit(capacity);
		if(capacity == po2) return;
		increaseCapacity();
		
	}
	

}
