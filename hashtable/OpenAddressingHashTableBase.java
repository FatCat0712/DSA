package hashtable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class OpenAddressingHashTableBase<K,V> implements HashTableADT<K, V> {
	protected double loadFactor;
	protected int capacity, threshold;
	
	protected int usedSlots, keyCount;
	
	protected K[] keys;
	protected V[] values;
	
	protected final K TOMBSTONE = (K) new Object();
	
	protected static final int DEFAULT_CAPACITY = 7;
	protected static final double DEFAULT_LOADFACTOR = 0.6;
	
	public OpenAddressingHashTableBase() {
		this(DEFAULT_LOADFACTOR,DEFAULT_CAPACITY);
	}

	public OpenAddressingHashTableBase(int capacity) {
		this(DEFAULT_CAPACITY ,capacity);
	}

	public OpenAddressingHashTableBase(double loadFactor, int capacity) {
		if(capacity < 0) throw new IllegalArgumentException("Capacity phai lon hon 0");
		if(loadFactor <= 0 || Double.isNaN(loadFactor) || Double.isInfinite(loadFactor)) {
			throw new IllegalArgumentException("Load factor phai lon hon 0");
		}
		this.loadFactor = loadFactor;
		this.capacity = Math.max(DEFAULT_CAPACITY, capacity);
		adjustCapacity();
		this.threshold = (int) (this.capacity * loadFactor);
		
		keys = (K[]) new Object[this.capacity];
		values = (V[]) new Object[this.capacity];
		
	}
	
	protected abstract void setupProbing(K key);
	
	protected abstract int probe(int x);
	
	protected abstract void adjustCapacity();
	
	protected void increaseCapacity() {
		capacity *= 2;
	}

	@Override
	public Iterator<K> iterator() {
		return new Iterator<>() {
			int index, keyLeft = keyCount;

			@Override
			public boolean hasNext() {
				
				return keyLeft != 0;
			}

			@Override
			public K next() {
				while(keys[index] == null || keys[index] == TOMBSTONE) index++;
				keyLeft--;
				return keys[index++];
			}
		};
		
		
	}

	@Override
	public int size() {
		return keyCount;
	}

	@Override
	public boolean isEmpty() {
		return keyCount == 0;
	}
	public int capacity() {
		return capacity;
	}
	@Override
	public int hashCodeToIndex(int hashedKey) {
		return (int) ((hashedKey & 0xFFFFFFFFFL) % capacity);
	}
	
	public List<K> keys(){
		List<K> hashTableKeys = new ArrayList<>(size());
		for(int i = 0; i < capacity; i++) {
			// key null or TOMBSTONE thi skip
			if(keys[i] != null && keys[i] != TOMBSTONE) hashTableKeys.add(keys[i]);	
		}
		return hashTableKeys;
	}
	
	public List<V> values(){
		List<V> hashTableValues = new ArrayList<>(size());
		for(int i = 0; i < capacity; i++) {
			if(keys[i] != null && keys[i] != TOMBSTONE) hashTableValues.add(values[i]);
		}
		return hashTableValues;
		
	}
	
	protected void resizeTable() {
		increaseCapacity();
		adjustCapacity();
		
		threshold = (int) (capacity * loadFactor);
		
		//create new table
		K[] oldKeys = (K[]) new Object[capacity];
		V[] oldValues = (V[]) new Object[capacity];
		
		//swap keys pointer
		K[] tempKeys = keys;
		keys = oldKeys;
		oldKeys = tempKeys;
		
		//swap values pointer
		V[] tempValues = values;
		values = oldValues;
		oldValues = tempValues;
		
		usedSlots = keyCount = 0;
		
		// Insert old key-value to new table
		for(int i = 0; i < oldKeys.length; i++) {
			if(oldKeys[i] != null && oldKeys != TOMBSTONE) {
				insert(oldKeys[i],oldValues[i]);
			}
			oldKeys[i] = null;
			oldValues[i] = null;
		}
		
	}
	
	protected static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
		
	}
	@Override
	public void clear() {
		for(int i = 0; i < capacity; i++) {
			keys[i] = null;
			values[i] = null;
		}
		usedSlots = keyCount = 0;
		
	}

	@Override
	public boolean has(K key) {
		if(key == null) throw new IllegalArgumentException("null key");
		
		setupProbing(key);
		final int offset = hashCodeToIndex(key.hashCode());
		
		for(int i = offset,x = 1,firstTombstoneIndex = -1;;i = hashCodeToIndex(offset+probe(x++))) {
			if(keys[i] == TOMBSTONE) {
				if(firstTombstoneIndex == -1) {
					firstTombstoneIndex = i;
				}
			}
			else if(keys[i] != null) {
				if(keys[i].equals(key)) {
					if(firstTombstoneIndex != -1) {
						keys[firstTombstoneIndex] = key;
						values[firstTombstoneIndex] = values[i];
						keys[i] = TOMBSTONE;
						values[i] = null;
					}
					return true;
				}
			}
			else return false;
			
		}
	}

	@Override
	public V insert(K key, V value) {
		if(key == null) throw new IllegalArgumentException("Null key");
		if(usedSlots >= threshold) resizeTable();
		setupProbing(key);
		
		final int offset = hashCodeToIndex(key.hashCode());
		for(int i = offset,x = 1,firstTombstoneIndex = -1;;i = hashCodeToIndex(offset+probe(x++))) {
			if(keys[i] == TOMBSTONE) {
				if(firstTombstoneIndex == -1) {
					firstTombstoneIndex = i;
				}
			}
			else if(keys[i] != null) {
				if(keys[i].equals(key)) {
					V oldValue = values[i];
					if(firstTombstoneIndex == -1) {
						values[i] = value;
					}
					else{
						keys[firstTombstoneIndex] = key;
						values[firstTombstoneIndex] = value;
						keys[i] = TOMBSTONE;
						values[i] = null;
					}
					return oldValue;
				}
			}
			else {
				if(firstTombstoneIndex == -1) {
					usedSlots++;
					keyCount++;
					keys[i] = key;
					values[i] = value;
				}
				else {
					keyCount++;
					keys[firstTombstoneIndex] = key;
					values[firstTombstoneIndex] = value;
				}
				return null;
			}
		}
	}

	@Override
	public V get(K key) {
		if(key == null) throw new IllegalArgumentException("null key");		
		setupProbing(key);
		final int offset = hashCodeToIndex(key.hashCode());
		
		for(int i = offset,x = 1,firstTombstoneIndex = -1;;i = hashCodeToIndex(offset+probe(x++))) {
			if(keys[i] == TOMBSTONE) {
				if(firstTombstoneIndex == -1) {
					firstTombstoneIndex = i;
				}
			}
			else if(keys[i] != null) {
				if(keys[i].equals(key)) {
					V value = values[i];
					if(firstTombstoneIndex != -1) {
						keys[firstTombstoneIndex] = key;
						values[firstTombstoneIndex] = values[i];
						keys[i] = TOMBSTONE;
						values[i] = null;
					}
					return value;
				}
			}
			else return null;
			
		}
		
	}

	@Override
	public V remove(K key) {
		if(key == null) throw new IllegalArgumentException("null key");		
		setupProbing(key);
		final int offset = hashCodeToIndex(key.hashCode());
		for(int i = offset,x = 1;;i = hashCodeToIndex(offset+probe(x++))) {
			if(keys[i] == TOMBSTONE) continue;
			
			if(keys[i] == null) return null;
			
			if(keys[i] == key) {
				keyCount--;
				V oldValue = values[i];
				keys[i] = TOMBSTONE;
				values[i] = null;
				return oldValue;
			}
		}
		
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		for(int i = 0; i < capacity; i++) {
			if(keys[i] != null && keys[i] != TOMBSTONE) sb.append(keys[i]+"->"+values[i]+", ");	
		}
		sb.append("}");
		return sb.toString();
	}
	
	

}
