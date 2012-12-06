public class Seeder extends TraktorBase{

	private int coulter;
	
	public Seeder(int id, int coulter)
	{
		super(id);
		this.coulter = coulter;
	}	
	
	public int GetCoulter()
	{
		return coulter;
	}	
}
