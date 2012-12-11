@Author("Kletzander Christian")
public class TestKletzi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//test1();
		test2();
		 
	}
	
	private static void test1() {
		
		System.out.println("-------- Test #1 --------");
		
		Farm farmKletzi = new Farm("Kletzis Farm");		
		Tractor tr;
		
		tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2));
		tr.incOperatingHours(12);
		tr.incConsumption(19.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Fertilizer(3));
		tr.incOperatingHours(15);
		tr.incConsumption(24.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Seeder(8));
		tr.incOperatingHours(1);
		tr.incConsumption(5);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(7);
		tr.incConsumption(12);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(3);
		tr.incConsumption(29);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(4);
		tr.incConsumption(4.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Seeder(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);
		
		System.out.println(farmKletzi);
		
		System.out.println("=> MinCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.minCoultersPerFuel());
		
		System.out.println("=> MaxCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.maxCoultersPerFuel());
	
		System.out.println("=> CapacityPerFuel [AVG]");
		System.out.println(farmKletzi.avgCapacityPerFuel());
		
		System.out.println("=> BioGasUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgBioGasUsagePerRole());
	
		System.out.println("=> DieselUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgDieselUsagePerRole());
		
		System.out.println("=> OperatingHoursPerFuel [AVG]");
		System.out.println(farmKletzi.avgOHPerFuel());
		
		System.out.println("=> OperatingHoursPerRole [AVG]");
		System.out.println(farmKletzi.avgOHPerRole());
		
	}
	
	private static void test2() {
		
		System.out.println("-------- Test #2 (Test von Null-Werten) --------");
		
		Farm farmKletzi = new Farm("Null Farm");		
		Tractor tr;
		
		tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(2));
		tr.incOperatingHours(11);
		tr.incConsumption(12.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Seeder(3));
		tr.incOperatingHours(11);
		tr.incConsumption(22.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Fertilizer(8));
		tr.incOperatingHours(3);
		tr.incConsumption(8);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(2);
		tr.incConsumption(9);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(2);
		tr.incConsumption(13);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(34);
		tr.incConsumption(44.0);
		farmKletzi.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Fertilizer(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);
		
		System.out.println(farmKletzi);
		
		System.out.println("=> MinCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.minCoultersPerFuel());
		
		System.out.println("=> MaxCoultsersPerFuel [AVG]");
		System.out.println(farmKletzi.maxCoultersPerFuel());
	
		System.out.println("=> CapacityPerFuel [AVG]");
		System.out.println(farmKletzi.avgCapacityPerFuel());
		
		System.out.println("=> BioGasUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgBioGasUsagePerRole());
	
		System.out.println("=> DieselUsagePerRole [AVG]");
		System.out.println(farmKletzi.avgDieselUsagePerRole());
		
		System.out.println("=> OperatingHoursPerFuel [AVG]");
		System.out.println(farmKletzi.avgOHPerFuel());
		
		System.out.println("=> OperatingHoursPerRole [AVG]");
		System.out.println(farmKletzi.avgOHPerRole());
		
	}
	
	
}
