public class CountCombinator<T> implements Combinator<T, Integer> {
	@Override
	public Integer add(T tr, Integer num) {
		return num + 1;
	}
}
