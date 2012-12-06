
public class BioGasFilter implements Filter<Tractor>{

	@Override
	public boolean accept(Tractor element) {
		return element.getFuel().getClass() == BioGas.class;
	}

}
