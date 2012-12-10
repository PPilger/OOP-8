@Author ("Kletzander Christian")
/*
 * A seeder's equiped with an integer amount of sowing coulters
 */
public class Seeder implements TractorRole {
	private int coulter;

	/**
	 * @param coulter amount of sowing coulters
	 */
	@Author ("Kletzander Christian")
	public Seeder(int coulter) {
		this.coulter = coulter;
	}

	/**
	 * @return amount of sowing coulters
	 */
	@Override
	@Author ("Kletzander Christian")
	public Integer getAttribute() {
		return coulter;
	}
}
