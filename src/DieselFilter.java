@Author("Koegler Alexander")
/**
 * Filter which accepts Tractors that use Diesel
 */
public class DieselFilter implements Filter<Tractor> {

	/**
	 * Accepts Tractors if their getFuel() returns a class equal to Diesel
	 */
	@Override
	@Author("Koegler Alexander")
	public boolean accept(Tractor element) {
		return element.getFuel().getClass() == Diesel.class;
	}

}
