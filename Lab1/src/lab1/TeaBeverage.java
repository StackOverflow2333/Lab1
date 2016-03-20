package lab1;

public class TeaBeverage extends Beverage {
	

	public TeaBeverage() {
		super.sizeFactor = new TeaBased();
	}



	public double cost() {
		return super.cost() + super.sizeFactor.sizeCost(size);
	}
}
