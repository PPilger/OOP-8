@Author ("Pilgertorfer Peter")
/*
 * Retrieves a value of type V out of an object of type T
 */
public interface ValueGetter<T, V> {
	
	@Author ("Pilgertorfer Peter")
	public V getValue(T obj);
}
