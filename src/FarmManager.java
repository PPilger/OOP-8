public class FarmManager {
	
	private Map<String, Farm> myFarms = new Map<String, Farm>();
	private Map<Integer, Tractor> allTractors = new Map<Integer, Tractor>();
	
	public FarmManager()
	{
		
	}
	
	public boolean addFarm(Farm newFarm)
	{
		if(myFarms.get(newFarm.getName()) != null)
		{
			//Farm already exists in Map
			return false;
		}
		
		myFarms.put(newFarm.getName(), newFarm);
		return true;
	}
	
	
	
	public boolean addTractor(String farm, Tractor newTractor)
	{
		if(myFarms.get(farm) == null || allTractors.get(newTractor.getID()) != null)
		{
			//Either farm doesn't exist or tractor already exists
			return false;
		}
		
		allTractors.put(newTractor.getID(), newTractor);
		myFarms.get(farm).addTractor(newTractor);
		return true;
	}
	
	public boolean removeTractor(int id)
	{
		if(allTractors.get(id) == null)
		{
			//Tractor doesn't exist
			return false;
		}
		
		Iterator<Farm> t = myFarms.iterator();
		while(t.hasNext())
		{
			Farm f = t.next();
			f.removeTractor(id);
		}		
		return false;		
	}
	
	public Map<String, Farm> getFarms()
	{
		return myFarms;		
	}
	
	public Farm getFarm(String name)
	{
		return myFarms.get(name);
	}
	
	

}
