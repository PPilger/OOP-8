import java.lang.reflect.Method;

//TODO: tests erstellen
//TODO: annotationen hinzufügen
//TODO: generics entfernen
//TODO: tests nochmal durchfuehren
public class Test {

	/**
	 * Test class
	 * 
	 * @param args
	 */
	@Author("Koegler Alexander")
	public static void main(String[] args) {

		Map<String, Farm> allFarms = new Map<String, Farm>();
		Tractor t1;
		Farm myFarm = new Farm("Koeglers Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Kletzis Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Null Farm");
		allFarms.put(myFarm.getName(), myFarm);
		myFarm = new Farm("Peter's Farm");
		allFarms.put(myFarm.getName(), myFarm);

		// ####################################################
		// Koeglers Farm
		System.out.println("-------- Initialization --------");
		System.out.println("Farms without tractors");
		System.out.println("-------------------------");

		Iterator<Farm> iti = allFarms.iterator();
		while (iti.hasNext()) {
			System.out.println(iti.next());
		}

		// ####################################################
		// Koeglers Farm
		System.out.println("-------- Test #0 --------");
		System.out.println("Add, edit and remove tractors from a farm");
		System.out.println("-------------------------");
		myFarm = allFarms.get(("Koeglers Farm"));

		t1 = new Tractor<BioGas, Double>(0, new BioGas(), new Seeder(13));
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		t1 = new Tractor<BioGas, Double>(1, new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);

		t1 = new Tractor<BioGas, Double>(2, new BioGas(), new Fertilizer(15));
		t1.incConsumption(37.);
		t1.incOperatingHours(25);
		myFarm.addTractor(t1);

		t1 = new Tractor<Diesel, Integer>(3, new Diesel(), new Seeder(26));
		t1.incConsumption(25);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		t1 = new Tractor<Diesel, Integer>(4, new Diesel(), new Fertilizer(27));
		t1.incConsumption(39);
		t1.incOperatingHours(48);
		myFarm.addTractor(t1);

		t1 = new Tractor<Diesel, Integer>(5, new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);

		System.out.println(myFarm);

		// increase Seeders AVG Operating Hours, and their consumption
		t1 = myFarm.getTractor(5);
		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incConsumption(25);
		}

		t1 = myFarm.getTractor(1);
		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incOperatingHours(25);
		}
		System.out.println(myFarm);

		// remove tractors
		myFarm.removeTractor(3);
		myFarm.removeTractor(1);
		System.out.println(myFarm);

		// add new one
		t1 = new Tractor<BioGas, Double>(33, new BioGas(), new Fertilizer(30));
		t1.incConsumption(20.);
		t1.incOperatingHours(8);
		myFarm.addTractor(t1);

		System.out.println(myFarm);

		// ####################################################
		// Klees Farm1
		System.out.println("-------- Test #1 --------");
		System.out.println("Simple test");
		System.out.println("-------------------------");
		Tractor tr;
		Farm farmKletzi = allFarms.get("Kletzis Farm");

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

		// ####################################################
		// Klees Null Farm
		System.out.println("-------- Test #2 ---------");
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

		System.out.println(farmKletzi);

		// ####################################################
		// Peters Farm
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
		System.out.println(farm);

		// ####################################################
		// Statistics
		System.out.println("-------- Test #4 --------");
		System.out.println("Statistics of all existing farms");
		System.out.println("-------------------------");

		iti = allFarms.iterator();
		while (iti.hasNext()) {
			prnt(iti.next());
		}

		displayAnnotations();
	}

	private static void displayAnnotations() {

		System.out.println(getAnnotations(Author.class));
		System.out.println(getAnnotations(Average.class));
		System.out.println(getAnnotations(BioGas.class));
		System.out.println(getAnnotations(BioGasMerger.class));
		System.out.println(getAnnotations(CapacityMerger.class));
		System.out.println(getAnnotations(CoulterMerger.class));
		System.out.println(getAnnotations(Diesel.class));
		System.out.println(getAnnotations(DieselMerger.class));
		System.out.println(getAnnotations(Distributor.class));
		System.out.println(getAnnotations(Extremum.class));
		System.out.println(getAnnotations(Farm.class));
		System.out.println(getAnnotations(Fertilizer.class));
		System.out.println(getAnnotations(Fuel.class));
		System.out.println(getAnnotations(FuelDistributor.class));
		System.out.println(getAnnotations(Iterator.class));
		System.out.println(getAnnotations(Map.class));
		System.out.println(getAnnotations(Merger.class));
		System.out.println(getAnnotations(OperatingHoursMerger.class));
		System.out.println(getAnnotations(RoleDistributor.class));
		System.out.println(getAnnotations(Seeder.class));
		System.out.println(getAnnotations(Test.class));
		System.out.println(getAnnotations(Tractor.class));
		System.out.println(getAnnotations(TractorRole.class));
		System.out.println(getAnnotations(ValueGetter.class));

	}

	/**
	 * Displays info and statistics about a farm
	 * 
	 * @param myFarm
	 *            must not be null
	 */
	@Author("Koegler Alexander")
	private static void prnt(Farm myFarm) {
		System.out.println(myFarm);

		System.out.print("MinCoultsersPerFuel: [");
		System.out.print(myFarm.minCoultersPerFuel());
		System.out.println("]");

		System.out.print("MaxCoultsersPerFuel: [");
		System.out.print(myFarm.maxCoultersPerFuel());
		System.out.println("]");

		System.out.print("CapacityPerFuel: [");
		System.out.print(myFarm.avgCapacityPerFuel());
		System.out.println("]");

		System.out.print("BioGasUsagePerRole: [");
		System.out.print(myFarm.avgBioGasUsagePerRole());
		System.out.println("]");

		System.out.print("DieselUsagePerRole: [");
		System.out.print(myFarm.avgDieselUsagePerRole());
		System.out.println("]");

		System.out.print("OperatingHoursPerFuel: [");
		System.out.print(myFarm.avgOHPerFuel());
		System.out.println("]");

		System.out.print("OperatingHoursPerRole: [");
		System.out.print(myFarm.avgOHPerRole());
		System.out.println("]");

		System.out.println();
	}

	/**
	 * Displays author infos about a specific class and methods
	 * 
	 * @param myFarm
	 *            must not be null
	 */
	@Author("Kletzander Christian")
	private static String getAnnotations(Class c) {

		StringBuilder sb = new StringBuilder();
		sb.append("Klasse: '" + c.getName() + "' von ");

		try {
			Author a = (Author) c.getAnnotation(Author.class);
			sb.append(a.value() + "\n");
		} catch (NullPointerException ex) {
			sb.append("<No Author defined>\n");
		}

		for (Method m : c.getMethods()) {
			sb.append("|------\tMethode: '" + m.getName() + "' von ");
			
			try {
				String value = m.getAnnotation(Author.class).value();
				sb.append(value + "\n");
			} catch (NullPointerException ex) {
				sb.append("<No Author defined>\n");
			}
		}

		return sb.toString();
	}
}
