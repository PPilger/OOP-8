@AnClass (author="Koegler Alexander", describtion="Sums amount, of a fertilizer's capacity, up")
public class CapacityMerger implements Merger<Tractor, Double> {

	@Override
	@AnClass (author="Koegler Alexander")
	public Double initialValue() {
		return 0.;
	}

	@Override
	@AnClass (author="Koegler Alexander")
	public Double merge(Tractor newElem, Double value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			return value + newElem.getAttirbute().doubleValue();
		}
		return value;
	}

}
