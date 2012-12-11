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

	@Author("Kšgler Alexander")
	public void addTractor(Tractor tr) {
		this.myTractors.put(tr.getID(), tr);
	}

	@Author("Koegler Alexander")
	public String getName() {
		return name;
	}

	@Author("Kšgler Alexander")
	public void removeTractor(int id) {
		myTractors.remove(id);
	}

	@Author("Kšgler Alexander")
	public void changeRole(int id, TractorRole tr) {
		myTractors.get(id);
	}

	@Author("Kletzander Christian")
	public Map<String, Double> avgOHPerRole() {
		return roleAvg(new OperatingHoursMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Double> avgOHPerFuel() {
		return fuelAvg(new OperatingHoursMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Double> avgDieselUsagePerRole() {
		return roleAvg(new DieselMerger());
	}

	@Author("Kletzander Christian")
	public Map<String, Double> avgBioGasUsagePerRole() {
		return roleAvg(new BioGasMerger());
	}

	@Author("Peter Pilgerstorfer")
	public Map<String, Integer> minCoultersPerFuel() {
		CoulterMerger cm = new CoulterMerger(
				new Combinator<Integer, Integer, Integer>() {

					@Override
					public Integer combine(Integer val1, Integer val2) {
						return Math.min(val1, val2);
					}
				});

		return foldFuels(cm);
	}

	@Author("Peter Pilgerstorfer")
	public Map<String, Integer> maxCoultersPerFuel() {
		CoulterMerger cm = new CoulterMerger(
				new Combinator<Integer, Integer, Integer>() {

					@Override
					public Integer combine(Integer val1, Integer val2) {
						return Math.max(val1, val2);
					}
				});

		return foldFuels(cm);
	}

	@Author("Kletzander Christian")
	public Map<String, Double> avgCapacityPerFuel() {
		return fuelAvg(new CapacityMerger());
	}

	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldRoles(Merger<Tractor, V> folder) {
		return myTractors.fold(new RoleDistributor<V>(folder));
	}

	@Author("Peter Pilgerstorfer")
	private <V> Map<String, V> foldFuels(Merger<Tractor, V> folder) {
		return myTractors.fold(new FuelDistributor<V>(folder));
	}

	@Author("Kletzander Christian")
	private <V extends Number> Map<String, Double> roleAvg(
			Merger<Tractor, V> comb) {
		Map<String, V> sum = foldRoles(comb);
		Map<String, Integer> count = foldRoles(new CountFolder<Tractor>());

		return avg(sum, count);
	}

	@Author("Kletzander Christian")
	private <V extends Number> Map<String, Double> fuelAvg(
			Merger<Tractor, V> comb) {
		Map<String, V> sum = foldFuels(comb);
		Map<String, Integer> count = foldFuels(new CountFolder<Tractor>());

		return avg(sum, count);
	}

	@Author("Peter Pilgerstorfer")
	private <K, V extends Number> Map<K, Double> avg(Map<K, V> sum,
			Map<K, Integer> count) {
		return sum.zip(count, new Combinator<V, Integer, Double>() {
			@Override
			public Double combine(V sum, Integer count) {
				return sum.doubleValue() / count.doubleValue();
			}
		});
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
