public class Map<K, V> {
	private Node root;

	public void put(K key, V value) {
		root = new Node(key, value, root);
	}

	public V get(K key) {
		Node node = root;

		while (node != null) {
			if (node.key.equals(key)) {
				return node.value;
			}
			node = node.next;
		}

		return null; // key not found
	}

	public void remove(K key) {
		Node node = root;
		Node prev = null;

		while (node != null) {
			if (node.key.equals(key)) {
				if (prev != null) {
					prev.next = node.next;
				} else {
					root = node.next;
				}
			}

			prev = node;
			node = node.next;
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

		private Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}
