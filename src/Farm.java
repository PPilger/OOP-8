
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

	private <I, T extends Number> void avg(ValueGetter<Tractor, I> identifier,
			Calc<T> calc, Map<I, T> target) {
		Iterator<Tractor> it = myTractors.iterator();
		Iterator<I> keyIter;
		Map<I, Integer> counter = new Map<I, Integer>();

		keyIter = target.keyIterator();
		while (keyIter.hasNext()) {
			I key = keyIter.next();
			counter.put(key, 0);
		}

		while (it.hasNext()) {
			Tractor tr = it.next();
			I o = identifier.getValue(tr);

			while (keyIter.hasNext()) {
				I key = keyIter.next();
				if (o.equals(key)) {
					T sum = target.get(key);
					Integer count = counter.get(key);

					sum = calc.inc(sum, tr);
					count++;

					target.put(key, sum);
					counter.put(key, count);
				}
			}
		}

		keyIter = target.keyIterator();
		while (keyIter.hasNext()) {
			I key = keyIter.next();

			T sum = target.get(key);
			Integer count = counter.get(key);

			T avg = calc.avg(sum, count);

			target.put(key, avg);
		}
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

	public double avgDieselUsage() {
		return 0;
	}

	public double avgBioGasUsage() {
		return 0;
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
