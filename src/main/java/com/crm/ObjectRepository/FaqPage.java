package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaqPage {
	
	@FindBy(xpath="//img[@title='Create FAQ...']")
	private WebElement createFaq;
	
	public FaqPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateFaq() {
		return createFaq;
	}
	public void createFaq()
	{
		createFaq.click();
	}

}
