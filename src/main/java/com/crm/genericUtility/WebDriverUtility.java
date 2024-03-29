package com.crm.genericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 *This method is used to maximize the window
	 *@author admin
	 * @param driver
	 */
	public void maxiMizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait for the page load
	 * @author admin
	 * @param driver
	 */
	@SuppressWarnings("deprecation")
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * This method is used to wait until element to visible
	 * @param driver
	 */
	public void elementToBeVisible(WebDriver driver,WebElement element)
	{
		//Object ;
	//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10000));
		//wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void select(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	public void select(String visibletext, WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	
	public void select(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void mousehover(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();;
	}
	/**
	 * This method is used to switch the frame based on nameorid
	 * @author admin
	 * @param driver
	 * @param id
	 */
	public void switchToFrame(WebDriver driver,String nameorid)
	{
		driver.switchTo().frame(nameorid);
	}
	/**
	 * This method is used to switch the frame based on index
	 * @author admin
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame based on address
	 * @author admin
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * this method is used to handle accept alert popup
	 * @author admin
	 * @param driver
	 * @return 
	 */
	public Alert acceptAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
		return alt;
	}
	/**
	 *  this method is used to handle cancel alert popup
	 * @author admin
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
	}
	public String fetchingMsgAlert(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		String msg = alt.getText();
		return msg;
	}
	/**
	 * This method will switch window
	 * @author admin
	 * @param driver
	 * @param partialTitle
	 */
	public void getwindowHandles(WebDriver driver, String partialTitle)
	{
		//Steps:1 using getwindowhandles to capture allthe windows id
		Set<String> allid = driver.getWindowHandles();
		
		//Steps:2 iterate through allid
		Iterator<String> it = allid.iterator();
		
		//steps:3 check wheather there is next window
		while(it.hasNext())
		{
			//steps:4 capture current window id
			String id = it.next();
			
			//steps:5 switch to currentwindow and captur title
			String title = driver.switchTo().window(id).getTitle();
			
			//steps:6 check wheather current window is expected
			if(title.contains(partialTitle))
			{
				break;
			}
		}
		
	}
	
	public void getwindowHandles( String partialTitle,WebDriver driver)
	{
		//String mainid = driver.getWindowHandle();
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid)
		{
			String title = driver.switchTo().window(id).getTitle();
			if(title.contains(partialTitle))
			{
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	public void comeToMAinWindow(WebDriver driver,String mainid)
	{
		
		driver.switchTo().window(mainid);
	}
	
	public void scrollBarAction(WebDriver driver)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000);");
	}
	public void scrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	public void close(WebDriver driver) 
	{
		driver.close();
	}
	public void moveMouse(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();;
	}
	public void clickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.click();
	}
	
	public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = ".\\screenshot\\"+screenShotName+".png";
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		return path;
		
	}
	
}
	
	
	


