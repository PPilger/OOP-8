@Author("Pilgerstorfer Peter")
public class Tractor<F extends Fuel<T>, T extends Number> {
	private final int id;
	private F totalConsumption;
	private int operatingHours;
	private TractorRole role;

	@Author("Kletzander Christian")
	public Tractor(int id, F totalConsumption, TractorRole role) {
		this.id = id;
		this.totalConsumption = totalConsumption;
		this.role = role;
	}

	@Author("Pilgerstorfer Peter")
	public int getID() {
		return this.id;
	}

	@Author("Pilgerstorfer Peter")
	public TractorRole getRole() {
		return this.role;
	}

	/**
	 * @return the total consumption
	 */
	@Author("Pilgerstorfer Peter")
	public Fuel getFuel() {
		return this.totalConsumption;
	}

	/**
	 * Increments the operating hours by the specified amount.
	 */
	@Author("Pilgerstorfer Peter")
	public void incOperatingHours(int amount) {
		if (amount > 0) {
			operatingHours += amount;
		}
	}

	@Author("Pilgerstorfer Peter")
	public int getOperatingHours() {
		return operatingHours;
	}

	/**
	 * Increments the total consumption by the specified amount. The amount has
	 * to fit to the Fuel-type of the Tractor.
	 */
	@Author("Pilgerstorfer Peter")
	public void incConsumption(T amount) {
		totalConsumption.incAmount(amount);
	}

	/**
	 * Returns the total consumption. The returned value's type depends on the
	 * Fuel-type of the Tractor.
	 */
	@Author("Pilgerstorfer Peter")
	public T getConsumption() {
		return totalConsumption.getAmount();
	}

	/**
	 * Changes the role of the tractor to the new one.
	 */
	@Author("Pilgerstorfer Peter")
	public void changeRole(TractorRole newRole) {
		role = newRole;
	}

	/**
	 * Returns the attribute of the current role.
	 */
	@Author("Pilgerstorfer Peter")
	public Number getAttirbute() {
		return role.getAttribute();
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		return role + " #" + id + ": " + operatingHours + " h, "
				+ totalConsumption;
	}
}
