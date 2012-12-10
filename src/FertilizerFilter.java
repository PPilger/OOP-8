@Author ("Kletzander Christian")
/**
 * Filter which accepts tractors with role of a fertilizer
 * @author Kletzander Christian
 *
 */
public class FertilizerFilter implements Filter<Tractor>{

	@Override
	@Author ("Kletzander Christian")
	public boolean accept(Tractor element) {
		return element.getRole().getClass() == Fertilizer.class;
	}

}
