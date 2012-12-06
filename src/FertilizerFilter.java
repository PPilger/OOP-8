
public class FertilizerFilter implements Filter<Tractor>{

	@Override
	public boolean accept(Tractor element) {
		return element.getRole().getClass() == Fertilizer.class;
	}

}
