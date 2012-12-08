@AnClass (author="Kletzander Christian", describtion="Filter which accepts tractors with role of a fertilizer")
public class FertilizerFilter implements Filter<Tractor>{

	@Override
	@AnClass (author="Kletzander Christian")
	public boolean accept(Tractor element) {
		return element.getRole().getClass() == Fertilizer.class;
	}

}
