@Author("Kletzander Christian")
/*
 * Sums amount, of operating hours, up
 */
public class OperatingHoursMerger extends IntAverageMerger {

	@Override
	@Author("Kletzander Christian")
	public Average<Integer> merge(Tractor newElem, Average<Integer> value) {
		value.add(newElem.getOperatingHours());
		return value;
	}

}
