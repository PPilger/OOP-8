public class Map<K, V> {
	private Node root;

	public void put(K key, V value) {
		root = new Node(key, value, root);
	}

	public V get(K key) {
		Node node = root;

		while (node != null && !node.key.equals(key)) {
			node = node.next;
		}
		
		//node is the searched node

		if (node != null) {
			return node.value;
		} else {
			return null;
		}
	}

	public void remove(K key) {
		Node node = root;
		Node prev = null;

		while (node != null && !node.key.equals(key)) {
			prev = node;
			node = node.next;
		}
		
		//node is the deletion-target
		
		if(node != null) {
			node = node.next;
		}
		
		//node is the node after the deletion-target

		if (prev != null) {
			prev.next = node;
		} else {
			root = node;
		}
	}
	
	public Iterator<V> iterator(Filter<V> filter) {
		return new Iterator<V>() {

			@Override
			public boolean hasNext() {
				return false;
			}

			@Override
			public V next() {
				return null;
			}
		};
	}

	private class Node {
		private K key;
		private V value;
		private Node next;

		private Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
