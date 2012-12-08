@AnClass (author="Kletzander Christian",
describtion="A seeder's equiped with an integer amount of sowing coulters")
public class Seeder implements TractorRole {
	private int coulter;

	/**
	 * @param coulter amount of sowing coulters
	 */
	@AnClass (author="Kletzander Christian")
	public Seeder(int coulter) {
		this.coulter = coulter;
	}

	/**
	 * @return amount of sowing coulters
	 */
	@Override
	@AnClass (author="Kletzander Christian")
	public Integer getAttribute() {
		return coulter;
	}
}
