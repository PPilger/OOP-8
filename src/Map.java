
public class Map<K, V> {
	private Node root;

	public void put(K key, V value) {
		Node node = getNode(key);

		if (node != null) {
			// alter existing node
			node.value = value;
		} else {
			// insert new node
			Node newNode = new Node(key, value);

			newNode.next = root;
			root = newNode;

			if (newNode.next != null) {
				newNode.next.prev = newNode;
			}
		}
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

		if (node == null) {
			return;
		}

		if (node.prev == null) {
			root = node.next;
		} else {
			node.prev.next = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	public Iterator<V> iterator() {
		return new MapIterator<V>(new ValueGetter<Node, V>() {
			@Override
			public V getValue(Node obj) {
				return obj.value;
			}
		});
	}

	public Iterator<K> keyIterator() {
		return new MapIterator<K>(new ValueGetter<Node, K>() {
			@Override
			public K getValue(Node obj) {
				return obj.key;
			}
		});
	}

	private Iterator<Node> nodeIterator() {
		return new MapIterator<Node>(new ValueGetter<Node, Node>() {
			@Override
			public Node getValue(Node obj) {
				return obj;
			}
		});
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<Node> iter = nodeIterator();

		sb.append("[");

		if (iter.hasNext()) {
			sb.append(iter.next());
		}

		while (iter.hasNext()) {
			sb.append(", ");
			sb.append(iter.next());
		}

		sb.append("]");

		return sb.toString();
	}

	private Node getNode(K key) {
		Iterator<Node> iter = nodeIterator();

		while (iter.hasNext()) {
			Node node = iter.next();

			if (node.key.equals(key)) {
				return node;
			}
		}

		return null; // key not found
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

		@Override
		public String toString() {
			return key + ": " + value;
		}
	}

	private class MapIterator<T> implements Iterator<T> {
		private Node next = root;
		private ValueGetter<Node, T> valGetter;

		private MapIterator(ValueGetter<Node, T> valGetter) {
			this.valGetter = valGetter;
		}

		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public T next() {
			T value = valGetter.getValue(next);
			next = next.next;

			return value;
		}
	}
}
