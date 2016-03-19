package lab1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JasmineTest {
	Beverage b;

	@Before
	public void setUp() throws Exception {
		b = new TeaBeverage();
	}

	@Test(timeout = 1000)
	public void testCost() {
		double cost = 0;
		int i = 0;
		for(i=0;i<=2;i++){
			switch(i){
			case 0: cost = 1.7;b = new GreenTea();break;
			case 1: cost = 1.7;b = new WhiteTea();break;
			case 2: cost = 1.5;b = new RedTea();break;
			default:break;
			}
			((TeaBeverage) b).setSize("small");
			b = new Jasmine(b);
			Assert.assertEquals(cost, b.cost(), 0.01);
		}	
	}

}
