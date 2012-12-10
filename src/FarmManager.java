/**
 * Manages farms/tractors, each of them will be unique by their name/id
 * 
 * @author Koegler Alexander
 */
@Author("Koegler Alexander")
public class FarmManager {
	
	private Map<String, Farm> myFarms = new Map<String, Farm>();
	private Map<Integer, Tractor> allTractors = new Map<Integer, Tractor>();
	
	/**
	 * Adds unique farm
	 * @param newFarm
	 * @return false if farm already exists
	 */
	@Author("Koegler Alexander")
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
	
	
	/**
	 * Adds unique tractor to existing farm
	 * @param farm
	 * @param newTractor
	 * @return false if tractor already exists, or farm doesn't
	 */
	@Author("Koegler Alexander")
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
	
	/**
	 * Removes tractor from any farm
	 * @param id of the tractor
	 * @return false if there is no such tractor with this id
	 */
	@Author("Koegler Alexander")
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
	
	/**
	 * Returns an existing farm by its unique name
	 * @return farm; null if there's no such farm
	 */
	@Author("Koegler Alexander")
	public Farm getFarm(String name)
	{
		return myFarms.get(name);		
	}
}
