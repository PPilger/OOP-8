@Author ("Kletzander Christian")
/*
 * Distributes values to Seeder, Fertilizer and all tractors
 */
public class RoleDistributor<V> extends Distributor<Tractor, Object, V> {

	@Author ("Kletzander Christian")
	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb);
		
		addType(Seeder.class);
		addType(Fertilizer.class);
		addType(null);
	}

	@Override
	@Author ("Kletzander Christian")
	protected boolean fitsKey(Tractor tractor, Object roleType) {
		return roleType == null || tractor.getRole().getClass() == roleType;
	}
}
