@Author (value="Pilgertorfer Peter", describtion="Filter for sorting")
public interface Filter<T> {
	/**
	 * @param element which will be checked whether it may be used
	 * @return true if element fits else false
	 */
	@Author (value="Pilgertorfer Peter")
	public boolean accept(T element);
}
