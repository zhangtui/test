package TestMath;

import interfacerestAssured.MathTool;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class MyTestMathTool {
  @Test
	public void testAbs1(){
		int expected = 0;
		int result = MathTool.abs(0);
		assertEquals(result, expected);
	}
	@Test
	public void testAbs2(){
		int expected = 10;
		int result = MathTool.abs(10);
		assertEquals(result, expected);
	}
	@Test
	public void testAbs3(){
		int expected = 5;
		int result = MathTool.abs(-5);
		assertEquals(result, expected);
	}
  
}
