@Author (value="Pilgertorfer Peter", describtion="Retrieves a value of type V out of an object of type T")
public interface ValueGetter<T, V> {
	
	@Author (value="Pilgertorfer Peter")
	public V getValue(T obj);
}
