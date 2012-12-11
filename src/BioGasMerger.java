@Author("Koegler Alexander")
/**
 * Sums amount, of consumed BioGas, up.
 */
public class BioGasMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Pilgerstorfer Peter")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * returns sum of param num and total amount of a Tractor's BioGas
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor tr, Average num) {
		Fuel f = tr.getFuel();

		if (f.getClass() == BioGas.class) {
			num.add(f.getAmount());
		}

		return num;
	}
}
