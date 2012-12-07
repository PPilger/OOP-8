
public class CoulterMerger implements Merger<Tractor, Integer> {

	Combinator<Integer, Integer, Integer> comb;
	
	public CoulterMerger(Combinator<Integer, Integer, Integer> comb) {
		this.comb = comb;
	}
	
	@Override
	public Integer initialValue() {
		return 0;
	}

	@Override
	public Integer merge(Tractor newElem, Integer value) {
		if(newElem.getRole().getClass() == Seeder.class)
			return comb.combine(value, newElem.getAttirbute().intValue());
		
		return value;
	}
	

}
