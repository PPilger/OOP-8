/**
 * Averages the total consumptions of diesel engined tractors.
 */
@Author("Koegler Alexander")
public class DieselMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Koegler Alexander")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * If tractor has a diesel engine, this method adds the total consumption of
	 * tractor to avg and returns avg. Otherwise avg is returned unchanged.
	 * 
	 * avg may be changed by this method.
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor tractor, Average avg) {
		Fuel fuel = tractor.getFuel();

		if (fuel.getClass() == Diesel.class) {
			avg.add(fuel.getAmount());
		}

		return avg;
	}
}
