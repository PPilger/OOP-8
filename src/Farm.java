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

	private <K, V> Map<K, V> fold(Aggregator<Tractor, K, V> aggregator) {
		Iterator<Tractor> it = myTractors.iterator();

		while (it.hasNext()) {
			Tractor tractor = it.next();
			aggregator.add(tractor);
		}

		return aggregator.getAggregation();
	}

	private <T> Map<Object, T> foldRoles(Combinator<Tractor, T> comb) {
		return fold(new RoleAggregator<T>(comb));
	}

	private <T extends Number> Map<Object, Double> roleAvg(
			Combinator<Tractor, T> comb) {
		Map<Object, T> sum = foldRoles(comb);
		Map<Object, Integer> count = foldRoles(new CountCombinator<Tractor>());

		return avg(sum, count);
	}

	private <K, V extends Number> Map<K, Double> avg(Map<K, V> sum,
			Map<K, Integer> count) {
		Map<K, Double> avg = new Map<K, Double>();
		
		Iterator<K> iter = sum.keyIterator();
		while (iter.hasNext()) {
			K key = iter.next();
			avg.put(key, sum.get(key).doubleValue()
					/ count.get(key).doubleValue());
		}

		return avg;
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
		return roleAvg(new DieselCombinator());
	}

	public Map<Object, Double> avgBioGasUsage() {
		return roleAvg(new BioGasCombinator());
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
