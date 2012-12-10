@Author("Kletzander Christian")
public class TestKletzi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("-------- KLETZI TEST --------");
		
		FarmManager fManager = new FarmManager();
		
		Farm test = new Farm("Kletzis Farm");
		
		fManager.addFarm(test);
		
		fManager.addTractor("Kletzis Farm", new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2)));
		fManager.addTractor("Kletzis Farm", new Tractor<BioGas, Double>(101, new BioGas(), new Fertilizer(3)));
		
		fManager.addTractor("Kletzis Farm", new Tractor<Diesel, Integer>(102, new Diesel(), new Seeder(8)));
		fManager.addTractor("Kletzis Farm", new Tractor<Diesel, Integer>(103, new Diesel(), new Seeder(5)));
		
		System.out.println(test);
	}
	
}
