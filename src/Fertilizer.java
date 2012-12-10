@Author (value="Kletzander Christian",
describtion="A fertilizer has tank with a double-prec. floating point capacity ")
public class Fertilizer implements TractorRole {
	private double capacity;

	/** 
	 * @param capacity of tank in liters
	 */
	@Author (value="Kletzander Christian")
	public Fertilizer(double capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return capacity of tank in liters
	 */
	@Override
	@Author (value="Kletzander Christian")
	public Double getAttribute() {
		return capacity;
	}
}
