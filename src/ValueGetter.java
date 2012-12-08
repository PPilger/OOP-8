@AnClass (author="Pilgertorfer Peter", describtion="Retrieves a value of type V out of an object of type T")
public interface ValueGetter<T, V> {
	
	@AnClass (author="Pilgertorfer Peter")
	public V getValue(T obj);
}
