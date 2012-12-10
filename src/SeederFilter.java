@Author (value="Kletzander Christian", describtion="Filter which accepts tractors with role of a seeder")
public class SeederFilter implements Filter<Tractor>{

	@Override
	@Author (value="Kletzander Christian")
	public boolean accept(Tractor element) {
		return element.getRole().getClass() == Seeder.class;
	}

	
}
