public class CapacityMerger implements Merger<Tractor, Double> {

	@Override
	public Double initialValue() {
		return 0.;
	}

	@Override
	public Double merge(Tractor newElem, Double value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			return value + newElem.getAttirbute().doubleValue();
		}
		return value;
	}

}
