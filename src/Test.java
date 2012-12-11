//TODO: tests erstellen
//TODO: annotationen hinzufügen
//TODO: generics entfernen
//TODO: tests nochmal durchfuehren
public class Test {

	/**
	 * Test class
	 * @param args
	 */
	@Author("Koegler Alexander")
	public static void main(String[] args) {

		Map<String, Farm> allFarms = new Map<String, Farm>();
		Farm myFarm = new Farm("Koeglers Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Koeglers other Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm =  new Farm("Kletzis Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Null Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Peter's Farm");
		allFarms.put(myFarm.getName(), myFarm);
		
		//####################################################
		//Koeglers 1st Farm
		System.out.println("-------- Test #-1 --------");
		System.out.println("Test with 11 tractors");
		System.out.println("-------------------------");
		
		myFarm = allFarms.get("Koeglers Farm");
		Tractor t1 = new Tractor<BioGas, Double>(0,new BioGas(), new Seeder(13));
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<BioGas, Double>(1,new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);
		
		t1 = new Tractor<BioGas, Double>(2,new BioGas(), new Seeder(15));
		t1.incConsumption(37.);
		t1.incOperatingHours(25);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(3,new Diesel(), new Seeder(26));
		t1.incConsumption(25);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(4,new Diesel(), new Seeder(27));
		t1.incConsumption(39);
		t1.incOperatingHours(48);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(5,new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);
		
		
		t1 = new Tractor<BioGas, Double>(6,new BioGas(), new Fertilizer(58.));
		myFarm.addTractor(t1);
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		
		t1 = new Tractor<BioGas, Double>(7,new BioGas(), new Fertilizer(97.5));
		t1.incConsumption(19.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<BioGas, Double>(8,new BioGas(), new Fertilizer(67.8));
		t1.incConsumption(5.);
		t1.incOperatingHours(65);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(9,new Diesel(), new Fertilizer(158.3));
		t1.incConsumption(7);
		t1.incOperatingHours(54);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(10,new Diesel(), new Fertilizer(186.8));
		t1.incConsumption(72);
		t1.incOperatingHours(69);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(11,new Diesel(), new Fertilizer(167.9));
		myFarm.addTractor(t1);		
		prnt(myFarm);
		
		//####################################################
		//Koeglers 2nd Farm
		System.out.println("-------- Test #0 --------");
		System.out.println("Add, edit and remove tractors from a farm");
		System.out.println("-------------------------");
		myFarm = allFarms.get(("Koeglers other Farm"));
		
		t1 = new Tractor<BioGas, Double>(0,new BioGas(), new Seeder(13));
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<BioGas, Double>(1,new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);
		
		t1 = new Tractor<BioGas, Double>(2,new BioGas(), new Fertilizer(15));
		t1.incConsumption(37.);
		t1.incOperatingHours(25);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(3,new Diesel(), new Seeder(26));
		t1.incConsumption(25);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(4,new Diesel(), new Fertilizer(27));
		t1.incConsumption(39);
		t1.incOperatingHours(48);
		myFarm.addTractor(t1);
		
		t1 = new Tractor<Diesel, Integer>(5,new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);
		
		prnt(myFarm);
		
		//increase Seeders AVG Operating Hours, and their consumption
		t1 = myFarm.getTractor(5);
		if(t1!= null)
		{
			t1.incOperatingHours(5);
			t1.incConsumption(25);
		}
		
		t1 = myFarm.getTractor(1);
		if(t1!= null)
		{
			t1.incOperatingHours(5);
			t1.incOperatingHours(25);
		}
		prnt(myFarm);
		
		//remove tractors
		myFarm.removeTractor(3);
		myFarm.removeTractor(1);
		prnt(myFarm);
		
		//add new one
		t1 = new Tractor<BioGas, Double>(33,new BioGas(), new Fertilizer(30));
		t1.incConsumption(20.);
		t1.incOperatingHours(8);
		myFarm.addTractor(t1);
		
		prnt(myFarm);
		
		//####################################################
		//Klees Farm1
		System.out.println("-------- Test #1 --------");
		System.out.println("Simple test");
		System.out.println("-------------------------");
		Tractor tr; Farm farmKletzi = allFarms.get("Kletzis Farm");
		
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
		prnt(farmKletzi);
		
		//####################################################
		//Klees Null Farm
		System.out.println("-------- Test #2 (Test von Null-Werten) --------");
		System.out.println("treatment of null values");
		System.out.println("-------------------------");
		
		farmKletzi = allFarms.get("Null Farm");
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
		
		prnt(farmKletzi);
		
		//####################################################
		//Peters Farm
		System.out.println("-------- Test #3 --------");
		System.out.println("Simple test");
		System.out.println("-------------------------");
		Farm farm = allFarms.get("Peter's Farm");
		tr = new Tractor<Diesel, Integer>(1, new Diesel(), new Seeder(5));
		tr.incConsumption(18);
		tr.incOperatingHours(100);
		farm.addTractor(tr);
		
		tr = new Tractor<Diesel, Integer>(2, new Diesel(), new Fertilizer(10));
		tr.incConsumption(15);
		tr.incOperatingHours(250);
		farm.addTractor(tr);
		
		tr = new Tractor<BioGas, Double>(3, new BioGas(), new Fertilizer(4));
		tr.incConsumption(20.5);
		tr.incOperatingHours(120);
		farm.addTractor(tr);

		tr = new Tractor<BioGas, Double>(4, new BioGas(), new Seeder(7));
		tr.incConsumption(19.3);
		tr.incOperatingHours(400);
		farm.addTractor(tr);
		prnt(farm);
		
	}
	
	/**
	 * Displays info and statistics about a farm
	 * @param myFarm must not be null
	 */
	@Author("Koegler Alexander")
	private static void prnt(Farm myFarm)
	{
		System.out.println(myFarm);
		
		System.out.println("=> MinCoultsersPerFuel [AVG]");
		System.out.println(myFarm.minCoultersPerFuel());
		
		System.out.println("=> MaxCoultsersPerFuel [AVG]");
		System.out.println(myFarm.maxCoultersPerFuel());
	
		System.out.println("=> CapacityPerFuel [AVG]");
		System.out.println(myFarm.avgCapacityPerFuel());
		
		System.out.println("=> BioGasUsagePerRole [AVG]");
		System.out.println(myFarm.avgBioGasUsagePerRole());
	
		System.out.println("=> DieselUsagePerRole [AVG]");
		System.out.println(myFarm.avgDieselUsagePerRole());
		
		System.out.println("=> OperatingHoursPerFuel [AVG]");
		System.out.println(myFarm.avgOHPerFuel());
		
		System.out.println("=> OperatingHoursPerRole [AVG]");
		System.out.println(myFarm.avgOHPerRole());
		System.out.println();
	}

}
