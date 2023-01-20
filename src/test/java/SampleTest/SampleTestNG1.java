package SampleTest;

import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

public class SampleTestNG1 {
	
	@Test(groups="smoke")
	
	public void sample1()
	{
		System.out.println("----testScript1----");
	}
	
	@Test(groups="regression")
	public void sample2()
	{
		System.out.println("-----testscript2----");
	}
	

}
