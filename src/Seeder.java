public class Seeder extends TractorBase{

	private int coulter;
	
	public Seeder(int id, int coulter)
	{
		super(id);
		this.coulter = coulter;
	}	
	
	public int getCoulter()
	{
		return coulter;
	}	
}
