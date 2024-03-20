package com.iCustomer.pageobjectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iCustomer.genericutilities.WebDriverUtility;

public class DashboardPage extends WebDriverUtility

{

	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-plus']")
	private WebElement plusBtn;
	
	@FindBy(xpath = "//*[@formcontrolname='event_name']")
	private WebElement evtname;
	
	@FindBy(xpath = "//*[@formcontrolname='description']")
	private WebElement descrpyn;
	
	@FindBy(xpath = "//*[@id='mentionUser']")
	private WebElement sharewith;
	
	@FindBy(xpath = "//*[@formcontrolname='start_date']")
	private WebElement startdate;
	
	@FindBy(xpath = "//*[@formcontrolname='end_date']")
	private WebElement enddate;
	
	@FindBy(xpath = "//*[@formcontrolname='start_time']")
	private WebElement startime;
	
	@FindBy(xpath = "//*[@formcontrolname='end_time']")
	private WebElement endtime;
	
	@FindBy(xpath = "//*[text()='Create']")
	private WebElement createbtn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement dashboardMessage;
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//*[@id='mentionUser']/../mention-List/UL/li/a")
	private List<WebElement> userlist;
	
	
	
	public DashboardPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnplusBtn(WebDriver driver) throws InterruptedException 
	{
		plusBtn.click();
	}
	
	public void filleventform(WebDriver driver,String EventName,String Description,String ShareWith) throws Exception
	{

		Thread.sleep(5000);
		jsclick(driver, evtname);
		evtname.sendKeys(EventName);
		descrpyn.sendKeys(Description);
		
		startdate.sendKeys("29032024");
		enddate.sendKeys("30032024");
		
		startime.sendKeys("1400");
		endtime.sendKeys("1600");
		sharewith.sendKeys("@");
		handleDropdownList(driver, userlist, ShareWith);
		
		createbtn.click();
	
	}
	
	public String getSuccessMessage()
	{
		return dashboardMessage.getText();
	}
	
	public void clickOkBtn()
	{
		okBtn.click();
	}
}
