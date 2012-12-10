public class TestPeter {
	public static void main(String[] args) {
		Farm farm = getPetersFarm();
		
		System.out.println(farm);
	}
	
	public static Farm getPetersFarm() {
		Farm farm = new Farm("Peter's Farm");
		Tractor tr;

		tr = new Tractor<Diesel, Integer>(1, new Diesel(), new Seeder(5));
		tr.incConsumption(18);
		tr.incOperatingHours(100);
		farm.addTractor(tr);
		System.out.println(tr);
		
		tr = new Tractor<Diesel, Integer>(2, new Diesel(), new Fertilizer(10));
		tr.incConsumption(15);
		tr.incOperatingHours(250);
		farm.addTractor(tr);
		System.out.println(tr);
		
		tr = new Tractor<BioGas, Double>(3, new BioGas(), new Fertilizer(4));
		tr.incConsumption(20.5);
		tr.incOperatingHours(120);
		farm.addTractor(tr);
		System.out.println(tr);

		tr = new Tractor<BioGas, Double>(4, new BioGas(), new Seeder(7));
		tr.incConsumption(19.3);
		tr.incOperatingHours(400);
		farm.addTractor(tr);
		System.out.println(tr);

		return farm;
	}
}
