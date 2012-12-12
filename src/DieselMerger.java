/**
 * Averages the total consumptions of diesel engined tractors.
 * 
 * Merges Tractors to an Average object.
 */
@Author("Koegler Alexander")
public class DieselMerger implements Merger {

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
	 * 
	 * tractor must be a Tractor and avg an Average object.
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Object tractor, Object avg) {
		Tractor tr = (Tractor) tractor;
		Average av = (Average) avg;
		Fuel fuel = tr.getFuel();

		if (fuel.getClass() == Diesel.class) {
			av.add(fuel.getAmount());
		}

		return av;
	}
}
