@Author("Pilgerstorfer Peter")
public class Extremum {
	private int value;
	private boolean empty = true;
	private boolean min;

	@Author("Pilgerstorfer Peter")
	public Extremum(boolean min) {
		this.min = true;
	}

	@Author("Pilgerstorfer Peter")
	public void add(Integer newVal) {
		if (empty) {
			value = newVal;
			empty = false;
		} else if (min) {
			value = Math.min(value, newVal);
		} else {
			value = Math.max(value, newVal);
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
