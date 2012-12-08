@AnClass (author="Koegler Alexander", describtion="Filter which accepts Tractors that use Diesel")
public class DieselFilter implements Filter<Tractor>{

	/**
	 * Accepts Tractors if their getFuel() returns a class equal to Diesel
	 */
	@Override
	@AnClass(author="Koegler Alexander")
	public boolean accept(Tractor element) {
		return element.getFuel().getClass() == Diesel.class;
	}

}
