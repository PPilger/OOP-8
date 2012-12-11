@Author("Kletzander Christian")
/*
 * Sums amount, of operating hours, up
 */
public class OperatingHoursMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Kletzander Christian")
	public Average initialValue() {
		return new Average();
	}
	
	@Override
	@Author("Kletzander Christian")
	public Average merge(Tractor newElem, Average value) {
		value.add(newElem.getOperatingHours());
		return value;
	}

}
