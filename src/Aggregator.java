public abstract class Aggregator<T, K, V> {
	private Map<K, V> map = new Map<K, V>();
	private Combinator<T, V> comb;

	public Aggregator(Combinator<T, V> comb) {
		this.comb = comb;
	}
	
	protected void addType(K key) {
		map.put(key, comb.initialValue());
	}

	public void add(T obj) {
		Iterator<K> keyIter = map.keyIterator();

		while (keyIter.hasNext()) {
			K key = keyIter.next();

			if (fitsKey(obj, key)) {
				V value = map.get(key);

				value = comb.add(obj, value);

				map.put(key, value);
			}
		}
	}
	
	public Map<K, V> getAggregation() {
		return map;
	}

	protected abstract boolean fitsKey(T obj, K key);
}
