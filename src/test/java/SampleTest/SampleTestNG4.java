package SampleTest;

import org.testng.annotations.Test;

public class SampleTestNG4 {
	
	@Test(groups="smoke")
	public void sample7()
	{
		System.out.println("----testScript7----");
	}

	
	@Test(groups="regression")
	public void sample8()
	{
		System.out.println("----testScript8----");
	}
}
