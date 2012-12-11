/**
 * Merges objects to a value. The object and the result-value may have different
 * types.
 */
@Author("Pilgerstorfer Peter")
public interface Merger<T, V> {

	@Author(value = "Pilgerstorfer Peter")
	public V initialValue();

	/**
	 * Returns obj merged to value. value may be changed by this method.
	 */
	@Author(value = "Pilgerstorfer Peter")
	public V merge(T obj, V value);
}
