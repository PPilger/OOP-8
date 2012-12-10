@Author ("Koegler Alexander")
/**
 * Distributes values to Diesel and BioGas tractors
 * @author Koegler Alexander
 *
 * @param <V>
 */
public class FuelDistributor<V> extends Distributor<Tractor, Object, V>{

	@Author ("Koegler Alexander")
	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);
		addType(Diesel.class);
		addType(BioGas.class);
	}

	@Override
	@Author ("Koegler Alexander")
	protected boolean fitsKey(Tractor obj, Object fuel) {
		return obj.getFuel().getClass() == fuel;
	}

}
