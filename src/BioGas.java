@Author("Koegler Alexander")
/**
 * Represents a bio gas fuel. The amount is stored as double.
 */
public class BioGas implements Fuel<Double> {
	private double cubicMeter = 0;

	/**
	 * Returns the amount of bio gas in cubic meters. The amount is greater or equal to zero.
	 */
	@Override
	@Author("Koegler Alexander")
	public Double getAmount() {
		return this.cubicMeter;
	}

	/**
	 * Increases amount of bio gas by the specified amount.
	 */
	@Override
	@Author("Koegler Alexander")
	public void incAmount(Double amount) {
		this.cubicMeter += amount;
	}
	
	@Override
	@Author ("Peter Pilgerstorfer")
	public String toString() {
		return cubicMeter + " m^3 bio gas";
	}
}
