package hashtable;

public class Node<K,V> {
	private int hash;
	private K key;
	private V value;
	
	public Node(K key, V value) {
		this.hash = key.hashCode();
		this.key = key;
		this.value = value;
	}
	
	public int getHash() {
		return hash;
	}

	public boolean equals(Node<K, V> other) {
		if(other.hash != hash) return false;
		return key.equals(other.key);
	}
	
	@Override
	public String toString() {
		return "key=" + key + ", value=" + value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
	
	
	
	
}
