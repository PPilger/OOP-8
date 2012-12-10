@Author("Peter Pilgerstorfer")
public interface Iterator<T> {
	@Author("Peter Pilgerstorfer")
	/**
	 * Returns true if there are more elements to read and false otherwise.
	 */
	public boolean hasNext();

	@Author("Peter Pilgerstorfer")
	/**
	 * Returns the next element. If there is no next element (hasNext() == false), the behavior is undefined.
	 */
	public T next();
}
