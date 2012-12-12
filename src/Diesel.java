/**
 * Represents a diesel fuel. The amount is stored as int
 */
@Author("Koegler Alexander")
public class Diesel implements Fuel{
	private int liter = 0;

	/**
	 * Returns the amount of diesel in liters. The amount is greater or equal to
	 * zero.
	 */
	@Override
	@Author("Koegler Alexander")
	public Integer getAmount() {
		return liter;
	}

	/**
	 * Increases amount of diesel by the specified amount.
	 */
	@Override
	@Author("Koegler Alexander")
	public void incAmount(Number amount) {
		liter += (Integer)amount;
	}

	@Override
	@Author("Peter Pilgerstorfer")
	public String toString() {
		return liter + " l diesel";
	}
}
