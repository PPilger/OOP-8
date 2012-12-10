@Author ("Kletzander Christian")
/**
 * A fertilizer has tank with a double-prec. floating point capacity
 * @author Kletzander Christian
 *
 */
public class Fertilizer implements TractorRole {
	private double capacity;

	/** 
	 * @param capacity of tank in liters
	 */
	@Author ("Kletzander Christian")
	public Fertilizer(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return capacity of tank in liters
	 */
	@Override
	@Author ("Kletzander Christian")
	public Double getAttribute() {
		return capacity;
	}
}
