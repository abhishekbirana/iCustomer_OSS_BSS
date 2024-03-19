package com.iCustomer.pageobjectrepository;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iCustomer.genericutilities.WebDriverUtility;



/**
 * This is Home Page
 * @author abhishek.birana
 */
public class HomePage extends WebDriverUtility{

	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardBtn;
	
	@FindBy(xpath = "//span[text()='Tasks']")
	private WebElement tasksBtn;
	
	@FindBy(xpath = "//span[text()='Calendar']")
	private WebElement calendarBtn;
	
	@FindBy(xpath = "//span[text()='360 Home']")
	private WebElement home360Btn;

	@FindBy(xpath = "//span[text()='Organization']")
	private WebElement organizationBtn;
	
	@FindBy(xpath = "//span[text()='Contacts']")
	private WebElement contactsBtn;
	
	@FindBy(xpath = "//span[text()='Sales Home']")
	private WebElement salesHomeTab;
	
	@FindBy(xpath = "//span[text()='Task']")
	private WebElement taskTab;
	
	@FindBy(xpath = "//span[text()='Sales Request']")
	private WebElement salesRequestTab;
	
	@FindBy(xpath = "//span[text()='Billing']")
	private WebElement billingTab;
	
	@FindBy(xpath = "//span[text()='Service Provider']")
	private WebElement serviceProviderTab;
	
	@FindBy(xpath = "//span[text()='Product Catalogue']")
	private WebElement productCatalogueTab;
	
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardTab;
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOn360Home(WebDriver driver) throws InterruptedException 
	{
		home360Btn.click();
	}
	
	public void clickOnSalesHome(WebDriver driver) throws InterruptedException 
	{
		salesHomeTab.click();
	}
	
	public void clickOnTasks(WebDriver driver) throws InterruptedException 
	{
		taskTab.click();
	}
	
	
	public void clickOnDashboard(WebDriver driver) throws InterruptedException 
	{
		dashboardTab.click();
	}
	
	
	public void goBackToParentTab(WebDriver driver, String parentId)
	{
		driver.close();
		switchToParentTab(driver, parentId);
	}
	
	
	
	
	

}
