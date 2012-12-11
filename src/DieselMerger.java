@Author("Koegler Alexander")
/**
 * Sums amount, of consumed Diesel, up.
 */
public class DieselMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Koegler Alexander")
	public Average initialValue() {
		return new Average();
	}
	
	/**
	 * returns sum of param num and total amount of a Tractor's Diesel
	 * consumption
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor tr, Average num) {
		Fuel f = tr.getFuel();

		if (f.getClass() == Diesel.class) {
			num.add(f.getAmount());
		}

		return num;
	}
}
