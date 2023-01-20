package com.crm.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static final String URL = null;
	public WebDriver driver;
	public static WebDriver sdriver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	
	
	@BeforeSuite(alwaysRun = true)
	public void configDB()
	{
		System.out.println("connect to database");
	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("ie"))
		{
//			WebDriverManager.edgedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		
		else if(BROWSER.equalsIgnoreCase("chrome"))
			
		{
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
		}
		
		else
		{
			System.out.println("invalid browser");
		}
		
		
		sdriver=driver;
		wLib.maxiMizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		System.out.println("--launch the browser--");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable
	
	{
		
		String USERNAME = fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.getLoginpage(USERNAME, PASSWORD);
		
		System.out.println("login to application");
	}
	@AfterMethod(alwaysRun = true)
	
	public void configAM()
	{

		WebDriverManager.chromedriver().setup();
		HomePage hp=new HomePage(driver);
		hp.clickOnSignOut(wLib, driver);
		System.out.println("logout from the app");
	}
	@AfterClass(alwaysRun = true)
	public void configAC()
	{

//		WebDriverManager.chromedriver().setup();
		driver.quit();
		System.out.println("close the browser");
		
	}
	
	@AfterSuite()
	public void disconnectDB() throws Throwable 
	{
		
		dLib.closeDB();
		System.out.println("---disconnected from database--");
			
		
	}
	
}
 