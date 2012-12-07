public class CountFolder<T> implements Merger<T, Integer> {
	@Override
	public Integer initialValue() {
		return 0;
	}
	
	@Override
	public Integer merge(T tr, Integer num) {
		return num + 1;
	}
}
