
public abstract class Engine {
	private final double consumptionPH;
	private double totalConsumption;
	
	public Engine(double consumptionPH)
	{
		this.consumptionPH = consumptionPH;
		this.totalConsumption = 0;
	}
	
	public double useEngine(int hours)
	{
		this.totalConsumption += this.consumptionPH * hours;
		return this.totalConsumption;
	}
	
	public double getTotalConsumption()
	{
		return this.totalConsumption;
	}
}
