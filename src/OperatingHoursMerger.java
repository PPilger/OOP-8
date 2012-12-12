/**
 * Averages the operating hours of tractors.
 * 
 * Merges Tractors to an Average object.
 */
@Author("Kletzander Christian")
public class OperatingHoursMerger implements Merger {

	@Override
	@Author("Kletzander Christian")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * This method adds the operating hours of tractor to avg and returns avg.
	 * 
	 * avg is changed by this method.
	 * 
	 * tractor must be a Tractor and avg an Average object.
	 */
	@Override
	@Author("Kletzander Christian")
	public Average merge(Object tractor, Object avg) {
		Tractor tr = (Tractor) tractor;
		Average av = (Average) avg;
		
		av.add(tr.getOperatingHours());
		return av;
	}

}
