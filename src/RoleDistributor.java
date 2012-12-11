@Author("Kletzander Christian")
/*
 * Distributes values to Seeder, Fertilizer and all tractors
 */
public class RoleDistributor<V> extends Distributor<Tractor, String, V> {

	@Author("Kletzander Christian")
	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb);

		addType(Seeder.class.getName());
		addType(Fertilizer.class.getName());
		addType("Total");
	}

	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Tractor obj, String key) {
		if ("Total".equals(key)) {
			return true;
		}
		return key.equals(obj.getRole().getClass().getName());
	}
}
