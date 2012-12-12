/**
 * Distributes tractors to a every fitting Fuel-Type by merging the Fuel-Type's
 * value with the tractor.
 * 
 * The keys are:
 * "BioGas": every bio gas engined tractor fits,
 * "Diesel": every diesel engined tractor fits
 */
@Author("Koegler Alexander")
public class FuelDistributor<V> extends Distributor<Tractor, String, V> {

	/**
	 * Creates a new Distributor with the keys "BioGas" and "Diesel".
	 */
	@Author("Koegler Alexander")
	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);

		addKey(BioGas.class.getName());
		addKey(Diesel.class.getName());
	}

	/**
	 * Returns true if tractor fits to fuelType.
	 * 
	 * fuelType is "BioGas" or "Diesel".
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Tractor tractor, String fuelType) {
		return fuelType.equals(tractor.getFuel().getClass().getName());
	}
}
