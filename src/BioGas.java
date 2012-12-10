@Author("Koegler Alexander")
/**
 * Implements a BioGas-Fuel that uses Double-Type for calculations.
 */
public class BioGas implements Fuel<Double> {
	private double cubicMeter = 0;

	@Override
	@Author("Koegler Alexander")
	public Double getAmount() {
		return this.cubicMeter;
	}

	@Override
	@Author("Koegler Alexander")
	public void incAmount(Double amount) {
		this.cubicMeter += amount;
	}
	
	@Override
	@Author ("Peter Pilgerstorfer")
	public String toString() {
		return cubicMeter + " m^3";
	}
}
