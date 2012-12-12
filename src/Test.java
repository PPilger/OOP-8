import java.lang.reflect.Method;

//TODO: tests erstellen
//TODO: annotationen hinzufügen
//TODO: generics entfernen
//TODO: tests nochmal durchfuehren
public class Test {

	static Map<String, Farm> allFarms = new Map<String, Farm>();

	/**
	 * Test class
	 * 
	 * @param args
	 */
	@Author("Koegler Alexander")
	public static void main(String[] args) {

		/**
		 * create Farm's
		 */
		createKoeglersFarm();
		createKletzisFarm();
		createNullFarm();
		createPetersFarm();

		displayFarmStatistic();

		/**
		 * add Tractors to Farm's
		 */

		addTractorToKoeglersFarm();
		addTractorToKletzisFarm();
		addTractorToNullFarm();
		addTractorToPetersFarm();

		displayFarmStatistic();

		/**
		 * change Tractors at Farm's
		 */

		changeTractorsAtKoeglersFarm();

		displayFarmStatistic();

		/**
		 * remove Tractors from Farm's
		 */

		removeTractorsFromKoeglersFarm();

		displayFarmStatistic();

		/**
		 * add new Tractors to Farm's
		 */

		addNewTractorsToKoeglersFarm();

		displayFarmStatistic();

		/**
		 * display Annotations
		 */
		displayAnnotations();

	}

	private static void createKoeglersFarm() {
		Farm myFarm = new Farm("Koeglers Farm");
		allFarms.put(myFarm.getName(), myFarm);
	}

	private static void createKletzisFarm() {
		Farm myFarm = new Farm("Kletzis Farm");
		allFarms.put(myFarm.getName(), myFarm);
	}

	private static void createNullFarm() {
		Farm myFarm = new Farm("Null Farm");
		allFarms.put(myFarm.getName(), myFarm);
	}

	private static void createPetersFarm() {
		Farm myFarm = new Farm("Peter's Farm");
		allFarms.put(myFarm.getName(), myFarm);
	}

	private static void addTractorToKoeglersFarm() {
		Farm myFarm = allFarms.get(("Koeglers Farm"));

		Tractor t1 = new Tractor<BioGas, Double>(0, new BioGas(),
				new Seeder(13));
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor<BioGas, Double>(1, new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor<BioGas, Double>(2, new BioGas(), new Fertilizer(15));
		t1.incConsumption(37.);
		t1.incOperatingHours(25);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor<Diesel, Integer>(3, new Diesel(), new Seeder(26));
		t1.incConsumption(25);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor<Diesel, Integer>(4, new Diesel(), new Fertilizer(27));
		t1.incConsumption(39);
		t1.incOperatingHours(48);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor<Diesel, Integer>(5, new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");
	}

	private static void addTractorToKletzisFarm() {
		Farm farmKletzi = allFarms.get("Kletzis Farm");

		Tractor tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(
				2));
		tr.incOperatingHours(12);
		tr.incConsumption(19.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Fertilizer(3));
		tr.incOperatingHours(15);
		tr.incConsumption(24.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Seeder(8));
		tr.incOperatingHours(1);
		tr.incConsumption(5);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(7);
		tr.incConsumption(12);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(3);
		tr.incConsumption(29);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(4);
		tr.incConsumption(4.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Seeder(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);
		System.out.println(farmKletzi);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

	}

	private static void addTractorToNullFarm() {
		Farm farmKletzi = allFarms.get("Null Farm");
		Tractor tr = new Tractor<BioGas, Double>(100, new BioGas(), new Seeder(
				2));
		tr.incOperatingHours(11);
		tr.incConsumption(12.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<BioGas, Double>(101, new BioGas(), new Seeder(3));
		tr.incOperatingHours(11);
		tr.incConsumption(22.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<Diesel, Integer>(102, new Diesel(), new Fertilizer(8));
		tr.incOperatingHours(3);
		tr.incConsumption(8);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<Diesel, Integer>(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(2);
		tr.incConsumption(9);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<Diesel, Integer>(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(2);
		tr.incConsumption(13);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<BioGas, Double>(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(34);
		tr.incConsumption(44.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor<Diesel, Integer>(106, new Diesel(), new Fertilizer(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

	}

	private static void addTractorToPetersFarm() {
		Farm farm = allFarms.get("Peter's Farm");

		Tractor tr = new Tractor<Diesel, Integer>(1, new Diesel(),
				new Seeder(5));
		tr.incConsumption(18);
		tr.incOperatingHours(100);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor<Diesel, Integer>(2, new Diesel(), new Fertilizer(10));
		tr.incConsumption(15);
		tr.incOperatingHours(250);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor<BioGas, Double>(3, new BioGas(), new Fertilizer(4));
		tr.incConsumption(20.5);
		tr.incOperatingHours(120);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor<BioGas, Double>(4, new BioGas(), new Seeder(7));
		tr.incConsumption(19.3);
		tr.incOperatingHours(400);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

	}

	private static void changeTractorsAtKoeglersFarm() {
		Farm myFarm = allFarms.get(("Koeglers Farm"));

		// increase Seeders AVG Operating Hours, and their consumption
		Tractor t1 = myFarm.getTractor(5);

		System.out.println(t1.toString());
		System.out.println("Increment Operation Hours by 5");
		System.out.println("Increment Consumption by 25");

		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incConsumption(25);
		}

		System.out.println(t1.toString());

		t1 = myFarm.getTractor(1);

		System.out.println(t1.toString());
		System.out.println("Increment Operation Hours by 5");
		System.out.println("Increment Consumption by 25");

		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incOperatingHours(25);
		}

		System.out.println(t1.toString());

	}

	private static void removeTractorsFromKoeglersFarm() {
		Farm myFarm = allFarms.get(("Koeglers Farm"));

		myFarm.removeTractor(3);
		System.out.println("Traktor mit der ID 3 aus Koeglers Farm geloescht!");

		myFarm.removeTractor(1);
		System.out.println("Traktor mit der ID 1 aus Koeglers Farm geloescht!");
	}

	private static void addNewTractorsToKoeglersFarm() {
		Farm myFarm = allFarms.get(("Koeglers Farm"));

		Tractor t1 = new Tractor<BioGas, Double>(33, new BioGas(),
				new Fertilizer(30));
		t1.incConsumption(20.);
		t1.incOperatingHours(8);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");
	}

	private static void displayFarmStatistic() {
		Iterator<Farm> iti = allFarms.iterator();
		while (iti.hasNext()) {
			prnt(iti.next());
		}
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
