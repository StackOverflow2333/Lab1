package lab1;

public class CoffeeBeverage extends Beverage {

	public CoffeeBeverage() {
		super.sizeFactor = new CoffeeBased();
	}

	public double cost() {
		return super.cost() + super.sizeFactor.sizeCost(size);
	}
}
