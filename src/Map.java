public class Map<K, V> {
	private Node root;

	public void put(K key, V value) {
		Node newNode = new Node(key, value);

		newNode.next = root;
		root = newNode;
	}

	private Node getNode(K key) {
		Node node = root;

		while (node != null) {
			if (node.key.equals(key)) {
				return node;
			}
			node = node.next;
		}

		return null; // key not found
	}

	public V get(K key) {
		Node node = getNode(key);

		if (node != null) {
			return node.value;
		} else {
			return null;
		}
	}

	public void remove(K key) {
		Node node = getNode(key);
		
		if(node == null) {
			return;
		}
		
		if(node.prev == null) {
			root = node.next;
		} else {
			node.prev.next = node.next;
		}
		
		if(node.next != null) {
			node.next.prev = node.prev;
		}
	}

	public Iterator<V> iterator() {
		return iterator(new Filter<V>() {
			@Override
			public boolean accept(V element) {
				return true;
			}
		});
	}

	public Iterator<V> iterator(final Filter<V> filter) {
		return new Iterator<V>() {
			Node next = root;

			@Override
			public boolean hasNext() {
				return next != null;
			}

			@Override
			public V next() {
				V value = next.value;

				while (next != null && !filter.accept(next.value)) {
					next = next.next;
				}

				return value;
			}
		};
	}

	private class Node {
		private K key;
		private V value;
		private Node next;
		private Node prev;

		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
