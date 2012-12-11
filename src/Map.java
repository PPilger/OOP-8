/**
 * Represents a map of key-value pairs. The key of every element is unique and
 * may be null.
 */
@Author("Peter Pilgerstorfer")
public class Map<K, V> {
	private Node root; // root of the linked list

	/**
	 * Inserts the specified key-value pair if the key doesn't exist. Otherwise
	 * the existing value is replaced by the new one.
	 * 
	 * key may be null.
	 */
	@Author("Peter Pilgerstorfer")
	public void put(K key, V value) {
		Node node = getNode(key);

		if (node != null) {
			// the key already exists
			node.value = value;
		} else {
			// the key doesn't exist
			Node newNode = new Node(key, value);

			// set next references
			newNode.next = root;
			root = newNode;

			// set previous references
			if (newNode.next != null) {
				newNode.next.prev = newNode;
			}
		}
	}

	/**
	 * Returns the value of the element with the specified key. If there is no
	 * such element, null is returned.
	 */
	@Author("Peter Pilgerstorfer")
	public V get(K key) {
		Node node = getNode(key);

		if (node != null) {
			return node.value;
		} else {
			return null;
		}
	}

	/**
	 * Removes the element with the specified key. If there is no such element,
	 * nothing is changed.
	 */
	@Author("Peter Pilgerstorfer")
	public void remove(K key) {
		Node node = getNode(key);

		if (node == null) {
			return;
		}

		// set next reference of the predecessor to skip the node.
		if (node.prev == null) {
			root = node.next;
		} else {
			node.prev.next = node.next;
		}

		// set the previous reference of the successor to skip the node
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	/**
	 * Performs a special fold operation on the map. Several folds can be done
	 * at once for different types. The Distributor distributes the value of an
	 * element to the concerned types,so every type can fold different elements.
	 * 
	 * The returned Map has the type stored as key with the respective folded
	 * value.
	 * 
	 * @param aggregator
	 *            must not be null
	 */
	@Author("Peter Pilgerstorfer")
	public <T, R> Map<T, R> fold(Distributor<V, T, R> aggregator) {
		Iterator<V> it = iterator();

		while (it.hasNext()) {
			V element = it.next();
			aggregator.add(element);
		}

		return aggregator.getDistribution();
	}

	/**
	 * Returns an iterator that iterates through the values of the map.
	 */
	@Author("Peter Pilgerstorfer")
	public Iterator<V> iterator() {
		return new MapIterator<V>(new ValueGetter<Node, V>() {
			@Override
			public V getValue(Node obj) {
				return obj.value;
			}
		});
	}

	/**
	 * Returns an iterator that iterates through the keys of the map.
	 */
	@Author("Peter Pilgerstorfer")
	public Iterator<K> keyIterator() {
		return new MapIterator<K>(new ValueGetter<Node, K>() {
			@Override
			public K getValue(Node obj) {
				return obj.key;
			}
		});
	}

	/**
	 * Returns an iterator that iterates through the nodes of the map.
	 */
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

	/**
	 * Returns the node with the specified key or null if such a node doesn't
	 * exist.
	 */
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

	/**
	 * Represents a node of a double linked list that stores key-value pairs.
	 */
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

	/**
	 * Represents an Iterator that iterates over the map. The returned attribute
	 * can be specified by a ValueGetter (get the desired attribute of a Node
	 * object).
	 */
	@Author("Peter Pilgerstorfer")
	private class MapIterator<T> implements Iterator<T> {
		private Node next = root;
		private ValueGetter<Node, T> valGetter;

		/**
		 * Creates a new MapIterator that iterates over the desired attributes.
		 * The specified ValueGetter returns the desired attribute of a Node
		 * object.
		 * 
		 * @param valGetter
		 *            must not be null
		 */
		@Author("Peter Pilgerstorfer")
		private MapIterator(ValueGetter<Node, T> valGetter) {
			this.valGetter = valGetter;
		}

		/**
		 * Returns true if there are more elements to read and false otherwise.
		 */
		@Override
		@Author("Peter Pilgerstorfer")
		public boolean hasNext() {
			return next != null;
		}

		/**
		 * Returns the next element. If there is no next element (hasNext() ==
		 * false), null is returned.
		 */
		@Override
		@Author("Peter Pilgerstorfer")
		public T next() {
			T value = valGetter.getValue(next);

			if (next == null) {
				return null;
			}

			next = next.next;

			return value;
		}
	}
}
