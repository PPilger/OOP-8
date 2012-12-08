@AnClass (author="Kletzander Christian", describtion="Distributes values to Seeder, Fertilizer and all tractors")
public class RoleDistributor<V> extends Distributor<Tractor, Object, V> {

	@AnClass (author="Kletzander Christian")
	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb);
		
		addType(Seeder.class);
		addType(Fertilizer.class);
		addType(null);
	}

	@Override
	@AnClass (author="Kletzander Christian")
	protected boolean fitsKey(Tractor tractor, Object roleType) {
		return roleType == null || tractor.getRole().getClass() == roleType;
	}
}
