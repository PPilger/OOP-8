public abstract class TractorBase implements Tractor {

	private final int id;
	private Engine eng;
	private int operatingHours;

	public TractorBase(int id) {
		this.id = id;
		this.operatingHours = 0;
	}

	@Override
	public int incOperatingHours(int addHours) {
		if (addHours > 0)
			this.operatingHours += addHours;
		return this.operatingHours;
	}

	@Override
	public int getOperatingHours() {
		return this.operatingHours;
	}
}
