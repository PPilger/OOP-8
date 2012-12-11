/**
 * Averages the total consumptions of bio gas engined tractors.
 */
@Author("Koegler Alexander")
public class BioGasMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Pilgerstorfer Peter")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * If tractor has a bio gas engine, this method adds the total consumption of
	 * tractor to avg and returns avg. Otherwise avg is returned unchanged.
	 * 
	 * avg may be changed by this method.
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor tractor, Average avg) {
		Fuel fuel = tractor.getFuel();

		if (fuel.getClass() == BioGas.class) {
			avg.add(fuel.getAmount());
		}

		return avg;
	}
}
