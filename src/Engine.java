
public abstract class Engine {
	private final double consumptionPH;
	private double totalConsumption;
	
	public Engine(double consumptionPH)
	{
		this.consumptionPH = consumptionPH;
		this.totalConsumption = 0;
	}
	
	public double UseEngine(int hours)
	{
		this.totalConsumption += this.consumptionPH * hours;
		return this.totalConsumption;
	}
	
	public double GetTotalConsumption()
	{
		return this.totalConsumption;
	}
}
