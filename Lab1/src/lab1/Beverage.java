package lab1;

public class Beverage {
	protected SizeFactor sizeFactor;
	protected String description="";
	protected String size;
	public double cost() {
		return 0;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
}