package lab1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	ByteArrayOutputStream baoStream;
	PrintStream cacheStream;
	
	
	@Before
	public void setUp() throws Exception {
		baoStream = new ByteArrayOutputStream(1024);
		cacheStream = new PrintStream(baoStream);
		System.setOut(cacheStream);
	}
	
	@Test
	public void testInput1() {
		String[] str = new String[5];
		str[0] = "white";
		str[1] = "tea"; 
		str[2] = "small"; 
		str[3] = "milk";
		String assertStr = "The total cost of your order is: ";
		int i = 0;
		for(i=0;i<=2;i++){
			if(i==0){
				str[4] = "milk";
				assertStr += "1.8";
			}else if(i==1){
				str[4] = "jasmine"; 
				assertStr += "2.0";
			}else {
				str[4] = "Ginger"; 
				assertStr += "2.1";
			}
			Main.main(str);
			String strMsg = baoStream.toString().trim();
			Assert.assertEquals(assertStr, strMsg);
			baoStream.reset();
			assertStr = "The total cost of your order is: ";
		}
	}
	
	@Test
	public void testInput2() {
		String[] str = {"2","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate"};
		Main.main(str);
		String strMsg = baoStream.toString().trim();
		Assert.assertEquals("The total cost of your order is: 3.6", strMsg);
		baoStream.reset();	
		
		String[] str1 = {"3","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate"};
		Main.main(str1);
		String strMsg1 = baoStream.toString().trim();
		Assert.assertEquals("The total cost of your order is: 5.4", strMsg1);
		baoStream.reset();
		
		String[] str2 = {"4","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate",";","houseblend","small","milk","chocolate"};
		Main.main(str2);
		String strMsg2 = baoStream.toString().trim();
		Assert.assertEquals("The total cost of your order is: 7.2", strMsg2);
		baoStream.reset();
	
	}
	
}
