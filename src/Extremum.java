/**
 * Is able to calculate the minimum or maximum of some values.
 */
@Author("Pilgerstorfer Peter")
public class Extremum {
	private int value;
	private boolean empty = true;
	private boolean min;

	/**
	 * Creates a new Extremum. If min is true, the minimum or otherwise the
	 * maximum is calculated.
	 */
	@Author("Pilgerstorfer Peter")
	public Extremum(boolean min) {
		this.min = min;
	}

	/**
	 * Add a new sample to the extremum.
	 */
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

	/**
	 * Returns the extremum (the minimum or the maximum of the added samples) or
	 * null, if no sample was added.
	 */
	@Author("Pilgerstorfer Peter")
	public Integer getValue() {
		if (empty) {
			return null;
		}
		return value;
	}

	/**
	 * Returns the extremum as String or "none" if no sample was added.
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		if (empty) {
			return "none";
		}
		return Integer.toString(value);
	}
}
