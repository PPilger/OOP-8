
public class TestKoegler {

	public void tk1()
	{
		Farm myFarm = new Farm("Tupalco Woods");
		Tractor t1 = new Tractor<BioGas, Double>(0,new BioGas(), new Seeder(13));
		
		myFarm.addTractor(t1);
		t1 = new Tractor<BioGas, Double>(1,new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);
		t1 = new Tractor<BioGas, Double>(2,new BioGas(), new Seeder(15));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(3,new Diesel(), new Seeder(26));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(4,new Diesel(), new Seeder(27));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(5,new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);
		
		
		t1 = new Tractor<BioGas, Double>(6,new BioGas(), new Fertilizer(58.));
		myFarm.addTractor(t1);
		t1 = new Tractor<BioGas, Double>(7,new BioGas(), new Fertilizer(97.5));
		myFarm.addTractor(t1);
		t1 = new Tractor<BioGas, Double>(8,new BioGas(), new Fertilizer(67.8));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(9,new Diesel(), new Fertilizer(158.3));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(10,new Diesel(), new Fertilizer(186.8));
		myFarm.addTractor(t1);
		t1 = new Tractor<Diesel, Integer>(11,new Diesel(), new Fertilizer(167.9));
		myFarm.addTractor(t1);
		
		Map<Object, Integer> mm = myFarm.minCoultersPerFuel();		
		System.out.println(mm);
		mm = myFarm.maxCoultersPerFuel();
		System.out.println(mm);
		Map<Object, Double> nn = myFarm.avgBioGasUsagePerRole();
		System.out.println(nn);
		nn = myFarm.avgDieselUsagePerRole();
		System.out.println(nn);
		nn = myFarm.avgCapacityPerFuel();
		System.out.println(nn);
		nn = myFarm.avgOHPerFuel();
		System.out.println(nn);
		nn = myFarm.avgOHPerRole();
		System.out.println(nn);
				
		
		
	}
	
}
