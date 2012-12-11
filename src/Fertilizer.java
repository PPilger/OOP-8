/**
 * Represents the role fertilizer. The capacity of the tank is stored.
 */
@Author("Kletzander Christian")
public class Fertilizer implements TractorRole {
	private double capacity;

	/**
	 * @param capacity
	 *            of tank in liters
	 */
	@Author("Kletzander Christian")
	public Fertilizer(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return capacity of tank in liters
	 */
	@Override
	@Author("Kletzander Christian")
	public Double getAttribute() {
		return capacity;
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		return "Fertilizer (" + capacity + " l)";
	}
}
