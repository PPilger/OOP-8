
public class Fertilizer extends TractorBase {

	private final double capacity;
	public Fertilizer(int id, double capacity) {
		super(id);
		this.capacity = capacity;
	}
	
	public double getCapacity()
	{
		return this.capacity;
	}

}
