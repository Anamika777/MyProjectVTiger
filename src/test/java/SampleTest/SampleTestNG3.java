package SampleTest;

import org.testng.annotations.Test;

public class SampleTestNG3 {
	
	
	@Test(groups="regression")
	
	public void sample5()
	{
		System.out.println("----testScript5----");
	}
	
	@Test(groups="smoke")
	public void sample6()
	{
		System.out.println("----testScript6----");
	}

}
