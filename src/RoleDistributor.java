@Author ("Kletzander Christian")
/*
 * Distributes values to Seeder, Fertilizer and all tractors
 */
public class RoleDistributor<V> extends Distributor<Tractor, String, V> {

	@Author ("Kletzander Christian")
	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb, "Total");
	}

	@Override
	@Author("Pilgerstorfer Peter")
	protected String getKey(Tractor tractor) {
		return tractor.getRole().getName();
	}
}
