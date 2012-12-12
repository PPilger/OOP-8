/**
 * Merges objects to a value. The object and the result-value may have different
 * types.
 */
@Author("Pilgerstorfer Peter")
public interface Merger {

	@Author(value = "Pilgerstorfer Peter")
	public Object initialValue();

	/**
	 * Returns obj merged to value. value may be changed by this method.
	 */
	@Author(value = "Pilgerstorfer Peter")
	public Object merge(Object obj, Object value);
}
