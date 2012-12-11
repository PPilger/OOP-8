/**
 * Is able to calculate the average of some values.
 */
@Author("Pilgerstorfer Peter")
public class Average {
	private double sum = 0;
	private int count = 0;

	@Author("Pilgerstorfer Peter")
	public void add(Number value) {
		sum += value.doubleValue();
		count++;
	}

	/**
	 * Returns the average of all added values or Double.NaN, if no value was
	 * added.
	 */
	@Author("Pilgerstorfer Peter")
	public Double getValue() {
		if (count == 0) {
			return Double.NaN;
		}
		return sum / count;
	}

	/**
	 * Returns the average as String (2 fractional digits) or "none" if no value
	 * was added.
	 */
	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		if (count == 0) {
			return "none";
		}
		return String.format("%.2f", getValue());
	}
}
