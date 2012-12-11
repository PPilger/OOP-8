@Author("Koegler Alexander")
/**
 * Sums amount, of a fertilizer's capacity, up
 */
public class CapacityMerger implements Merger<Tractor, Average> {

	@Override
	@Author("Koegler Alexander")
	public Average initialValue() {
		return new Average();
	}
	
	@Override
	@Author("Koegler Alexander")
	public Average merge(Tractor newElem, Average value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			value.add(newElem.getAttirbute());
		}
		return value;
	}
}
