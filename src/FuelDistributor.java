
public class FuelDistributor<V> extends Distributor<Tractor, Object, V>{

	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);
		addType(Diesel.class);
		addType(BioGas.class);
	}

	@Override
	protected boolean fitsKey(Tractor obj, Object fuel) {
		return obj.getFuel().getClass() == fuel;
	}

}
