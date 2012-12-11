@Author("Koegler Alexander")
public class CoulterMerger implements Merger<Tractor, Extremum> {
	private boolean min;

	@Author("Koegler Alexander")
	public CoulterMerger(boolean min) {
		this.min = min;
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public Extremum initialValue() {
		if (min) {
			return new Extremum(new Combinator<Integer, Integer, Integer>() {
				@Override
				@Author("Pilgertorfer Peter")
				public Integer combine(Integer val1, Integer val2) {
					return Math.min(val1, val2);
				}
			});
		} else {
			return new Extremum(new Combinator<Integer, Integer, Integer>() {
				@Override
				@Author("Pilgertorfer Peter")
				public Integer combine(Integer val1, Integer val2) {
					return Math.max(val1, val2);
				}
			});
		}
	}

	@Override
	@Author("Koegler Alexander")
	public Extremum merge(Tractor newElem, Extremum ext) {
		if (newElem.getRole().getClass() == Seeder.class) {
			ext.add(newElem.getAttirbute().intValue());
		}

		return ext;
	}

}
