public abstract class Engine<F extends Number> {
	private final F consumption;

	public Engine(F consumption) {
		this.consumption = consumption;
	}

	public F getConsumption() {
		return consumption;
	}
}