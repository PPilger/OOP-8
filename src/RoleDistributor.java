public class RoleDistributor<V> extends Distributor<Tractor, Object, V> {

	public RoleDistributor(Merger<Tractor, V> comb) {
		super(comb);
		
		addType(Seeder.class);
		addType(Fertilizer.class);
		addType(null);
	}

	@Override
	protected boolean fitsKey(Tractor tractor, Object roleType) {
		return roleType == null || tractor.getRole().getClass() == roleType;
	}
}
