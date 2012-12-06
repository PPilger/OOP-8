public class Tractor<F extends Fuel<T>, T> {
	private static int idCounter = 0;
	private final int id;
	private F totalConsumption;
	private int operatingHours;
	private TractorRole role;

	public Tractor() {
		this.id = idCounter;
		idCounter++;
	}

	public void incOperatingHours(int amount) {
		if (amount > 0) {
			operatingHours += amount;
		}
	}

	public int getOperatingHours() {
		return operatingHours;
	}
	
	public void incConsumption(T fuelAmount) {
		totalConsumption.incAmount(fuelAmount);
	}
	
	public T getConsumption() {
		return totalConsumption.getAmount();
	}
}
