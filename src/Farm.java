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
	
	public double avgOperatingHours()
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
