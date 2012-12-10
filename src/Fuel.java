@Author ("Koegler Alexander")
/**
 * Represents total amount of fuel consumption
 * @author Koegler Alexander
 *
 * @param <T>
 */
public interface Fuel<T extends Number> {
	
	/**
	 * 
	 * @return total amount of fuel consumption, shall always be greater or equal to zero
	 */
	@Author ("Koegler Alexander")
	public T getAmount();
	
	/**
	 * increases actual total amount of fuel consumption by value of param
	 * @param amount which will be added, must not be a negative number
	 */
	@Author ("Koegler Alexander")
	public void incAmount(T amount);
}
