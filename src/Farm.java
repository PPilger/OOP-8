/**
 * Represents a Farm with the possibility to store tractors (Seeder &
 * Fertilizer). You can get statistical informations about tractors of the Farm.
 */
@Author("Kletzander Christian")
public class Farm {
	private final String name;
	private Map<Integer, Tractor> myTractors;

	/**
	 * Creates a Farm with the specified name.
	 */
	@Author("Kletzander Christian")
	public Farm(String name) {
		this.name = name;
		this.myTractors = new Map<Integer, Tractor>();
	}

	/**
	 * Adds tractor to the farm. If there is already a Tractor with the same id,
	 * the old one is replaced with tractor (id is unique).
	 */
	@Author("Koegler Alexander")
	public void addTractor(Tractor tractor) {
		this.myTractors.put(tractor.getID(), tractor);
	}

	/**
	 * Returns the name of the farm.
	 */
	@Author("Koegler Alexander")
	public String getName() {
		return name;
	}

	/**
	 * Returns the tractor with the specified id.
	 */
	@Author("Koegler Alexander")
	public Tractor getTractor(int id) {
		return this.myTractors.get(id);
	}

	/**
	 * Removes the tractor with the specified id.
	 */
	@Author("Koegler Alexander")
	public void removeTractor(int id) {
		myTractors.remove(id);
	}

	/**
	 * Changes the role of the tractor with the specified id to role.
	 */
	@Author("Koegler Alexander")
	public void changeRole(int id, TractorRole role) {
		myTractors.get(id).changeRole(role);
	}

	/**
	 * Calculates the average operating hours grouped by roles.
	 * 
	 * The keys of the map are Strings (the name of the role or "Total"). The
	 * values are Average objects.
	 */
	@Author("Kletzander Christian")
	public Map<String, Average> avgOHPerRole() {
		return foldRoles(new OperatingHoursMerger());
	}

	/**
	 * Calculates the average operating hours grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Kletzander Christian")
	public Map<String, Average> avgOHPerFuel() {
		return foldFuels(new OperatingHoursMerger());
	}

	/**
	 * Calculates the average total consumption of diesel tractors grouped by
	 * roles.
	 * 
	 * The keys of the map are Strings (the name of the role or "Total"). The
	 * values are Average objects.
	 */
	@Author("Kletzander Christian")
	public Map<String, Average> avgDieselUsagePerRole() {
		return foldRoles(new DieselMerger());
	}

	/**
	 * Calculates the average total consumption of bio gas tractors grouped by
	 * roles.
	 * 
	 * The keys of the map are Strings (the name of the role or "Total"). The
	 * values are Average objects.
	 */
	@Author("Kletzander Christian")
	public Map<String, Average> avgBioGasUsagePerRole() {
		return foldRoles(new BioGasMerger());
	}

	/**
	 * Calculates the minimum amount of sowing coulters grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Peter Pilgerstorfer")
	public Map<String, Extremum> minCoultersPerFuel() {
		return foldFuels(new CoulterMerger(true));
	}

	/**
	 * Calculates the maximum amount of sowing coulters grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Peter Pilgerstorfer")
	public Map<String, Extremum> maxCoultersPerFuel() {
		return foldFuels(new CoulterMerger(false));
	}

	/**
	 * Calculates the average fertilizer capacity grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Kletzander Christian")
	public Map<String, Average> avgCapacityPerFuel() {
		return foldFuels(new CapacityMerger());
	}

	/**
	 * Uses the specified merger to perform a fold operations on the tractors.
	 * The tractors are folded per role and the result is stored under the
	 * role-name in the result-map.
	 * 
	 * The keys of the map are Strings (the name of the role or "Total"). The
	 * values are dependent on the result-type of merger.
	 */
	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldRoles(Merger<Tractor, V> merger) {
		return myTractors.fold(new RoleDistributor<V>(merger));
	}

	/**
	 * Uses the specified merger to perform a fold operations on the tractors.
	 * The tractors are folded per fuel and the result is stored under the
	 * fuel-name in the result-map.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The
	 * values are dependent on the result-type of merger.
	 */
	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldFuels(Merger<Tractor, V> merger) {
		return myTractors.fold(new FuelDistributor<V>(merger));
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
