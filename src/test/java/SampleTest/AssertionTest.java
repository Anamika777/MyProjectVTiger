package SampleTest;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {
	
	@Test
	
	public void sample_1()
	{
		System.out.println("---testscript1--");
		System.out.println("---testscript2--");
		assertEquals("A","B");
		System.out.println("---testscript3--");
		System.out.println("---testscript4--");
	}
	
	@Test
	
	public void sample_2()
	{
		System.out.println("---testscript5--");
		System.out.println("---testscript6--");
		assertNotEquals("A", "B", "Script is failed");
		System.out.println("---testscript7--");
		System.out.println("---testscript8--");
		
	}

	@Test
	public void sample_3()
	{
		String a=null;
		assertNull(a);
		System.out.println("-----");
	}
	
	@Test
	
	public void sample_4()
	{
		System.out.println("----test9---");
		SoftAssert sa=new SoftAssert();
		sa.assertEquals("X","Y");
		System.out.println("test 10");
		sa.assertAll();
		
	}
	
	
}
