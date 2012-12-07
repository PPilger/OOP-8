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

	private <V extends Number> Map<Object, Double> roleAvg(
			Merger<Tractor, V> comb) {
		Map<Object, V> sum = foldRoles(comb);
		Map<Object, Integer> count = foldRoles(new CountFolder<Tractor>());

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

	public Map<String, Double> avgOperatingHours() {
		double sumSeeder = 0;
		double sumFertilizer = 0;
		int cntSeeder = 0;
		int cntFertilizer = 0;

		Iterator<Tractor> it = myTractors.iterator();

		while (it.hasNext()) {
			Tractor tr = it.next();
			if (tr.getRole().getClass() == Seeder.class) {
				sumSeeder += tr.getOperatingHours();
				cntSeeder += 1;
			} else if (tr.getRole().getClass() == Fertilizer.class) {
				sumFertilizer += tr.getOperatingHours();
				cntFertilizer += 1;
			}
		}

		Map<String, Double> result = new Map<String, Double>();
		result.put("All",
				((sumSeeder + sumFertilizer) / (cntSeeder + cntFertilizer)));
		result.put("Seeder", sumSeeder / cntSeeder);
		result.put("Fertilizer", sumFertilizer / cntFertilizer);

		return result;
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
