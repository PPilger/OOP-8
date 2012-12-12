/**
 * Calculates the minimum or maximum of the coulter amount of seeding tractors.
 * 
 * Merges Tractors to an Extremum object.
 */
@Author("Koegler Alexander")
public class CoulterMerger implements Merger {
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
		return new Extremum(min);
	}

	/**
	 * If tractor is in the role Seeder, this method adds the coulter amount of
	 * tractor to ext and returns ext. Otherwise ext is returned unchanged.
	 * 
	 * ext may be changed by this method.
	 * 
	 * tractor must be a Tractor and ext an Extremum object.
	 */
	@Override
	@Author("Koegler Alexander")
	public Extremum merge(Object tractor, Object ext) {
		Tractor tr = (Tractor) tractor;
		Extremum ex = (Extremum) ext;

		if (tr.getRole().getClass() == Seeder.class) {
			ex.add(tr.getAttirbute().intValue());
		}

		return ex;
	}

}
