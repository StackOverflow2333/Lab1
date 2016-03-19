package lab1;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Test {
	
	public static void main(String[] args) {
/*		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		System.out.println("hhh aaa bbb");
		System.out.println(bout.toString());
*/
		ByteArrayOutputStream baoStream = new ByteArrayOutputStream(1024);
		PrintStream cacheStream = new PrintStream(baoStream);
		PrintStream oldStream = System.out;
		System.setOut(cacheStream);//不打印到控制台
		System.out.println("System.out.println:test");
		String strMsg = baoStream.toString();
		System.setOut(oldStream);//还原到控制台输出
		System.out.println(strMsg);
		
		System.out.println(0.8+0.4);
	}

}
