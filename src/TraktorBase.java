public abstract class TraktorBase implements Traktor{

	private final int id;
	private Engine eng;
	private int operatingHours;
	
	public TraktorBase(int id)
	{
		this.id = id;
		this.operatingHours = 0;
	}
	
	@Override
	public int IncOperatingHours(int addHours) {
		if(addHours > 0)
			this.operatingHours += addHours;
		return this.operatingHours;
	}

	@Override
	public int GetOperatingHours() {
		return this.operatingHours;				
	}
	
	@Override
	public Engine ChangeEngine(Engine t) {
		this.eng = t;
		return this.eng;
	}


}
