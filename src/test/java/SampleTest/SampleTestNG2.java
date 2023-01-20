package SampleTest;

import org.testng.annotations.Test;

public class SampleTestNG2 {
	
	@Test(groups="smoke")
	public void sample3()
	{
		System.out.println("----testScript3----");
	}
	
	
	@Test(groups="regression")
	public void sample4()
	{
		System.out.println("----testScript4----");
	}
}
