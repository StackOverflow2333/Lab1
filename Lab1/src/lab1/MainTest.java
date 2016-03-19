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
		str[0] = "houseblend";
		str[2] = "whip"; 
		str[3] = "cream";
		str[4] = "milk";
		String assertStr = "The total cost of your order is: ";
		int i = 0;
		for(i=0;i<=3;i++){
			if(i==0){
				str[1] = "small"; 
				assertStr += "1.8";
			}else if(i==1){
				str[1] = "medium"; 
				assertStr += "2.1";
			}else if(i==2){
				str[1] = "large"; 
				assertStr += "2.4";
			}else{
				str[1] = "grande";
				assertStr += "2.7";
			}
			Main.main(str);
			String strMsg = baoStream.toString().trim();
			Assert.assertEquals(assertStr, strMsg);
			baoStream.reset();
			assertStr = "The total cost of your order is: ";
		}
}
}
