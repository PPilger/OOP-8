public class Fertilizer implements TractorRole {
	private double capacity;

	public Fertilizer(double capacity) {
		this.capacity = capacity;
	}

	public double getCapacity() {
		return this.capacity;
	}
}
