@Author (value="Koegler Alexander", describtion="Distributes values to Diesel and BioGas tractors")
public class FuelDistributor<V> extends Distributor<Tractor, Object, V>{

	@Author (value="Koegler Alexander")
	public FuelDistributor(Merger<Tractor, V> comb) {
		super(comb);
		addType(Diesel.class);
		addType(BioGas.class);
	}

	@Override
	@Author (value="Koegler Alexander")
	protected boolean fitsKey(Tractor obj, Object fuel) {
		return obj.getFuel().getClass() == fuel;
	}

}
