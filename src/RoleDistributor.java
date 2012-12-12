/**
 * Distributes tractors to a every fitting Role-Type by merging the Role-Type's
 * value with the tractor.
 * 
 * The keys are:
 * "Seeder": every tractor with role Seeder fits,
 * "Fertilizer": every tractor with role Fertilizer fits,
 * "Total": every tractor fits
 * 
 * The key-type is String. The value-type is dependend on the Merger used.
 */
@Author("Kletzander Christian")
public class RoleDistributor<V> extends Distributor {

	/**
	 * Creates a new Distributor with the keys "Seeder", "Fertilizer" and "Total".
	 * 
	 * comb must be able to merge Tractor objects to a Merger-dependend value.
	 */
	@Author("Kletzander Christian")
	public RoleDistributor(Merger comb) {
		super(comb);

		addKey(Seeder.class.getName());
		addKey(Fertilizer.class.getName());
		addKey("Total");
	}

	/**
	 * Returns true if tractor fits to fuelType.
	 * 
	 * fuelType is "Seeder" or "Fertilizer" or "Total".
	 * 
	 * tractor must be a Tractor and fuelType a String object.
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Object tractor, Object key) {
		Tractor tr = (Tractor) tractor;
		
		if ("Total".equals(key)) {
			return true;
		}
		return key.equals(tr.getRole().getClass().getName());
	}
}
