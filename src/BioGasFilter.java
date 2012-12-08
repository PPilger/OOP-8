@AnClass (author="Koegler Alexander", describtion="Filter which accepts Tractors that use BioGas")
public class BioGasFilter implements Filter<Tractor>{

	/**
	 * Accepts Tractors if their getFuel() returns a class equal to BioGas
	 */
	@Override
	@AnClass (author="Koegler Alexander")
	public boolean accept(Tractor element) {
		return element.getFuel().getClass() == BioGas.class;
	}

}
