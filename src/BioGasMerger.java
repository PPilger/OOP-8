/**
 * Averages the total consumptions of bio gas engined tractors.
 * 
 * Merges Tractors to an Average object.
 */
@Author("Koegler Alexander")
public class BioGasMerger implements Merger {

	@Override
	@Author("Pilgerstorfer Peter")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * If tractor has a bio gas engine, this method adds the total consumption
	 * of tractor to avg and returns avg. Otherwise avg is returned unchanged.
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

		if (fuel.getClass() == BioGas.class) {
			av.add(fuel.getAmount());
		}

		return av;
	}
}
