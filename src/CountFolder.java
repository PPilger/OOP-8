@Author("Peter Pilgerstorfer")
public class CountFolder<T> implements Merger<T, Integer> {
	@Override
	@Author("Peter Pilgerstorfer")
	public Integer initialValue() {
		return 0;
	}

	@Override
	@Author("Peter Pilgerstorfer")
	public Integer merge(T tr, Integer num) {
		return num + 1;
	}
}
