package HardCodeTestScript;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 1)open the browser and pass the URL ,login page should be displayed.
2)Login with the valid Username and password,home page should be displayed.
3)click on Organization module .
4)click on create organization icon creating new Organization page should be display.
5)Fill all the mandatory field (Organization name, member of,assigned To, mail id, mobile no) and click on save button Organization page should be displayed  along with unique organization number.
6)click on Delete button confirm the alert pop-up message and organization list page should be displayed.
7)Move the mouse cusor to more and click on recycle bin link it should displayed recycle bin page.
8)Newly deleted Organization name must be displayed. 
*/
 

public class TC_04IntegrationTestinghardCodedataCode {
	public static void main(String[] args) throws IOException, InterruptedException {
		//creating Random class
		Random r=new Random();
		int random = r.nextInt(100);
		
		//get common data
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData4.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String URL = pobj.getProperty("urlLocal");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
				
		//get data from excel shett//
		FileInputStream fi = new FileInputStream("./src/test/resources/TestData4.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("Recyclebin");
		String orgname = sh.getRow(1).getCell(0).getStringCellValue()+random;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login to Appilication//
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//click on organization//
		driver.findElement(By.linkText("Organizations")).click();
		//click on lookup image anf fill all the details//
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//click on delete
		driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		
		//handle the alert popup
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		//move the mouse cursor to more//
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		Actions act=new Actions(driver);
		act.moveToElement(more).perform();
		driver.findElement(By.name("Recycle Bin")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='searchUIName small']/../td[3]/input[1]")).sendKeys(orgname);
		driver.findElement(By.name("submit")).click();
		
		
		Thread.sleep(3000); 
		WebElement noRecordFound=driver.findElement(By.xpath("//span[@class='genHeaderSmall']"));
		if(noRecordFound.isDisplayed())
		{
			System.out.println("Organizations is deleted successfully!!");
		}
		else
		{
			System.out.println("Organizations is not deleted successfully!!");
		}
		
		Thread.sleep(2000);
		//logout from the applications//
        WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		
		act.moveToElement(signout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
