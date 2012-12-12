/**
 * Distributes objects to a every fitting key by merging the key's value with
 * the object.
 */
@Author("Pilgerstorfer Peter")
public abstract class Distributor {
	private Map map = new Map();
	private Merger comb;

	/**
	 * @param comb
	 *            is used to merge objects to the values of the distribution
	 *            map.
	 */
	@Author("Pilgerstorfer Peter")
	public Distributor(Merger comb) {
		this.comb = comb;
	}

	/**
	 * Defines a valid key.
	 */
	@Author("Pilgerstorfer Peter")
	protected void addKey(Object key) {
		map.put(key, comb.initialValue());
	}

	/**
	 * Returns true if obj fits the key.
	 * 
	 * key is one of the keys added by addKey.
	 */
	@Author("Pilgerstorfer Peter")
	protected abstract boolean fitsKey(Object obj, Object key);

	/**
	 * Distributes obj to a every fitting key by merging the key's value with
	 * the obj.
	 */
	@Author("Pilgerstorfer Peter")
	public void add(Object obj) {
		Iterator keyIter = map.keyIterator();

		while (keyIter.hasNext()) {
			Object key = keyIter.next();

			if (fitsKey(obj, key)) {
				Object value = map.get(key);

				value = comb.merge(obj, value);

				map.put(key, value);
			}
		}
	}

	/**
	 * Returns a map containing the keys and the merged values.
	 */
	@Author("Pilgerstorfer Peter")
	public Map getDistribution() {
		return map;
	}
}
