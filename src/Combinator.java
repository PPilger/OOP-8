@Author("Pilgertorfer Peter")
/**
 * Combines two values (of type V1, V2) and returns result of type R").
 */
public interface Combinator<V1, V2, R> {
	/**
	 * need not to be commutative or associative!
	 * 
	 * @param val1
	 * @param val2
	 * @return result of combining val1 and val2
	 */
	@Author("Pilgertorfer Peter")
	public R combine(V1 val1, V2 val2);
}
