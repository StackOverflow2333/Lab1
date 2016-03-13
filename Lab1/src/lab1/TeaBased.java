package lab1;

public class TeaBased implements SizeFactor {

	@Override
	public double sizeCost(String size) {
		if (size.toLowerCase().equals("small")) {
			return 0.2;
		} else if (size.toLowerCase().equals("medium")) {
			return 0.5;
		} else if (size.toLowerCase().equals("large")) {
			return 0.7;
		} else if (size.toLowerCase().equals("grand")) {
			return 0.9;
		} else{
			return 0.0;
		}
	}

}
