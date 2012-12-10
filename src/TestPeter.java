public class TestPeter {
	public static Farm getPetersFarm() {
		Farm farm = new Farm("Peter's Farm");
		Tractor tr;

		tr = new Tractor<Diesel, Integer>(1, new Diesel(), new Seeder(5));
		farm.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(1, new Diesel(), new Seeder(10));
		farm.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(1, new BioGas(), new Seeder(4));
		farm.addTractor(tr);

		tr = new Tractor<BioGas, Double>(1, new BioGas(), new Seeder(7));
		farm.addTractor(tr);

		return farm;
	}
}
