
public class SeederFilter implements Filter<Tractor>{

	@Override
	public boolean accept(Tractor element) {
		return element.getRole().getClass() == Seeder.class;
	}

	
}
