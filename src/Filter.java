@Author ("Pilgertorfer Peter")
/**
 * Filter for sorting
 * @author Pilgertorfer Peter
 *
 * @param <T>
 */
public interface Filter<T> {
	/**
	 * @param element which will be checked whether it may be used
	 * @return true if element fits else false
	 */
	@Author ("Pilgertorfer Peter")
	public boolean accept(T element);
}
