
public class Fertilizer extends TraktorBase {

	private final double capacity;
	public Fertilizer(int id, double capacity) {
		super(id);
		this.capacity = capacity;
	}
	
	public double GetCapacity()
	{
		return this.capacity;
	}

}
