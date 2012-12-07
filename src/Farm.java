public class Farm {

	private Map<Integer, Tractor> myTractors;// Todo: Pilgis Collection
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

	public Map<Object, Double> avgOperatingHours() {
		return roleAvg(new OperatingHoursMerger());
	}

	public Map<Object, Double> avgDieselUsage() {
		return roleAvg(new DieselMerger());
	}

	public Map<Object, Double> avgBioGasUsage() {
		return roleAvg(new BioGasMerger());
	}

	public int minCoulterCount() {
		return 0;
	}

	public int maxCoulterCount() {
		return 0;
	}

	public double avgCapacity() {
		return 0;
	}

}
