package com.iCustomer.pageobjectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iCustomer.genericutilities.Container;
import com.iCustomer.genericutilities.WebDriverUtility;
/**
 * @author abhishek.birana
 */
public class ProductPage extends WebDriverUtility {

	
	@FindBy(xpath = "//h4[text()='ProWatch']/ancestor::div[@class='widget-todolist-bodys']/descendant::button")
	private WebElement proWatchLaunchBtn;
	
	@FindBy(xpath = "//h4[text()='iProcess']/ancestor::div[@class='widget-todolist-bodys']/descendant::button")
	private WebElement iProcessLaunchBtn;
	
	@FindBy(xpath = "//h4[text()='iCustomer']/ancestor::div[@class='widget-todolist-bodys']/descendant::button")
	private WebElement iCustomerLaunchBtn;
	
	@FindBy(xpath = "//span[text()='Abhishek Birana']")
	private WebElement abhishekBiranaBtn;
	
	@FindBy(xpath = "//span[@class='companyText']")
	private WebElement pageTitleText;
	
	@FindBy(xpath = "//span[@class='signout']")
	private WebElement signOutBtn;
	
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will click on Launch Button of ProWatch
	 * @param driver
	 */
	public void clickOnProWatchLaunchButton(WebDriver driver)
	{
		jsclick(driver, proWatchLaunchBtn);
	}
	
	/**
	 * This method will click on Launch Button of iProvision
	 * @param driver
	 */
	public void clickOnIProcessLaunchButton(WebDriver driver)
	{
		jsclick(driver, iProcessLaunchBtn);
	}
	
	
	public void clickOnICustomerLaunchButton(WebDriver driver)
	{
		jsclick(driver, iCustomerLaunchBtn);
	}
	
	
	public String getPageTitle(WebDriver driver)
	{
		return pageTitleText.getText();
	}
	
	/**
	 * This method will perform sign out operation
	 * @param driver
	 */
	public void logOutOfApp(WebDriver driver)
	{
		jsclick(driver, abhishekBiranaBtn);
		signOutBtn.click();
	}
	
}
