package lab1;

public class Decaf extends CoffeeBeverage {
	
	
	public Decaf() {
		description = "Decaf";
	}
	public double cost() {
		return super.cost() + 0.5;
	}
}