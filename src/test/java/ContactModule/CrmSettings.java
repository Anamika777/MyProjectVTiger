package ContactModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.WorkFlowPage;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;

public class CrmSettings {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read data from properties file//
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//launch the browser//
		WebDriver driver=new ChromeDriver();
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
        //creating object for load page//
		LoginPage lg=new LoginPage(driver);
		lg.getLoginpage(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnCrmSettingsLink(driver);
		
		wLib.scrollBarAction(driver);
		WorkFlowPage wfp=new WorkFlowPage(driver);
		wfp.clickOnWorkFlow();
		wfp.clickOnnewWorkFlow();
		wfp.clickOnCreateFlow();
		
		wfp.descriptionSave(eLib.readDataFromExcelSheet("desc", 0, 1));
		
		wLib.scrollBarAction(driver);
		
		wfp.clickOnWorkFlowPge2();
		
		wLib.scrollBarAction(driver);
		
		
		
		
	}

}
