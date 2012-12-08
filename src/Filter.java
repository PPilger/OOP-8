@AnClass (author="Pilgertorfer Peter", describtion="Filter for sorting")
public interface Filter<T> {
	/**
	 * @param element which will be checked whether it may be used
	 * @return true if element fits else false
	 */
	@AnClass (author="Pilgertorfer Peter")
	public boolean accept(T element);
}
