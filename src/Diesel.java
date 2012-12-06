
public class Diesel implements Fuel<Integer> {
	private int liter;
	
	public Diesel(int liter) {
		this.liter = liter;
	}
	
	@Override
	public Integer getAmount() {
		return liter;
	}

	@Override
	public void incAmount(Integer amount) {
		liter += amount;
	}
}
