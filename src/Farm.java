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

	private <I, T> void fold(Identifier<Tractor, I> identifier,
			Combinator<Tractor, T> comb, Map<I, T> target) {
		Iterator<Tractor> it = myTractors.iterator();
		Iterator<I> keyIter;

		while (it.hasNext()) {
			Tractor tr = it.next();
			keyIter = target.keyIterator();

			while (keyIter.hasNext()) {
				I key = keyIter.next();
				if (identifier.equals(tr, key)) {
					T value = target.get(key);
					value = comb.add(tr, value);
					target.put(key, value);
				}
			}
		}
	}

	private <T> Map<Object, T> foldRoles(Combinator<Tractor, T> comb,
			T initValue) {
		Map<Object, T> map = new Map<Object, T>();
		map.put(Seeder.class, initValue);
		map.put(Fertilizer.class, initValue);
		map.put(null, initValue);

		fold(new RoleIdentifier(), comb, map);

		return map;
	}

	private <T extends Number> Map<Object, Double> roleAvg(Combinator<Tractor, T> comb, T initValue) {
		Map<Object, T> sum = foldRoles(comb, initValue);
		Map<Object, Integer> count = foldRoles(new CountCombinator<Tractor>(),
				new Integer(0));

		return avg(sum, count);
	}

	private <K, V1 extends Number, V2 extends Number> Map<K, Double> avg(
			Map<K, V1> sum, Map<K, V2> count) {
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
		return roleAvg(new DieselCombinator(), new Integer(0));
	}

	public Map<Object, Double> avgBioGasUsage() {
		return roleAvg(new BioGasCombinator(), new Double(0));
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
