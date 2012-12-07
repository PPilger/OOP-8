public class Farm {

	private Map<Integer, Tractor> myTractors;
	private final String name;

	public Farm(String name) {
		this.name = name;
		this.myTractors = new Map<Integer, Tractor>();
	}

	public void addTractor(Tractor tr) {
		this.myTractors.put(tr.getID(), tr);
	}

	public void removeTractor(int id) {
		myTractors.remove(id);
	}

	public void changeRole(int id, TractorRole tr) {
		myTractors.get(id);
	}

	public Map<Object, Double> avgOHPerRole() {
		return roleAvg(new OperatingHoursMerger());
	}

	public Map<Object, Double> avgOHPerFuel() {
		return fuelAvg(new OperatingHoursMerger());
	}

	public Map<Object, Double> avgDieselUsagePerRole() {
		return roleAvg(new DieselMerger());
	}

	public Map<Object, Double> avgBioGasUsagePerRole() {
		return roleAvg(new BioGasMerger());
	}

	public Map<Object, Integer> minCoultersPerFuel() {
		CoulterMerger cm = new CoulterMerger(
				new Combinator<Integer, Integer, Integer>() {

					@Override
					public Integer combine(Integer val1, Integer val2) {
						return Math.min(val1, val2);
					}
				});

		return foldFuels(cm);
	}

	public Map<Object, Integer> maxCoultersPerFuel() {
		CoulterMerger cm = new CoulterMerger(
				new Combinator<Integer, Integer, Integer>() {

					@Override
					public Integer combine(Integer val1, Integer val2) {
						return Math.max(val1, val2);
					}
				});

		return foldFuels(cm);
	}

	public Map<Object, Double> avgCapacityPerFuel() {
		return fuelAvg(new CapacityMerger());
	}

	private <V> Map<Object, V> foldRoles(Merger<Tractor, V> folder) {
		return myTractors.fold(new RoleDistributor<V>(folder));
	}

	private <V> Map<Object, V> foldFuels(Merger<Tractor, V> folder) {
		return myTractors.fold(new FuelDistributor<V>(folder));
	}

	private <V extends Number> Map<Object, Double> roleAvg(
			Merger<Tractor, V> comb) {
		Map<Object, V> sum = foldRoles(comb);
		Map<Object, Integer> count = foldRoles(new CountFolder<Tractor>());

		return avg(sum, count);
	}

	private <V extends Number> Map<Object, Double> fuelAvg(
			Merger<Tractor, V> comb) {
		Map<Object, V> sum = foldFuels(comb);
		Map<Object, Integer> count = foldFuels(new CountFolder<Tractor>());

		return avg(sum, count);
	}

	private <K, V extends Number> Map<K, Double> avg(Map<K, V> sum,
			Map<K, Integer> count) {
		return sum.zip(count, new Combinator<V, Integer, Double>() {
			@Override
			public Double combine(V sum, Integer count) {
				return sum.doubleValue() / count.doubleValue();
			}
		});
	}
}
