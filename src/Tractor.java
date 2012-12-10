@Author("Pilgerstorfer Peter")
/*
 * In this class a tractor is discribed.
 */
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

	@Author("Pilgerstorfer Peter")
	public Fuel getFuel() {
		return this.totalConsumption;
	}

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

	@Author("Pilgerstorfer Peter")
	public void incConsumption(T fuelAmount) {
		totalConsumption.incAmount(fuelAmount);
	}

	@Author("Pilgerstorfer Peter")
	public T getConsumption() {
		return totalConsumption.getAmount();
	}

	@Author("Pilgerstorfer Peter")
	public void changeRole(TractorRole newRole) {
		role = newRole;
	}

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
