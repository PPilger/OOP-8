
public class Diesel implements Fuel<Integer> {
	private int liter;
	
	public Diesel(int liter) {
		this.liter = liter;
	}

	@Override
	public void incAmount(Integer amount) {
		liter += amount;
	}
	
	@Override
	public Integer getAmount() {
		return liter;
	}
}
