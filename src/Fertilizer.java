public class Fertilizer implements TractorRole {
	private double capacity;

	public Fertilizer(double capacity) {
		this.capacity = capacity;
	}

	@Override
	public Double getAttribute() {
		return capacity;
	}
}
