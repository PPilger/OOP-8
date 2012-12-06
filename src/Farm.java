import java.util.*;


public class Farm {

	private Map<Integer, Tractor> myTractors;//Todo: Pilgis Collection
	private final String name;
	
	public Farm(String name)
	{
		this.name = name;
		//TODO: init Map
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
		return 0;
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
