public class Farm {

	private Map<Integer, Tractor> myTractors;//Todo: Pilgis Collection
	private final String name;
	
	public Farm(String name)
	{
		this.name = name;
		this.myTractors = new Map<Integer, Tractor>();
	}
	
	public void AddTractor(Tractor tr)
	{
		this.myTractors.put(tr.getID(), tr);
	}
	
	public void RemoveTractor(int id)
	{
		myTractors.remove(id);
	}
	
	public double AvgOperatingHours()
	{
		double sum = 0;
		int cnt = 0;
		
		Iterator<Tractor> it = myTractors.iterator();
		while(it.hasNext()) {
			cnt++;
			Tractor tr = it.next();
			sum += tr.getOperatingHours();
		}
		
		return sum / cnt;
	}
	
	public double AvgDieselUsage()
	{
		return 0;
	}
	
	public double AvgBioGasUsage()
	{
		return 0;
	}
	
	public int MinCoulterCount()
	{
		return 0;
	}
	
	public int MaxCoulterCount()
	{
		return 0;
	}
	
	public double AvgCapacity()
	{
		return 0;
	}
	
}
