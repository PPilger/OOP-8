@Author("Peter Pilgerstorfer")
/*
 * Simple iterator interface
 */
public interface Iterator<T> {
	@Author("Peter Pilgerstorfer")
	public boolean hasNext();

	@Author("Peter Pilgerstorfer")
	public T next();
}
