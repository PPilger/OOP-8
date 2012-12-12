/**
 * Retrieves a value out of an object.
 */
@Author ("Pilgertorfer Peter")
public interface ValueGetter<T, V> {
	
	@Author ("Pilgertorfer Peter")
	public V getValue(T obj);
}
