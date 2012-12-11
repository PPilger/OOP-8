@Author ("Koegler Alexander")
/**
 * Distributes values to Diesel and BioGas tractors
 * @author Koegler Alexander
 *
 * @param <V>
 */
public class FuelDistributor<V> extends Distributor<Tractor, String, V>{

	@Author ("Koegler Alexander")
	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);
	}

	@Override
	@Author ("Koegler Alexander")
	protected String getKey(Tractor obj) {
		return obj.getFuel().getName();
	}

}
