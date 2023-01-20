package TestScriptUsing_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;

public class TestScript_1 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read data from properties file//
		String URL = fLib.readDataFromPropertyFile("urlLocal");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//read data from excel sheet//
		String orgname = eLib.readDataFromExcelSheet("Organization1", 0, 1)+jLib.getRandom();
		String industryValue = eLib.readDataFromExcelSheet("Organization1", 1, 1);
		String typeValue = eLib.readDataFromExcelSheet("Organization1", 2, 1);
		
		//launch the browser//
		WebDriver driver=new ChromeDriver();
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		
       // creating object for load page
		
		wLib.waitForPageLoad(driver);
		LoginPage lp=new LoginPage(driver);
		lp.getLoginpage(USERNAME, PASSWORD);
		
		//click on organization//
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();		

		//click on create Organization//
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationPage();
		
		//organization page//
	    CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		//cop.createOrganization(orgname);
		cop.createOrganization(orgname, typeValue, wLib, industryValue);
		
	
		cop.createOnEditClick();
		
		hp.clickOnHome();
	
		//hp.clickOnOpportunitiesClick(driver);
		
		
		
		//signout//
		hp.clickOnSignOut(wLib, driver);
		
		//close//
	wLib.close(driver);
		
		
		

	}

}
