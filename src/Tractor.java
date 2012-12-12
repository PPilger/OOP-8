@Author("Pilgerstorfer Peter")
public class Tractor {
	private final int id;
	private Fuel totalConsumption;
	private int operatingHours;
	private TractorRole role;

	/**
	 * @param id
	 *            of the tractor, shall be unique
	 * @param totalConsumption
	 *            type of fuel consumed by the tractor, must not be null
	 * @param role
	 *            of tractor, must not be null
	 */
	@Author("Kletzander Christian")
	public Tractor(int id, Fuel totalConsumption, TractorRole role) {
		this.id = id;
		this.totalConsumption = totalConsumption;
		this.role = role;
	}

	/**
	 * @return ID of the tractor
	 */
	@Author("Pilgerstorfer Peter")
	public int getID() {
		return this.id;
	}

	/**
	 * @return actual role of the tractor
	 */
	@Author("Pilgerstorfer Peter")
	public TractorRole getRole() {
		return this.role;
	}

	/**
	 * 
	 * @return fuel of the tractor
	 */
	@Author("Pilgerstorfer Peter")
	public Fuel getFuel() {
		return this.totalConsumption;
	}

	/**
	 * Increments the operating hours by the specified amount.
	 * 
	 * @param amount
	 *            which will be added to the actual operating hours, value must
	 *            be positive in order to take affect
	 * 
	 */
	@Author("Pilgerstorfer Peter")
	public void incOperatingHours(int amount) {
		if (amount > 0) {
			operatingHours += amount;
		}
	}

	/**
	 * @return total amount of this tractor's operating hours, value greater or
	 *         equal to zero
	 */
	@Author("Pilgerstorfer Peter")
	public int getOperatingHours() {
		return operatingHours;
	}

	/**
	 * Increments the total consumption by the specified amount. The amount has
	 * to fit to the Fuel-type of the Tractor.
	 * 
	 * @param fuelAmount
	 *            amount which will be added to the actual consumption, value
	 *            shall be positive
	 */
	@Author("Pilgerstorfer Peter")
	public void incConsumption(Number amount) {
		totalConsumption.incAmount(amount);
	}

	/**
	 * Returns the total consumption. The returned value's type depends on the
	 * Fuel-type of the Tractor.
	 * 
	 * @return total amount of the tractor's consumed fuel
	 */
	@Author("Pilgerstorfer Peter")
	public Number getConsumption() {
		return totalConsumption.getAmount();
	}

	/**
	 * Changes the role of the tractor to the new one.
	 * 
	 * @param newRole
	 *            shall have another type/or other params than the actual role
	 *            of the tractor
	 * 
	 */
	@Author("Pilgerstorfer Peter")
	public void changeRole(TractorRole newRole) {
		role = newRole;
	}

	/**
	 * Returns the attribute of the current role. The return type may vary for
	 * different roles.
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
