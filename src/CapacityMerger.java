/**
 * Averages the capacity of fertilizing tractors.
 * 
 * Merges Tractors to an Average object.
 */
@Author("Koegler Alexander")
public class CapacityMerger implements Merger {

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
	 * 
	 * tractor must be a Tractor and avg an Average object.
	 */
	@Override
	@Author("Koegler Alexander")
	public Average merge(Object tractor, Object avg) {
		Tractor tr = (Tractor) tractor;
		Average av = (Average) avg;
		
		if (tr.getRole().getClass() == Fertilizer.class) {
			av.add(tr.getAttirbute());
		}
		return av;
	}
}
