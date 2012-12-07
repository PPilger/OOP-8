public class BioGasMerger implements Merger<Tractor, Double> {

	@Override
	public Double initialValue() {
		return 0.0;
	}

	@Override
	public Double merge(Tractor tr, Double num) {
		Fuel f = tr.getFuel();
		if (f.getClass() == BioGas.class) {
			return num + f.getAmount().doubleValue();
		}
		return num;
	}
}
