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

	public Map<Object, Integer> minCoulterCount() {
		CoulterMerger cm = new CoulterMerger(new Combinator<Integer, Integer, Integer>() {
			
			@Override
			public Integer combine(Integer val1, Integer val2) {
				return Math.min(val1, val2);				
			}
		});
		
		return foldFuels(cm);
	}

	public Map<Object, Integer> maxCoulterCount() {
		CoulterMerger cm = new CoulterMerger(new Combinator<Integer, Integer, Integer>() {
			
			@Override
			public Integer combine(Integer val1, Integer val2) {
				return Math.max(val1, val2);				
			}
		});
		
		return foldFuels(cm);
	}

	public Map<Object, Double> avgCapacity() {
		return fuelAvg(new CapacityMerger(new Combinator<Double, Double, Double>() {
			
			@Override
			public Double combine(Double val1, Double val2) {
				return val1 + val2;
			}
		}));
	}

}
