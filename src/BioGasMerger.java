@Author("Koegler Alexander")
/**
 * Sums amount, of consumed BioGas, up.
 */
public class BioGasMerger extends DoubleAverageMerger {

	/**
	 * returns sum of param num and total amount of a Tractor's BioGas
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Average<Double> merge(Tractor tr, Average<Double> num) {
		Fuel f = tr.getFuel();

		if (f.getClass() == BioGas.class) {
			num.add(f.getAmount().doubleValue());
		}

		return num;
	}
}
