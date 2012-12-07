
public class OperatingHoursMerger implements Merger<Tractor, Integer> {

	@Override
	public Integer initialValue() {
		return 0;
	}

	@Override
	public Integer merge(Tractor newElem, Integer value) {
		
		int hours = newElem.getOperatingHours();		
		return hours;
		
	}

	
	
}
