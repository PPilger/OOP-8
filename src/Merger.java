
public interface Merger<T, V> {
	public V initialValue();
	public V merge(T newElem, V value);
}
