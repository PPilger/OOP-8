@Author("Pilgerstorfer Peter")
public class Average {
	private double sum = 0;
	private int count = 0;

	@Author("Pilgerstorfer Peter")
	public void add(Number value) {
		sum += value.doubleValue();
		count++;
	}

	@Author("Pilgerstorfer Peter")
	public Double getValue() {
		if (count == 0) {
			return Double.NaN;
		}
		return sum / count;
	}

	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		if (count == 0) {
			return "none";
		}
		return String.format("%.2f", getValue());
	}
}
