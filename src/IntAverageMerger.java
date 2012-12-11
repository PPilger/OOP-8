@Author("Pilgertorfer Peter")
public abstract class IntAverageMerger implements
		Merger<Tractor, Average<Integer>> {

	@Override
	@Author("Pilgertorfer Peter")
	public Average<Integer> initialValue() {
		return new Average<Integer>(
				new Combinator<Integer, Integer, Integer>() {
					@Override
					@Author("Pilgertorfer Peter")
					public Integer combine(Integer val1, Integer val2) {
						return val1 + val2;
					}
				}, 0);
	}
}
