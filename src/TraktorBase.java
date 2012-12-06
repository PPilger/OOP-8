public abstract class TraktorBase implements Traktor{

	private final int id;
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
	public Traktor ChangeType(Traktor t) {
		return null; //Todo: return new Traktor
	}

}
