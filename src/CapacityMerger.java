@Author("Koegler Alexander")
/**
 * Sums amount, of a fertilizer's capacity, up
 */
public class CapacityMerger implements Merger<Tractor, Average<Double>> {

	@Override
	@Author("Koegler Alexander")
	public Average<Double> initialValue() {
		return new Average<Double>(new Combinator<Double, Double, Double>() {
			@Override
			@Author("Pilgertorfer Peter")
			public Double combine(Double val1, Double val2) {
				return val1 + val2;
			}
		}, 0.0);
	}

	@Override
	@Author("Koegler Alexander")
	public Average<Double> merge(Tractor newElem, Average<Double> value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			value.add(newElem.getAttirbute().doubleValue());
		}
		return value;
	}
}
