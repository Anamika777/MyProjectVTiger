package Vendor_Module;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.ObjectRepository.CreateNewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;
import com.crm.ObjectRepository.VendorCreatePage;
import com.crm.ObjectRepository.VendorPage;
import com.crm.genericUtility.ExcelUtility;
import com.crm.genericUtility.FileUtility;
import com.crm.genericUtility.JavaUtility;
import com.crm.genericUtility.WebDriverUtility;

/*
 * 1)Open the browser and enter the URL. Login page should be displayed.
2)Enter the un and pwd home page should be displayed.
3)Move the mouse cursor to more and click on Vendors it must display vendors page.
4) click on create vendors it should display creating new vendor page.
5) fill all the neccessary details(Vendor name,phone,email) and click on save button.
6)click on product module,click on create product it should display creating new product page.
7)click on lookup icon of vendors name and check wheather newly created vendor is displaying or not.
 */
public class VendorModuleUsingPom {

	public static void main(String[] args) throws Throwable {

		WebDriverUtility wLib=new WebDriverUtility();
		ExcelUtility eLib=new ExcelUtility();
		FileUtility fLib=new FileUtility();
		JavaUtility jLib=new JavaUtility();
		
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD = fLib.readDataFromPropertyFile("password");
		
		WebDriver driver=new ChromeDriver();
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.getLoginpage(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
        hp.clickOnVendor(driver);
        
        VendorPage vp=new VendorPage(driver);
        vp.getCreateVendorPage();
        
        VendorCreatePage vcp= new VendorCreatePage(driver);
        vcp.getVendordetails(eLib.getList("Vendor", 0, 1), driver, jLib);
        
        hp.getProductsLink().click();
        
        ProductPage pg=new ProductPage(driver);
        pg.getProductpage();
        
        CreateNewProduct cp=new CreateNewProduct(driver);
        cp.getVendorLookupIcon().click();
        
    //  cp.getVendorLookUpWindowSearch()
        
        // hp.clickOnSignOut(wLib, driver);
        
        
        
        
	}

}
