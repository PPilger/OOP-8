@AnClass(author="Koegler Alexander",
describtion="Implements a Diesel-Fuel which uses Integer-Type for calculations")
public class Diesel implements Fuel<Integer> {
	private int liter;
	
	/**
	 * @param liter Initial amount of consumed fuelin liters
	 */
	@AnClass(author="Koegler Alexander")
	public Diesel(int liter) {
		this.liter = liter;
	}
	
	@Override
	@AnClass(author="Koegler Alexander")
	public Integer getAmount() {
		return liter;
	}

	@Override
	@AnClass(author="Koegler Alexander")
	public void incAmount(Integer amount) {
		liter += amount;
	}
}
