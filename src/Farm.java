/**
 * Represents a Farm with the possibility to store tractors (Seeder &
 * Fertilizer). You can get statistical informations about tractors of the Farm.
 */
@Author("Kletzander Christian")
public class Farm {
	private final String name;
	private Map myTractors; // key: Integer, value: Tractor

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
		return (Tractor) this.myTractors.get(id);
	}

	/**
	 * Removes the tractor with the specified id.
	 */
	@Author("Koegler Alexander")
	public void removeTractor(int id) {
		myTractors.remove(id);
	}

	/**
	 * Calculates the average operating hours grouped by roles.
	 * 
	 * The keys of the map are Strings (the name of the role or "Total"). The
	 * values are Average objects.
	 */
	@Author("Kletzander Christian")
	public Map avgOHPerRole() {
		return foldRoles(new OperatingHoursMerger());
	}

	/**
	 * Calculates the average operating hours grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Kletzander Christian")
	public Map avgOHPerFuel() {
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
	public Map avgDieselUsagePerRole() {
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
	public Map avgBioGasUsagePerRole() {
		return foldRoles(new BioGasMerger());
	}

	/**
	 * Calculates the minimum amount of sowing coulters grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Extremum objects.
	 */
	@Author("Peter Pilgerstorfer")
	public Map minCoultersPerFuel() {
		return foldFuels(new CoulterMerger(true));
	}

	/**
	 * Calculates the maximum amount of sowing coulters grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Extremum objects.
	 */
	@Author("Peter Pilgerstorfer")
	public Map maxCoultersPerFuel() {
		return foldFuels(new CoulterMerger(false));
	}

	/**
	 * Calculates the average fertilizer capacity grouped by fuels.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * Average objects.
	 */
	@Author("Kletzander Christian")
	public Map avgCapacityPerFuel() {
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
	private Map foldRoles(Merger merger) {
		return myTractors.fold(new RoleDistributor(merger));
	}

	/**
	 * Uses the specified merger to perform a fold operations on the tractors.
	 * The tractors are folded per fuel and the result is stored under the
	 * fuel-name in the result-map.
	 * 
	 * The keys of the map are Strings (the name of the fuel). The values are
	 * dependent on the result-type of merger.
	 */
	@Author("Peter Pilgerstorfer")
	private Map foldFuels(Merger merger) {
		return myTractors.fold(new FuelDistributor(merger));
	}

	@Override
	@Author("Kletzander Christian")
	public String toString() {
		Iterator tractorIter = myTractors.iterator();
		StringBuilder sb = new StringBuilder();

		sb.append(name + ":\n");

		while (tractorIter.hasNext()) {
			sb.append(tractorIter.next().toString() + "\n");
		}

		return sb.toString();
	}
}
