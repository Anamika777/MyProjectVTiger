package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkFlowPage {
	
	@FindBy(linkText="Workflows")
	private WebElement workFlows;
	
	@FindBy(id="new_workflow")
	private WebElement newWorkFlow;
	
	@FindBy(xpath="//input[@value='Create']")
	private WebElement createValue;
	
	@FindBy(xpath="//input[@name='description']")
	private WebElement description;
	
	@FindBy(id="save_submit")
	private WebElement save;
	
	@FindBy(linkText="Workflows")
	private WebElement workflowpage2;
	
	public WorkFlowPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getWorkFlows() {
		return workFlows;
	}
   
	
	public WebElement getNewWorkFlow() {
		return newWorkFlow;
	}


	public WebElement getCreateValue() {
		return createValue;
	}

	
	public WebElement getDescription() {
		return description;
	}

	public WebElement getSave() {
		return save;
	}

	//bussiness logic
	public void clickOnWorkFlow()
	{
		workFlows.click();
	}
	
	
	public WebElement getWorkflowpage2() {
		return workflowpage2;
	}

	public void clickOnnewWorkFlow()
	{
		newWorkFlow.click();
		
	}
	
	public void clickOnCreateFlow()
	{
		createValue.click();
	}
	
	public void descriptionSave(String desc)
	{
		description.sendKeys(desc);
		save.click();
	}
public void clickOnWorkFlowPge2()
{
	workflowpage2.click();
}





}
