@Author("Pilgerstorfer Peter")
/**
 * Merges objects of type T with corresponding value of type V into a map with keys of type K.
 */
public abstract class Distributor<T, K, V> {
	private Map<K, V> map = new Map<K, V>();
	private Merger<T, V> comb;
	private K totalKey;

	/**
	 * Initializes object
	 * 
	 * @param comb
	 *            used for merging values with existing one in map, and
	 *            initializing the map's values
	 */
	@Author("Pilgerstorfer Peter")
	public Distributor(Merger<T, V> comb) {
		this.comb = comb;
		this.totalKey = null;
	}

	/**
	 * Adds key to map with initial value
	 * 
	 * @param key
	 */
	@Author("Pilgerstorfer Peter")
	protected void addType(K key) {
		map.put(key, comb.initialValue());
	}

	/**
	 * checking if object should be merged in add() with value mapped by given
	 * key
	 * 
	 * @param obj
	 *            object
	 * @param key
	 * @return true if they should be merged, otherwise false
	 */
	@Author("Pilgerstorfer Peter")
	protected abstract boolean fitsKey(T obj, K key);

	/**
	 * 
	 * @param obj
	 *            object which is used for merging with value mapped by the key
	 *            which fits to the object (fitsKey() method)
	 */
	@Author("Pilgerstorfer Peter")
	public void add(T obj) {
		Iterator<K> keyIter = map.keyIterator();

		while (keyIter.hasNext()) {
			K key = keyIter.next();

			if (fitsKey(obj, key)) {
				V value = map.get(key);

				value = comb.merge(obj, value);

				map.put(key, value);
			}
		}
	}

	/**
	 * @return map
	 */
	@Author("Pilgerstorfer Peter")
	public Map<K, V> getDistribution() {
		return map;
	}
}
