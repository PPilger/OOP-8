@Author("Koegler Alexander")
/**
 * Sums amount, of a fertilizer's capacity, up
 */
public class CapacityMerger extends DoubleAverageMerger {

	@Override
	@Author("Koegler Alexander")
	public Average<Double> merge(Tractor newElem, Average<Double> value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			value.add(newElem.getAttirbute().doubleValue());
		}
		return value;
	}
}
