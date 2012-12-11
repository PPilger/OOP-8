@Author("Pilgerstorfer Peter")
public class Average<N extends Number> {
	private Combinator<N, N, N> add;
	private N sum;
	private int count;
	
	@Author("Pilgerstorfer Peter")
	public Average(Combinator<N, N, N> add, N zeroValue) {
		this.add = add;
		this.sum = zeroValue;
		this.count = 0;
	}
	
	@Author("Pilgerstorfer Peter")
	public void add(N value) {
		sum = add.combine(sum, value);
		count++;
	}
	
	@Author("Pilgerstorfer Peter")
	public Double getValue() {
		if(count == 0) {
			return Double.NaN;
		}
		return sum.doubleValue() / count;
	}
	
	@Override
	@Author("Pilgerstorfer Peter")
	public String toString() {
		if(count == 0) {
			return "none";
		}
		return String.format("%.2f", getValue());
	}
}
