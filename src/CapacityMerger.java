@Author (value="Koegler Alexander", describtion="Sums amount, of a fertilizer's capacity, up")
public class CapacityMerger implements Merger<Tractor, Double> {

	@Override
	@Author (value="Koegler Alexander")
	public Double initialValue() {
		return 0.;
	}

	@Override
	@Author (value="Koegler Alexander")
	public Double merge(Tractor newElem, Double value) {
		if (newElem.getRole().getClass() == Fertilizer.class) {
			return value + newElem.getAttirbute().doubleValue();
		}
		return value;
	}

}
