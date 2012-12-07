
public class CapacityMerger implements Merger<Tractor, Double>{

	private Combinator<Double, Double, Double> comb =
			new Combinator<Double, Double, Double>() {
		
		@Override
		public Double combine(Double val1, Double val2) {
			return val1 + val2;
		}
	};
	
	@Override
	public Double initialValue() {
		return 0.;
	}

	@Override
	public Double merge(Tractor newElem, Double value) {
		if(newElem.getRole().getClass() == Fertilizer.class)
		{
			return comb.combine(value, newElem.getAttirbute().doubleValue());
		}
		return value;
	}

}
