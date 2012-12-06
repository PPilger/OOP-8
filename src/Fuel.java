
public interface Fuel<T extends Number> {
	public T getAmount();
	public void incAmount(T amount);
}
