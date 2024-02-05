package hashtable;



public class LinearProbingHashTable<K,V> extends OpenAddressingHashTableBase<K, V> {

	private static final int LINEAR_CONSTANT = 13;
	public LinearProbingHashTable() {
		super();
	}

	public LinearProbingHashTable(double loadFactor, int capacity) {
		super(loadFactor, capacity);
	}

	public LinearProbingHashTable(int capacity) {
		super(capacity);
	}

	@Override
	protected void setupProbing(K key) {
		
		
	}

	@Override
	protected int probe(int x) {
		
		return x * LINEAR_CONSTANT;
	}

	@Override
	protected void adjustCapacity() {
		if(gcd(LINEAR_CONSTANT,capacity) != 1) return;
		increaseCapacity();
		
		
	}

	

}
