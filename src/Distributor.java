/**
 * Distributes objects to a every fitting key by merging the key's value with
 * the object.
 */
@Author("Pilgerstorfer Peter")
public abstract class Distributor<T, K, V> {
	private Map<K, V> map = new Map<K, V>();
	private Merger<T, V> comb;

	/**
	 * @param comb
	 *            is used to merge objects to the values of the distribution
	 *            map.
	 */
	@Author("Pilgerstorfer Peter")
	public Distributor(Merger<T, V> comb) {
		this.comb = comb;
	}

	/**
	 * Defines a valid key.
	 */
	@Author("Pilgerstorfer Peter")
	protected void addKey(K key) {
		map.put(key, comb.initialValue());
	}

	/**
	 * Returns true if obj fits the key.
	 * 
	 * key is one of the keys added by addKey.
	 */
	@Author("Pilgerstorfer Peter")
	protected abstract boolean fitsKey(T obj, K key);

	/**
	 * Distributes obj to a every fitting key by merging the key's value with
	 * the obj.
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
	 * Returns the distribution-map.
	 */
	@Author("Pilgerstorfer Peter")
	public Map<K, V> getDistribution() {
		return map;
	}
}
