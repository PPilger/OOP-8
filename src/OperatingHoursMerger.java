@Author (value="Kletzander Christian", describtion="Sums amount, of operating hours, up")
public class OperatingHoursMerger implements Merger<Tractor, Integer> {

	@Override
	@Author (value="Kletzander Christian")
	public Integer initialValue() {
		return 0;
	}

	@Override
	@Author (value="Kletzander Christian")
	public Integer merge(Tractor newElem, Integer value) {
		
		int hours = newElem.getOperatingHours();		
		return hours + value;
		
	}

	
	
}
