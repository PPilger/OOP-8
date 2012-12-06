
public class DieselFilter implements Filter<Tractor>{

	@Override
	public boolean accept(Tractor element) {
		return element.getFuel().getClass() == Diesel.class;
	}

}
