@Author("Koegler Alexander")
/**
 * Distributes values to Diesel and BioGas tractors
 * @author Koegler Alexander
 *
 * @param <V>
 */
public class FuelDistributor<V> extends Distributor<Tractor, String, V> {

	@Author("Koegler Alexander")
	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);

		addType(BioGas.class.getName());
		addType(Diesel.class.getName());
	}

	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Tractor obj, String key) {
		return key.equals(obj.getFuel().getClass().getName());
	}
}
