
public class TestKoegler {

	public void tk1()
	{
		Farm myFarm = new Farm("Tupalco Woods");
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
	}
	
}
