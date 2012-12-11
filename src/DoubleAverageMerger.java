@Author("Pilgertorfer Peter")
public abstract class DoubleAverageMerger implements
		Merger<Tractor, Average<Double>> {

	@Override
	@Author("Pilgertorfer Peter")
	public Average<Double> initialValue() {
		return new Average<Double>(new Combinator<Double, Double, Double>() {
			@Override
			@Author("Pilgertorfer Peter")
			public Double combine(Double val1, Double val2) {
				return val1 + val2;
			}
		}, 0.0);
	}
}
