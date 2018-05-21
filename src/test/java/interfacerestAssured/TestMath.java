package interfacerestAssured;

import static org.testng.Assert.assertEquals;
import org.junit.Test;

public class TestMath {
	
	@Test
	public void testMath1(){
		int expected = 0;
		int result = MathTool.abs(0);
		assertEquals(result, expected);
	}
	@Test
	public void testMath2(){
		int expected = 10;
		int result = MathTool.abs(10);
		assertEquals(result, expected);
	}
	@Test
	public void testMath3(){
		int expected = 5;
		int result = MathTool.abs(-5);
		assertEquals(result, expected);
	}
}
