package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement usernameEdit;
	
	@FindBy(name="user_password")
    private WebElement passwordEdit; 
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	public WebElement getUsernameEdit() {
		return usernameEdit;
	}


	public WebElement getPasswordEdit() {
		return passwordEdit;
	}


	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	
	public void getLoginpage(String username,String password)
	{
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbutton.click();
	}
}
