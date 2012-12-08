@AnClass (author="Pilgerstorfer Peter", 
describtion="Merges a value of Type V with a corresponding value of Object T")
public interface Merger<T, V> {
	
	/**
	 * Inital value, e.g. zero
	 * @return initial value
	 */
	@AnClass (author="Pilgerstorfer Peter")
	public V initialValue();
	
	/**
	 * 
	 * @param newElem Object which contains a corresponding value
	 * @param value actual value used for merging
	 * @return result of merging value with corresponding value of newElem
	 */
	@AnClass (author="Pilgerstorfer Peter")
	public V merge(T newElem, V value);
}
