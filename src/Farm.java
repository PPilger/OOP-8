public class Farm {

	private Map<Integer, Tractor> myTractors;//Todo: Pilgis Collection
	private final String name;
	
	public Farm(String name)
	{
		this.name = name;
		this.myTractors = new Map<Integer, Tractor>();
	}
	
	public void addTractor(Tractor tr)
	{
		this.myTractors.put(tr.getID(), tr);
	}
	
	public void removeTractor(int id)
	{
		myTractors.remove(id);
	}
	
	public void changeRole(int id, TractorRole tr)
	{
		myTractors.get(id);
	}
	
	public Map<String, Double> avgOperatingHours()
	{
		double sumSeeder = 0;
		double sumFertilizer = 0;
		int cntSeeder = 0;
		int cntFertilizer = 0;
		
		Iterator<Tractor> it = myTractors.iterator();
		
		while(it.hasNext()) {
			Tractor tr = it.next();
			if(tr.getRole().getClass() == Seeder.class) {
				sumSeeder += tr.getOperatingHours();
				cntSeeder += 1;
			} else if(tr.getRole().getClass() == Fertilizer.class) {
				sumFertilizer += tr.getOperatingHours();
				cntFertilizer += 1;
			}
		}
		
		Map<String, Double> result = new Map<String, Double>();
		result.put("All", ((sumSeeder+sumFertilizer)/(cntSeeder+cntFertilizer)));
		result.put("Seeder", sumSeeder/cntSeeder);
		result.put("Fertilizer", sumFertilizer/cntFertilizer);
		
		return result;
	}
	
	public double avgDieselUsage()
	{
		return 0;
	}
	
	public double avgBioGasUsage()
	{
		return 0;
	}
	
	public int minCoulterCount()
	{
		return 0;
	}
	
	public int maxCoulterCount()
	{
		return 0;
	}
	
	public double avgCapacity()
	{
		return 0;
	}
	
}
