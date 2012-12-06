public class Tractor<E extends Engine<F>, F extends Number> {
	private static int idCounter = 0;
	private final int id;
	private E engine;
	private F totalConsumption;
	private int operatingHours;

	public Tractor(E engine) {
		this.id = idCounter;
		idCounter++;

		this.engine = engine;
	}

	public int incOperatingHours(int addHours) {
		if (addHours > 0) {
			this.operatingHours += addHours;
		}
		return this.operatingHours;
	}

	public int getOperatingHours() {
		return this.operatingHours;
	}
}
