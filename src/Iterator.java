@Author("Peter Pilgerstorfer")
public interface Iterator {
	/**
	 * Returns true if there are more elements to read and false otherwise.
	 */
	@Author("Peter Pilgerstorfer")
	public boolean hasNext();

	/**
	 * Returns the next element. If there is no next element (hasNext() ==
	 * false), the behavior is undefined.
	 */
	@Author("Peter Pilgerstorfer")
	public Object next();
}
