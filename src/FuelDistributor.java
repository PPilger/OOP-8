/**
 * Distributes tractors to a every fitting Fuel-Type by merging the Fuel-Type's
 * value with the tractor.
 * 
 * The keys are:
 * "BioGas": every bio gas engined tractor fits,
 * "Diesel": every diesel engined tractor fits
 * 
 * The key-type is String. The value-type is dependend on the Merger used.
 */
@Author("Koegler Alexander")
public class FuelDistributor extends Distributor {

	/**
	 * Creates a new Distributor with the keys "BioGas" and "Diesel".
	 * 
	 * comb must be able to merge Tractor objects to a Merger-dependend value.
	 */
	@Author("Koegler Alexander")
	public FuelDistributor(Merger comb) {
		super(comb);

		addKey(BioGas.class.getName());
		addKey(Diesel.class.getName());
	}

	/**
	 * Returns true if tractor fits to fuelType.
	 * 
	 * fuelType is "BioGas" or "Diesel".
	 * 
	 * tractor must be a Tractor and fuelType a String object.
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	protected boolean fitsKey(Object tractor, Object fuelType) {
		Tractor tr = (Tractor) tractor;

		return fuelType.equals(tr.getFuel().getClass().getName());
	}
}
