@Author("Koegler Alexander")
/**
 * Sums amount, of consumed Diesel, up.
 */
public class DieselMerger implements Merger<Tractor, Integer> {

	@Override
	@Author("Koegler Alexander")
	public Integer initialValue() {
		return 0;
	}

	/**
	 * returns sum of param num and total amount of a Tractor's Diesel
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Integer merge(Tractor tr, Integer num) {
		Fuel f = tr.getFuel();
		if (f.getClass() == Diesel.class) {
			return num + f.getAmount().intValue();
		}
		return num;
	}
}
