package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProduct {
	
	@FindBy(name="productname")
	private WebElement proname;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement vendorLookupIcon;
	
	@FindBy(xpath="//input[@id='search_txt']")
	private WebElement vendorLookUpWindowSearch;
	
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement vendorchildWindowSearchButton;
	
	@FindBy(xpath="//tr[@class='lvtColData']")
	private WebElement vendorNameRecent;
	
	@FindBy(xpath="//img[@align='absmiddle']")
	private WebElement clickOnForward;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement save;
	
	
	
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProname() {
		return proname;
	}
	
	
	public WebElement getVendorLookupIcon() {
		return vendorLookupIcon;
	}

	
	public WebElement getVendorLookUpWindowSearch() {
		return vendorLookUpWindowSearch;
	}

	

	public WebElement getVendorchildWindowSearchButton() {
		return vendorchildWindowSearchButton;
	}
	

	public WebElement getVendorNameRecent() {
		return vendorNameRecent;
	}
	

	public WebElement getClickOnForward() {
		return clickOnForward;
	}

	public WebElement getSave() {
		
		return save;
	}

	public void createProductName(String pname)
	{
		proname.sendKeys(pname);
		save.click();
	}
public void createVendorLookUpSearchWindow(String vendorName)	
{
	
	vendorLookUpWindowSearch.sendKeys(vendorName);
	clickOnForward.click();
	vendorchildWindowSearchButton.click();
	
	
}


}
