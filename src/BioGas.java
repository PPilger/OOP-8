@Author(value="Koegler Alexander",
describtion="Implements a BioGas-Fuel which uses Double-Type for calculations")
public class BioGas implements Fuel<Double> {

	private double gallons;

	/**
	 * @param gallons Initial amount of consumed fuel in kubic-meters
	 */
	@Author (value="Koegler Alexander")
	public BioGas(double gallons) {
		this.gallons = gallons;
	}

	@Override
	@Author (value="Koegler Alexander")
	public Double getAmount() {
		return this.gallons;
	}

	@Override
	@Author (value="Koegler Alexander")
	public void incAmount(Double amount) {
		this.gallons += amount;
	}

}
