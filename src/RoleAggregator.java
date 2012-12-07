public class RoleAggregator<V> extends Aggregator<Tractor, Object, V> {

	public RoleAggregator(Combinator<Tractor, V> comb) {
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
