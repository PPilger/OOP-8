import java.lang.reflect.Method;

//TODO: tests erstellen
//TODO: annotationen hinzufügen
//TODO: generics entfernen
//TODO: tests nochmal durchfuehren
public class Test {

	static Map allFarms = new Map(); // key: String, value: Farm

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
		System.out.println("########################################################");
		System.out.println("############### Test #0 - Generate Farms ###############");
		System.out.println("########################################################");
		System.out.println();
		
		createKoeglersFarm();
		createKletzisFarm();
		createNullFarm();
		createPetersFarm();

		System.out.println();
		
		/**
		 * add Tractors to Farm's
		 */
		System.out.println("########################################################");
		System.out.println("############### Test #1 - Add Tractors to the Farms ####");
		System.out.println("########################################################");
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Koeglers Farm --------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addTractorToKoeglersFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Kletzis Farm ---------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addTractorToKletzisFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Null's Farm ----------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addTractorToNullFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Peters Farm ----------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addTractorToPetersFarm();

		System.out.println();
		
		/**
		 * change Tractors at Farm's
		 */
		System.out.println("########################################################");
		System.out.println("############### Test #2 - Change Tractors at the Farms #");
		System.out.println("########################################################");
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Change at Koeglers Farm -----------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		changeTractorsAtKoeglersFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Change at Koeglers Farm -----------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		changeTractorsAtKletzisFarm();

		System.out.println();
		
		/**
		 * remove Tractors from Farm's
		 */
		System.out.println("########################################################");
		System.out.println("############## Test #3 - Remove Tractors from the Farm #");
		System.out.println("########################################################");
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Remove Tractors at Koeglers Farm --------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		removeTractorsFromKoeglersFarm();

		System.out.println();
		
		/**
		 * add new Tractors to Farm's
		 */
		System.out.println("########################################################");
		System.out.println("############## Test #4 - Add new Tractors to the Farms #");
		System.out.println("########################################################");
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Koeglers Farm --------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addNewTractorsToKoeglersFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Add to Kletzis Farm ---------------------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		addNewTractorsToKletzisFarm();
		
		System.out.println();
		
		System.out.println("-------------------------------------------------------");
		System.out.println("+----------- Print statistical Informations ----------+");
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		displayFarmStatistic();

		System.out.println();
		
		/**
		 * display Annotations
		 */
		displayAnnotations();

	}

	private static void createKoeglersFarm() {
		Farm myFarm = new Farm("Koeglers Farm");
		allFarms.put(myFarm.getName(), myFarm);
		System.out.println("Koeglers Farm erstellt");
	}

	private static void createKletzisFarm() {
		Farm myFarm = new Farm("Kletzis Farm");
		allFarms.put(myFarm.getName(), myFarm);
		System.out.println("Kletzis Farm erstellt");
	}

	private static void createNullFarm() {
		Farm myFarm = new Farm("Null Farm");
		allFarms.put(myFarm.getName(), myFarm);
		System.out.println("Nulls Farm erstellt");
	}

	private static void createPetersFarm() {
		Farm myFarm = new Farm("Peter's Farm");
		allFarms.put(myFarm.getName(), myFarm);
		System.out.println("Peter's Farm erstellt");
	}

	private static void addTractorToKoeglersFarm() {
		Farm myFarm = (Farm) allFarms.get("Koeglers Farm");

		Tractor t1 = new Tractor(0, new BioGas(),
				new Seeder(13));
		t1.incConsumption(25.);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor(1, new BioGas(), new Seeder(14));
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor(2, new BioGas(), new Fertilizer(15));
		t1.incConsumption(37.);
		t1.incOperatingHours(25);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor(3, new Diesel(), new Seeder(26));
		t1.incConsumption(25);
		t1.incOperatingHours(5);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor(4, new Diesel(), new Fertilizer(27));
		t1.incConsumption(39);
		t1.incOperatingHours(48);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");

		t1 = new Tractor(5, new Diesel(), new Seeder(28));
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");
	}

	private static void addTractorToKletzisFarm() {
		Farm farmKletzi = (Farm) allFarms.get("Kletzis Farm");

		Tractor tr = new Tractor(100, new BioGas(), new Seeder(
				2));
		tr.incOperatingHours(12);
		tr.incConsumption(19.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(101, new BioGas(), new Fertilizer(3));
		tr.incOperatingHours(15);
		tr.incConsumption(24.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(102, new Diesel(), new Seeder(8));
		tr.incOperatingHours(1);
		tr.incConsumption(5);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(7);
		tr.incConsumption(12);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(3);
		tr.incConsumption(29);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(4);
		tr.incConsumption(4.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

		tr = new Tractor(106, new Diesel(), new Seeder(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Kletzis Farm");

	}

	private static void addTractorToNullFarm() {
		Farm farmKletzi = (Farm) allFarms.get("Null Farm");
		Tractor tr = new Tractor(100, new BioGas(), new Seeder(
				2));
		tr.incOperatingHours(11);
		tr.incConsumption(12.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(101, new BioGas(), new Seeder(3));
		tr.incOperatingHours(11);
		tr.incConsumption(22.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(102, new Diesel(), new Fertilizer(8));
		tr.incOperatingHours(3);
		tr.incConsumption(8);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(103, new Diesel(), new Fertilizer(5));
		tr.incOperatingHours(2);
		tr.incConsumption(9);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(104, new Diesel(), new Fertilizer(9));
		tr.incOperatingHours(2);
		tr.incConsumption(13);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(105, new BioGas(), new Seeder(9));
		tr.incOperatingHours(34);
		tr.incConsumption(44.0);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

		tr = new Tractor(106, new Diesel(), new Fertilizer(1));
		tr.incOperatingHours(10);
		tr.incConsumption(4);
		farmKletzi.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Null's Farm");

	}

	private static void addTractorToPetersFarm() {
		Farm farm = (Farm) allFarms.get("Peter's Farm");

		Tractor tr = new Tractor(1, new Diesel(),
				new Seeder(5));
		tr.incConsumption(18);
		tr.incOperatingHours(100);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor(2, new Diesel(), new Fertilizer(10));
		tr.incConsumption(15);
		tr.incOperatingHours(250);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor(3, new BioGas(), new Fertilizer(4));
		tr.incConsumption(20.5);
		tr.incOperatingHours(120);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

		tr = new Tractor(4, new BioGas(), new Seeder(7));
		tr.incConsumption(19.3);
		tr.incOperatingHours(400);
		farm.addTractor(tr);

		System.out.println(tr.toString() + " hinzufuegefuegt zu Peters Farm");

	}

	private static void changeTractorsAtKoeglersFarm() {
		Farm myFarm = (Farm) allFarms.get(("Koeglers Farm"));

		// increase Seeders AVG Operating Hours, and their consumption
		Tractor t1 = myFarm.getTractor(5);

		System.out.println("Old Entry: " + t1.toString());
		System.out.println("|---- Increment Operation Hours by 5");
		System.out.println("|---- Increment Consumption by 25");

		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incConsumption(25);
		}

		System.out.println("New Entry: " + t1.toString());

		t1 = myFarm.getTractor(1);

		System.out.println("Old Entry: " + t1.toString());
		System.out.println("|---- Increment Operation Hours by 5");
		System.out.println("|---- Increment Operation Hours by 25");

		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incOperatingHours(25);
		}

		System.out.println("New Entry: " + t1.toString());

	}

	private static void changeTractorsAtKletzisFarm() {
		Farm myFarm = (Farm) allFarms.get("Kletzis Farm");
		
		// increase Seeders AVG Operating Hours, and their consumption
		Tractor t1 = myFarm.getTractor(100);

		System.out.println("Old Entry: " + t1.toString());
		System.out.println("|---- Increment Operation Hours by 5");
		System.out.println("|---- Increment Consumption by 25");

		if (t1 != null) {
			t1.incOperatingHours(5);
			t1.incConsumption(25.);
		}

		System.out.println("New Entry: " + t1.toString());
		
		int operatingHours = t1.getOperatingHours();
		Number consumption = t1.getConsumption();
		
		System.out.println("*Read out values from Tractor: OperationHours ("+ operatingHours +") Consumption ("+ consumption + ")");
		
	}

	
	private static void removeTractorsFromKoeglersFarm() {
		Farm myFarm = (Farm) allFarms.get("Koeglers Farm");

		myFarm.removeTractor(3);
		System.out.println("Traktor mit der ID 3 aus Koeglers Farm geloescht!");

		myFarm.removeTractor(1);
		System.out.println("Traktor mit der ID 1 aus Koeglers Farm geloescht!");
	}

	private static void addNewTractorsToKoeglersFarm() {
		Farm myFarm = (Farm) allFarms.get("Koeglers Farm");

		Tractor t1 = new Tractor(33, new BioGas(),
				new Fertilizer(30));
		t1.incConsumption(20.);
		t1.incOperatingHours(8);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Koeglers Farm");
	}
	
	private static void addNewTractorsToKletzisFarm() {
		Farm myFarm = (Farm) allFarms.get("Kletzis Farm");

		Tractor t1 = new Tractor(33, new BioGas(),
				new Fertilizer(30));
		t1.incConsumption(20.);
		t1.incOperatingHours(8);
		myFarm.addTractor(t1);

		System.out.println(t1.toString() + " hinzufuegefuegt zu Kletzis Farm");
	}

	private static void displayFarmStatistic() {
		Iterator iti = allFarms.iterator();
		while (iti.hasNext()) {
			print((Farm) iti.next());
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
	private static void print(Farm myFarm) {
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
