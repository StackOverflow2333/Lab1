package lab1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MilkTest {
	Beverage b;

	@Before
	public void setUp() throws Exception {
		b = new CoffeeBeverage();
	}

	@Test(timeout = 1000)
	public void testCost() {
		double cost = 0;
		int i = 0;
		for(i=0;i<=2;i++){
			switch(i){
			case 0: cost = 1.7;b = new Espresso();break;
			case 1: cost = 1.5;b = new HouseBlend();break;
			case 2: cost = 1.2;b = new Decaf();break;
			default:break;
			}
			((CoffeeBeverage) b).setSize("small");
			b = new Milk(b);
			Assert.assertEquals(cost, b.cost(), 0.01);
		}	
	}

}
