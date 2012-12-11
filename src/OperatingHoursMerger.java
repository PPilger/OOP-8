/**
 * Averages the operating hours of tractors.
 */
@Author("Kletzander Christian")
public class OperatingHoursMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Kletzander Christian")
	public Average initialValue() {
		return new Average();
	}

	/**
	 * This method adds the operating hours of tractor to avg and returns avg.
	 * 
	 * avg is changed by this method.
	 */
	@Override
	@Author("Kletzander Christian")
	public Average merge(Tractor tractor, Average avg) {
		avg.add(tractor.getOperatingHours());
		return avg;
	}

}
