
public class CoulterMerger implements Merger<Tractor, Integer> {

	Combinator<Integer, Integer, Integer> comb;
	
	public CoulterMerger(Combinator<Integer, Integer, Integer> comb) {
		this.comb = comb;
	}
	
	@Override
	public Integer initialValue() {
		return null;
	}

	@Override
	public Integer merge(Tractor newElem, Integer value) {
		if(newElem.getRole().getClass() == Seeder.class)
		{
			if(value == null)
			{
				return newElem.getAttirbute().intValue();
			}
			return comb.combine(value, newElem.getAttirbute().intValue());
		}
		return value;
	}
	

}
