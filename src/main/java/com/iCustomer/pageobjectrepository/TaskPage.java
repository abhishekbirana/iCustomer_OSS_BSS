package com.iCustomer.pageobjectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.iCustomer.genericutilities.WebDriverUtility;

/**
 * This is Tasks Page
 * @author abhishek.birana
 */
public class TaskPage extends WebDriverUtility
{
	
	@FindBy(xpath = "//a[text()=' New ']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//input[@formcontrolname='task_summary']")
	private WebElement taskSummaryTxtField;
	
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement descriptionTxtField;
	
	@FindBy(xpath = "//input[@placeholder='Select Status']")
	private WebElement statusDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> statusList;
	
	@FindBy(xpath = "//input[@placeholder='Select Related Cases']")
	private WebElement relatedCaseIDDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> relatedCaseIDList;
	
	@FindBy(xpath = "//input[@placeholder='Case ID Stage']")
	private WebElement caseIDStageDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> caseIDStageList;
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-calendar']")
	private WebElement calendarIcon;
	
	@FindBy(xpath = "//div[text()='29']")
	private WebElement dateElement;
	
	@FindBy(xpath = "//select[@title='Select month']")
	private WebElement monthElement;
	
	@FindBy(xpath = "//select[@title='Select year']")
	private WebElement yearElement;
	
	@FindBy(xpath = "//input[@formcontrolname='due_hrs']")
	private WebElement timeTxt;
	
	@FindBy(xpath = "//input[@placeholder='select']")
	private WebElement assignToDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> assignToList;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement taskMessage;
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn;
	
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public void clickOnNewBtn(WebDriver driver) throws InterruptedException 
	{
		jsclick(driver, newBtn);
	}
	
	public void fillCreateNewTask(WebDriver driver, String taskSummary, String description, String status, String relatedCaseID, String caseIDStage, String dueOnDate, String dueOnMonth, String dueOnYear, String dueOnHours, String dueOnMinutes, String assignedTo) throws Exception
	{
		Thread.sleep(3000);
		jsclick(driver, taskSummaryTxtField);
		taskSummaryTxtField.sendKeys(taskSummary);
		descriptionTxtField.sendKeys(description);
			
//		jsclick(driver, statusDropdown);
//		handleDropdownList(driver, statusList, status);
		
		jsclick(driver, relatedCaseIDDropdown);
		handleDropdownList(driver, relatedCaseIDList, relatedCaseID);
		
		jsclick(driver, caseIDStageDropdown);
		handleDropdownList(driver, caseIDStageList, caseIDStage);
		
		
		calendarIcon.click();
		
		Select sy = new Select(yearElement);
		sy.selectByVisibleText(dueOnYear);
		
		Select sm = new Select(monthElement);
		sm.selectByVisibleText(dueOnMonth);
		
		commonDateClick(driver, dueOnDate);
		
		timeTxt.sendKeys(dueOnHours+dueOnMinutes);
		
		jsclick(driver, assignToDropdown);
		handleDropdownList(driver, assignToList, assignedTo);
	}
	
	public void commonDateClick(WebDriver driver, String date)
	{
		WebElement element = driver.findElement(By.xpath("//div[text()='"+date+"']"));
		element.click();
	}
	
	public void clickOnSaveBtn(WebDriver driver)
	{
		jsclick(driver, saveBtn);
	}
	
	public String getTasksMessage()
	{
		return taskMessage.getText();
	}
	
	public void clickOkBtn(WebDriver driver)
	{
		jsclick(driver, okBtn);
	}

}
