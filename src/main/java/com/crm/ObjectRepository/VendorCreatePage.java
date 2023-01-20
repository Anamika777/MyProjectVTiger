package com.crm.ObjectRepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericUtility.JavaUtility;

public class VendorCreatePage {
	
	@FindBy(name="vendorname")
	private WebElement vendorName;
	
	@FindBy(name="email")
	private WebElement emailV;
	
	@FindBy(name="phone")
	private WebElement phoneNoV;
	
	@FindBy(name="city")
	private WebElement cityV;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveV;
	
	
	public VendorCreatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public WebElement getVendorName() {
		return vendorName;
	}


	public WebElement getEmailV() {
		return emailV;
	}


	public WebElement getPhoneNoV() {
		return phoneNoV;
	}


	public WebElement getCityV() {
		return cityV;
	}


	public WebElement getSaveV() {
		return saveV;
	}
	
//	public void getVendordetails(String vname,String email,String phone,String city )
//	{
//		vendorName.sendKeys(vname);
//		emailV.sendKeys(email);
//		phoneNoV.sendKeys(phone);
//		cityV.sendKeys(city);
//		saveV.click();
//	}
	public void getVendordetails(HashMap<String, String> fields, WebDriver driver, JavaUtility jLib)
	{
		for(Entry<String, String> set:fields.entrySet())
		{
			if((set.getKey().contains("vendorName")))
					{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandom());
					}
			else
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
			
		}
		saveV.click();
	}

}
