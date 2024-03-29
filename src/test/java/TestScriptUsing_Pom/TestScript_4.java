package TestScriptUsing_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.ObjectRepository.CreateFaq;
import com.crm.ObjectRepository.CreateNewProduct;
import com.crm.ObjectRepository.FaqPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScript_4 {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		
		//read data from properties file//
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		//JavaUtility jLib;
		//read data from excel sheet//
		String pname = eLib.readDataFromExcelSheet("product1", 1, 0)+jLib.getRandom();
		String faqStatus = eLib.readDataFromExcelSheet("product1", 4, 1);
		String faqQuestion = eLib.readDataFromExcelSheet("product1", 5, 1);
		String faqAnswer = eLib.readDataFromExcelSheet("product1", 6, 1);
		
		
//		//launch the browser//
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
        //creating object for load page//
		LoginPage lp=new LoginPage(driver);
		lp.getLoginpage(USERNAME, PASSWORD);
		
		//click on products//
		HomePage hp=new HomePage(driver);
		hp.clickOnProductsClick();
		
		//product page//
		ProductPage pp=new ProductPage(driver);
		pp.getProductpage();
		
		//fill the manadatory fields//
		CreateNewProduct cnp=new CreateNewProduct(driver);
		cnp.createProductName(pname);
		
		
		//click on FAQ//
		hp.clickOnFaq(driver);
		
		//click on faq plus icon//
		FaqPage fp=new FaqPage(driver);
		fp.createFaq();
		
		//fill all the manadatory fileds//
		
		CreateFaq cf=new CreateFaq(driver);
		cf.fillFaqFields(faqQuestion, faqAnswer, wLib, faqStatus, driver, pname);
		
		hp.clickOnHome();
		hp.clickOnSignOut(wLib, driver);
		wLib.close(driver);
	


	}

}
