package lab1;

public class HouseBlend extends CoffeeBeverage {
	
	public HouseBlend() {
		description = "HouseBlend";
	}
	

	public double cost() {
		return super.cost() + 0.8;
	}
}
