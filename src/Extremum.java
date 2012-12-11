@Author("Pilgerstorfer Peter")
public class Extremum {
	private int value;
	private boolean empty = true;
	private Combinator<Integer, Integer, Integer> f;

	@Author("Pilgerstorfer Peter")
	public Extremum(Combinator<Integer, Integer, Integer> f) {
		this.f = f;
	}
	
	@Author("Pilgerstorfer Peter")
	public void add(Integer newVal) {
		if (empty) {
			value = newVal;
			empty = false;
		} else {
			value = f.combine(value, newVal);
		}
	}

	@Author("Pilgerstorfer Peter")
	public Integer getValue() {
		if (empty) {
			return null;
		}
		return value;
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		if (empty) {
			return "none";
		}
		return Integer.toString(value);
	}
}
