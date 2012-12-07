
public interface Calc<T extends Number> {
	public T inc(T num, Tractor tr);
	public T avg(T sum, Integer count);
}
