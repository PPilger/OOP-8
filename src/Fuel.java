@Author("Koegler Alexander")
public interface Fuel {

	/**
	 * Returns the amount of fuel. The amount is greater or equal to zero.
	 */
	@Author("Koegler Alexander")
	public Number getAmount();

	/**
	 * Increases fuel amount by the specified amount.
	 */
	@Author("Koegler Alexander")
	public void incAmount(Number amount);
}
