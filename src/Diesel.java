@Author("Koegler Alexander")
/**
 * Implements a Diesel-Fuel which uses Integer-Type for calculations
 */
public class Diesel implements Fuel<Integer> {
	private int liter = 0;

	@Override
	@Author("Koegler Alexander")
	public Integer getAmount() {
		return liter;
	}

	@Override
	@Author("Koegler Alexander")
	public void incAmount(Integer amount) {
		liter += amount;
	}
}
