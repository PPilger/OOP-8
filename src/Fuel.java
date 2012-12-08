@AnClass (author="Koegler Alexander", describtion="Represents total amount of fuel consumption")
public interface Fuel<T extends Number> {
	
	/**
	 * 
	 * @return total amount of fuel consumption, shall always be greater or equal to zero
	 */
	@AnClass (author="Koegler Alexander")
	public T getAmount();
	
	/**
	 * increases actual total amount of fuel consumption by value of param
	 * @param amount which will be added, must not be a negative number
	 */
	@AnClass (author="Koegler Alexander")
	public void incAmount(T amount);
}
