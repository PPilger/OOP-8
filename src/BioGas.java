@Author("Koegler Alexander")
/**
 * Implements a BioGas-Fuel that uses Double-Type for calculations.
 */
public class BioGas implements Fuel<Double> {

	private double gallons;

	/**
	 * @param gallons
	 *            Initial amount of consumed fuel in kubic-meters
	 */
	@Author("Koegler Alexander")
	public BioGas(double gallons) {
		this.gallons = gallons;
	}

	@Override
	@Author("Koegler Alexander")
	public Double getAmount() {
		return this.gallons;
	}

	@Override
	@Author("Koegler Alexander")
	public void incAmount(Double amount) {
		this.gallons += amount;
	}

}
