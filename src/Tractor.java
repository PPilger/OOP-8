import java.lang.reflect.Method;

@Author("Pilgerstorfer Peter")
/*
 * In this class a tractor is discribed.
 */
public class Tractor<F extends Fuel<T>, T extends Number> {
	private static int idCounter = 0;
	private final int id;
	private F totalConsumption;
	private int operatingHours;
	private TractorRole role;

	@Author("Pilgerstorfer Peter")
	public Tractor() {
		this.id = idCounter;
		idCounter++;
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
}
