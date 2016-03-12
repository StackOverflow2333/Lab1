package lab1;

public class CoffeeBased implements SizeFactor {

	@Override
	public double sizeCost(String size) {
		if (size.toLowerCase().equals("small")) {
			return 0.4;
		} else if (size.toLowerCase().equals("medium")) {
			return 0.7;
		} else {
			return 1.0;
		}
	}

}
//Test