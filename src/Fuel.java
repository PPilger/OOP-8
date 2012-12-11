@Author("Koegler Alexander")
public interface Fuel<T extends Number> {

	/**
	 * Returns the amount of fuel. The amount is greater or equal to zero.
	 */
	@Author("Koegler Alexander")
	public T getAmount();

	/**
	 * Increases fuel amount by the specified amount.
	 */
	@Author("Koegler Alexander")
	public void incAmount(T amount);
	
	@Author("Pilgerstorfer Peter")
	public String getName();
}
