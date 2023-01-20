package RecycleBin_Module;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.EditorDeleteOrganizationButtonPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crm.ObjectRepository.RecycleBinpage;
import com.crm.genericUtility.BaseClass;



@Listeners(com.crm.genericUtility.ListenerImplementationClass.class)
public class RecycleModuleusingTestNg extends BaseClass
{

	@Test(groups = "intregation")
	public void createMethod() throws Throwable
	{
		
	
	//public static void main(String[] args) throws Throwable {
	
	
	
//		WebDriverUtility wLib=new WebDriverUtility();
//		ExcelUtility eLib=new ExcelUtility();
//		FileUtility fLib=new FileUtility();
//		JavaUtility jLib=new JavaUtility();
//		
//		//read data from properties file//
//		String URL = fLib.readDataFromPropertyFile("url");
//		String USERNAME = fLib.readDataFromPropertyFile("username");
//		String PASSWORD = fLib.readDataFromPropertyFile("password");
//		
		//read data from excel sheet//
		String orgname = eLib.readDataFromExcelSheet("Organization1", 0, 1)+jLib.getRandom();
		String industryValue = eLib.readDataFromExcelSheet("Organization1", 1, 1);
		String typeValue = eLib.readDataFromExcelSheet("Organization1", 2, 1);
		String InDD = eLib.readDataFromExcelSheet("Organization1", 3, 1);
				
		
		//launch the browser//
//		WebDriver driver=new ChromeDriver();
//		wLib.maxiMizewindow(driver);
//		wLib.waitForPageLoad(driver);
//		driver.get(URL);
        //creating object for load page//
//		LoginPage lp=new LoginPage(driver);
//		lp.getLoginpage(USERNAME, PASSWORD);
		
		//click on organization Module//
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganization();
		Assert.fail();
		//click on plus icon//
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateOrganizationPage();
		
		//create organization//
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrganization(orgname, typeValue, wLib, industryValue);
		
		//deleted organization//
		EditorDeleteOrganizationButtonPage e=new EditorDeleteOrganizationButtonPage(driver);
		e.clickOnDelete(wLib, driver);
		
		  
		//click on recycle Bin//
		hp.clickOnRecycleBin(wLib, driver);
		
		//search deleted organization name//
		RecycleBinpage rbp=new RecycleBinpage(driver);
		rbp.recycleBinPage(orgname, wLib, InDD);
		
		//signout//
	//	hp.clickOnSignOut(wLib, driver);
		
		//close//
	//	wLib.close(driver);		
		

	}

}
