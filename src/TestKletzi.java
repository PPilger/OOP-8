@Author("Kletzander Christian")
public class TestKletzi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("-------- KLETZI TEST --------");
		
		Farm farmKletzi = new Farm("Kletzis Farm");		
		
		farmKletzi.addTractor(new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2)));
		farmKletzi.addTractor(new Tractor<BioGas, Double>(101, new BioGas(), new Fertilizer(3)));
		farmKletzi.addTractor(new Tractor<Diesel, Integer>(102, new Diesel(), new Seeder(8)));
		farmKletzi.addTractor(new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5)));
		
		System.out.println(farmKletzi);
	}
	
}
