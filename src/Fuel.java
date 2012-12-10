@Author (value="Koegler Alexander", describtion="Represents total amount of fuel consumption")
public interface Fuel<T extends Number> {
	
	/**
	 * 
	 * @return total amount of fuel consumption, shall always be greater or equal to zero
	 */
	@Author (value="Koegler Alexander")
	public T getAmount();
	
	/**
	 * increases actual total amount of fuel consumption by value of param
	 * @param amount which will be added, must not be a negative number
	 */
	@Author (value="Koegler Alexander")
	public void incAmount(T amount);
}
