package lab1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WhiteTeaTest {
	Beverage b;

	@Before
	public void setUp() throws Exception {
		b = new WhiteTea();
		
	}

	@Test(timeout = 1000)
	public void testCost() {
		double cost = 0;
		int i = 0;
		for(i=0;i<=3;i++){
			switch(i){
			case 0: cost = 1.2;((TeaBeverage) b).setSize("small");break;
			case 1: cost = 1.5;((TeaBeverage) b).setSize("medium");break;
			case 2: cost = 1.7;((TeaBeverage) b).setSize("large");break;
			case 3: cost = 1.9;((TeaBeverage) b).setSize("grande");break;
			default:break;
			}
			Assert.assertEquals(cost, b.cost(), 0.01);
		}	
	}

}
