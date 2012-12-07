public class BioGasCombinator implements Combinator<Tractor, Double> {
	@Override
	public Double add(Tractor tr, Double num) {
		Fuel f = tr.getFuel();
		if (f.getClass() == BioGas.class) {
			return num + f.getAmount().doubleValue();
		}
		return num;
	}
}
