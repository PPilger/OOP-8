
public class BioGas implements Fuel<Double>{

	private double gallons;
	
	public BioGas(double gallons)
	{
		this.gallons = gallons;
	}
	
	@Override
	public Double getAmount() {
		return this.gallons;
	}

	@Override
	public void incAmount(Double amount) {
		this.gallons += amount;		
	}

}
