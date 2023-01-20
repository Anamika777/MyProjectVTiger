package SampleTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Practice_DataProvider {

	
		
		@Test(dataProvider="data")
	
		public void travel(String src,String dst,int price)
		{
			System.out.println("from"+src+"---->"+"to"+dst+price);
		}
		@DataProvider
		public Object[][] data(){
			Object[][] objarr=new Object[3][3];
			objarr[0][0]="banglore";
			objarr[0][1]="mysore";
			objarr[0][2]=14;
			
			objarr[1][0]="kanpur";
			objarr[1][1]="delhi";
			objarr[1][2]=10;
			
			objarr[2][0]="lucknow";
			objarr[2][1]="mumbai";
			objarr[2][2]=100;
			return objarr;
			
		
		

	}

}
