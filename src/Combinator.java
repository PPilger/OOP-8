
public interface Combinator<T, U> {
	public U initialValue();
	public U add(T num1, U num2);
}
