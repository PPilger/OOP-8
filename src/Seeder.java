public class Seeder implements TractorRole {
	private int coulter;

	public Seeder(int coulter) {
		this.coulter = coulter;
	}

	@Override
	public Integer getAttribute() {
		return coulter;
	}
}
