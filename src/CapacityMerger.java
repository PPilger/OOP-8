
public class CapacityMerger implements Merger<Tractor, Double>{

	private Combinator<Double, Double, Double> comb;
	public CapacityMerger(Combinator<Double, Double, Double> comb) {
		this.comb = comb;
	}
	
	@Override
	public Double initialValue() {
		return 0.;
	}

	@Override
	public Double merge(Tractor newElem, Double value) {
		if(newElem.getRole().getClass() == Fertilizer.class)
			return comb.combine(value, newElem.getAttirbute().doubleValue());
		return value;
	}

}
