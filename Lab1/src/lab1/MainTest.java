package lab1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
	ByteArrayOutputStream baoStream;
	PrintStream cacheStream;
	PrintStream oldStream;
	
	
	@Before
	public void setUp() throws Exception {
		baoStream = new ByteArrayOutputStream(1024);
		cacheStream = new PrintStream(baoStream);
		oldStream = System.out;
		System.setOut(cacheStream);
	}

	@Test
	public void test() {
		
		
		
		String[] str ={"houseblend","small","whip","milk"};
		Main.main(str);
		String strMsg = baoStream.toString().trim();
		System.setOut(oldStream);
	//	System.out.println(strMsg);
		Assert.assertEquals("The total cost of your order is: 2.0", strMsg);

		
	}

}
