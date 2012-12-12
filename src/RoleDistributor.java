/**
 * Distributes tractors to a every fitting Role-Type by merging the Role-Type's
 * value with the tractor.
 * 
 * The keys are:
 * "Seeder": every tractor with role Seeder fits,
 * "Fertilizer": every tractor with role Fertilizer fits,
 * "Total": every tractor fits
 */
@Author("Kletzander Christian")
public class RoleDistributor<V> extends Distributor<Tractor, String, V> {

	/**
	 * Creates a new Distributor with the keys "Seeder", "Fertilizer" and "Total".
	 */
	@Author("Kletzander Christian")
	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb);

		addKey(Seeder.class.getName());
		addKey(Fertilizer.class.getName());
		addKey("Total");
	}

	/**
	 * Returns true if tractor fits to fuelType.
	 * 
	 * fuelType is "Seeder" or "Fertilizer" or "Total".
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Tractor obj, String key) {
		if ("Total".equals(key)) {
			return true;
		}
		return key.equals(obj.getRole().getClass().getName());
	}
}
