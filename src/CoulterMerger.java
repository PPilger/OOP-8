@Author("Koegler Alexander")
public class CoulterMerger implements Merger<Tractor, Integer> {

	private Combinator<Integer, Integer, Integer> comb;

	@Author("Koegler Alexander")
	public CoulterMerger(Combinator<Integer, Integer, Integer> comb) {
		this.comb = comb;
	}

	@Override
	@Author("Koegler Alexander")
	public Integer initialValue() {
		return null;
	}

	@Override
	@Author("Koegler Alexander")
	public Integer merge(Tractor newElem, Integer value) {
		if (newElem.getRole().getClass() == Seeder.class) {
			if (value == null) {
				return newElem.getAttirbute().intValue();
			}
			return comb.combine(value, newElem.getAttirbute().intValue());
		}
		return value;
	}

}
