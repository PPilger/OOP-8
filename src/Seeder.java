/**
 * Represents the role seeder. The amount of sowing coulters is stored.
 */
@Author("Kletzander Christian")
public class Seeder implements TractorRole {
	private int coulter;

	/**
	 * @param coulter
	 *            amount of sowing coulters
	 */
	@Author("Kletzander Christian")
	public Seeder(int coulter) {
		this.coulter = coulter;
	}

	/**
	 * @return amount of sowing coulters
	 */
	@Override
	@Author("Kletzander Christian")
	public Integer getAttribute() {
		return coulter;
	}
	
	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		return "Seeder (" + coulter + " coulters)";
	}
}
