@Author("Koegler Alexander")
/**
 * Sums amount, of consumed Diesel, up.
 */
public class DieselMerger extends IntAverageMerger {

	/**
	 * returns sum of param num and total amount of a Tractor's Diesel
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Average<Integer> merge(Tractor tr, Average<Integer> num) {
		Fuel f = tr.getFuel();

		if (f.getClass() == Diesel.class) {
			num.add(f.getAmount().intValue());
		}

		return num;
	}
}
