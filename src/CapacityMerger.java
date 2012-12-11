/**
 * Averages the capacity of fertilizing tractors.
 */
@Author("Koegler Alexander")
public class CapacityMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Koegler Alexander")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * If tractor is in the role Fertlilizer, this method adds the capacity of
	 * tractor to avg and returns avg. Otherwise avg is returned unchanged.
	 * 
	 * avg may be changed by this method.
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor tractor, Average avg) {
		if (tractor.getRole().getClass() == Fertilizer.class) {
			avg.add(tractor.getAttirbute());
		}
		return avg;
	}
}
