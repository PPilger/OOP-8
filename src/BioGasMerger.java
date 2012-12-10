@Author("Koegler Alexander")
/**
 * Sums amount, of consumed BioGas, up.
 */
public class BioGasMerger implements Merger<Tractor, Double> {

	@Override
	@Author("Koegler Alexander")
	public Double initialValue() {
		return 0.0;
	}

	/**
	 * returns sum of param num and total amount of a Tractor's BioGas
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Double merge(Tractor tr, Double num) {
		Fuel f = tr.getFuel();
		if (f.getClass() == BioGas.class) {
			return num + f.getAmount().doubleValue();
		}
		return num;
	}
}
