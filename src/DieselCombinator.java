public class DieselCombinator implements Combinator<Tractor, Integer> {
	@Override
	public Integer add(Tractor tr, Integer num) {
		Fuel f = tr.getFuel();
		if (f.getClass() == Diesel.class) {
			return num + f.getAmount().intValue();
		}
		return num;
	}
}
