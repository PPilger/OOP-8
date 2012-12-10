@Author("Peter Pilgerstorfer")
/*
 * A map which offers iterators (that return values and keys of the map),
 * folding (retrieves multiple sets out of this map, each set contains a
 * numerical result depending on the charasteristics of the values in this map)
 * zip (combines this map with another one, keys will be a union of both maps
 * although the mapped values will be combined and shall be different if the
 * same key exists in both maps)
 */
public class Map<K, V> {
	private Node root;

	@Author("Peter Pilgerstorfer")
	public Map() {
	}

	@Author("Peter Pilgerstorfer")
	public Map(Map<K, V> map) {
		Iterator<Node> iter = nodeIterator();

		while (iter.hasNext()) {
			Node node = iter.next();
			put(node.key, node.value);
		}
	}

	@Author("Peter Pilgerstorfer")
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

	@Author("Peter Pilgerstorfer")
	public V get(K key) {
		Node node = getNode(key);

		if (node != null) {
			return node.value;
		} else {
			return null;
		}
	}

	@Author("Peter Pilgerstorfer")
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

	@Author("Peter Pilgerstorfer")
	public <T, R> Map<T, R> fold(Distributor<V, T, R> aggregator) {
		Iterator<V> it = iterator();

		while (it.hasNext()) {
			V element = it.next();
			aggregator.add(element);
		}

		return aggregator.getDistribution();
	}

	@Author("Peter Pilgerstorfer")
	public <V2, R> Map<K, R> zip(Map<K, V2> other, Combinator<V, V2, R> comb) {
		Map<K, R> combined = new Map<K, R>();

		Iterator<K> iter = keyIterator();
		while (iter.hasNext()) {
			K key = iter.next();
			R result = comb.combine(get(key), other.get(key));
			combined.put(key, result);
		}

		return combined;
	}

	@Author("Peter Pilgerstorfer")
	public Iterator<V> iterator() {
		return new MapIterator<V>(new ValueGetter<Node, V>() {
			@Override
			public V getValue(Node obj) {
				return obj.value;
			}
		});
	}

	@Author("Peter Pilgerstorfer")
	public Iterator<K> keyIterator() {
		return new MapIterator<K>(new ValueGetter<Node, K>() {
			@Override
			public K getValue(Node obj) {
				return obj.key;
			}
		});
	}

	@Author("Peter Pilgerstorfer")
	private Iterator<Node> nodeIterator() {
		return new MapIterator<Node>(new ValueGetter<Node, Node>() {
			@Override
			public Node getValue(Node obj) {
				return obj;
			}
		});
	}

	@Author("Peter Pilgerstorfer")
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

	@Author("Peter Pilgerstorfer")
	private Node getNode(K key) {
		Iterator<Node> iter = nodeIterator();

		while (iter.hasNext()) {
			Node node = iter.next();

			if (node.key == key) {
				return node;
			}
			if (node.key != null && node.key.equals(key)) {
				return node;
			}
		}

		return null; // key not found
	}

	@Author("Peter Pilgerstorfer")
	private class Node {
		private K key;
		private V value;
		private Node next;
		private Node prev;

		@Author("Peter Pilgerstorfer")
		private Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		@Author("Peter Pilgerstorfer")
		public String toString() {
			return key + ": " + value;
		}
	}

	@Author("Peter Pilgerstorfer")
	private class MapIterator<T> implements Iterator<T> {
		private Node next = root;
		private ValueGetter<Node, T> valGetter;

		@Author("Peter Pilgerstorfer")
		private MapIterator(ValueGetter<Node, T> valGetter) {
			this.valGetter = valGetter;
		}

		@Override
		@Author("Peter Pilgerstorfer")
		public boolean hasNext() {
			return next != null;
		}

		@Override
		@Author("Peter Pilgerstorfer")
		public T next() {
			T value = valGetter.getValue(next);
			next = next.next;

			return value;
		}
	}
}
