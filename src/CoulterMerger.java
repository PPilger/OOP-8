/**
 * Calculates the minimum or maximum of the coulter amount of seeding tractors.
 */
@Author("Koegler Alexander")
public class CoulterMerger implements Merger<Tractor, Extremum> {
	private boolean min;

	/**
	 * Creates a new CoulterMerger that calculates the minimum if min is true or
	 * the maximum otherwise.
	 */
	@Author("Koegler Alexander")
	public CoulterMerger(boolean min) {
		this.min = min;
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public Extremum initialValue() {
		if (min) {
			// create minimum
			return new Extremum(new Combinator<Integer, Integer, Integer>() {
				@Override
				@Author("Pilgertorfer Peter")
				public Integer combine(Integer val1, Integer val2) {
					return Math.min(val1, val2);
				}
			});
		} else {
			// create maximum
			return new Extremum(new Combinator<Integer, Integer, Integer>() {
				@Override
				@Author("Pilgertorfer Peter")
				public Integer combine(Integer val1, Integer val2) {
					return Math.max(val1, val2);
				}
			});
		}
	}

	/**
	 * If tractor is in the role Seeder, this method adds the coulter amount of
	 * tractor to ext and returns ext. Otherwise ext is returned unchanged.
	 * 
	 * ext may be changed by this method.
	 */
	@Override
	@Author("Koegler Alexander")
	public Extremum merge(Tractor tractor, Extremum ext) {
		if (tractor.getRole().getClass() == Seeder.class) {
			ext.add(tractor.getAttirbute().intValue());
		}

		return ext;
	}

}
