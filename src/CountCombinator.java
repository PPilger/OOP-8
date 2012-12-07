public class CountCombinator<T> implements Combinator<T, Integer> {
	@Override
	public Integer initialValue() {
		return 0;
	}
	
	@Override
	public Integer add(T tr, Integer num) {
		return num + 1;
	}
}
