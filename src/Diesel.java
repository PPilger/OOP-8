@Author(value="Koegler Alexander",
describtion="Implements a Diesel-Fuel which uses Integer-Type for calculations")
public class Diesel implements Fuel<Integer> {
	private int liter;
	
	/**
	 * @param liter Initial amount of consumed fuelin liters
	 */
	@Author(value="Koegler Alexander")
	public Diesel(int liter) {
		this.liter = liter;
	}
	
	@Override
	@Author(value="Koegler Alexander")
	public Integer getAmount() {
		return liter;
	}

	@Override
	@Author(value="Koegler Alexander")
	public void incAmount(Integer amount) {
		liter += amount;
	}
}
