package lab1;

public class Decaf extends CoffeeBeverage {
	//private String description;
	
	public Decaf() {
		description = "Decaf";
	}
	public double cost() {
		return super.cost() + 0.5;
	}
}