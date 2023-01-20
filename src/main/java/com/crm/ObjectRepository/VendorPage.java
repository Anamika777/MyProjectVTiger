package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {
	
	@FindBy(xpath="//img[@title='Create Vendor...']")
	private WebElement createVendor;
	
	public VendorPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateVendor() {
		return createVendor;
	}
	
	public void getCreateVendorPage()
	{
	createVendor.click();
	}

	
	
	
}
