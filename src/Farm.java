@Author("Kletzander Christian")
/*
 * Creates a Farm with the possibility to save an amount of tractors (Seeder &
 * Fertilizer). You can get statistical informations about the OperatingHours of
 * the tractors and the average of the consumption, ...
 */
public class Farm {
	private final String name;
	private Map<Integer, Tractor> myTractors;

	@Author("Kletzander Christian")
	public Farm(String name) {
		this.name = name;
		this.myTractors = new Map<Integer, Tractor>();
	}

	@Author("Koegler Alexander")
	public void addTractor(Tractor tr) {
		this.myTractors.put(tr.getID(), tr);
	}

	@Author("Koegler Alexander")
	public String getName() {
		return name;
	}

	@Author("Koegler Alexander")
	public void removeTractor(int id) {
		myTractors.remove(id);
	}

	@Author("Koegler Alexander")
	public void changeRole(int id, TractorRole tr) {
		myTractors.get(id);
	}

	@Author("Kletzander Christian")
	public Map<String, Average<Integer>> avgOHPerRole() {
		return foldRoles(new OperatingHoursMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Average<Integer>> avgOHPerFuel() {
		return foldFuels(new OperatingHoursMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Average<Integer>> avgDieselUsagePerRole() {
		return foldRoles(new DieselMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Average<Double>> avgBioGasUsagePerRole() {
		return foldRoles(new BioGasMerger());
	}

	@Author("Peter Pilgerstorfer")
	public Map<String, Extremum> minCoultersPerFuel() {
		return foldFuels(new CoulterMerger(true));
	}

	@Author("Peter Pilgerstorfer")
	public Map<String, Extremum> maxCoultersPerFuel() {
		return foldFuels(new CoulterMerger(false));
	}

	@Author("Kletzander Christian")
	public Map<String, Average<Double>> avgCapacityPerFuel() {
		return foldFuels(new CapacityMerger());
	}

	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldRoles(Merger<Tractor, V> folder) {
		return myTractors.fold(new RoleDistributor<V>(folder));
	}

	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldFuels(Merger<Tractor, V> folder) {
		return myTractors.fold(new FuelDistributor<V>(folder));
	}

	@Override
	@Author("Kletzander Christian")
	public String toString() {
		Iterator<Tractor> it = myTractors.iterator();
		StringBuilder sb = new StringBuilder();

		sb.append(name + ":\n");

		while (it.hasNext()) {
			sb.append(it.next().toString() + "\n");
		}

		return sb.toString();
	}
}
