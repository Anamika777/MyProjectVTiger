package Lead_Module;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Leads_Module {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata2.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String URL =pObj.getProperty("urlLocal");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		
		
		FileInputStream fi=new FileInputStream("./src\\test\\resources\\testData46.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("NewLead");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.TAB,Keys.SPACE);
		
		
		driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select s=new Select(salutation);
		s.selectByValue("Ms.");
		//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("rony");
		ArrayList<String> list=new ArrayList<String>();
		list.add("firstname");
		list.add("lastname");
		list.add("company");
		list.add("mobile");
		list.add("email");
		
		for(int i=0;i<=sh.getLastRowNum();i++)
		{
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.findElement(By.name(list.get(i))).sendKeys(value);
			
		}
		
		
//		HashMap<String,String> map=HashMap<String,String>();
//		map.put(USERNAME, PASSWORD)	
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String expecteddata = "singh anamika7 - Lead Information ";
		String actualdata=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualdata.equalsIgnoreCase(expecteddata))
		{
			
			System.out.println("Lead Created Successfully!!");
		}
		else
		{
			System.out.println("Lead is not Created!!");
		}
	
		//driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
	driver.findElement(By.xpath("(//input[@title='Edit [Alt+E]'])[1]")).click();
	
WebElement ref = driver.findElement(By.name("mobile"));
ref.clear();
ref.sendKeys("9847123697");

driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
WebElement signout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act=new Actions(driver);
act.moveToElement(signout).perform();
driver.findElement(By.linkText("Sign Out")).click();
		
		
		
		

	}

}
