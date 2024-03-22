package com.iCustomer.pageobjectrepository;

import java.util.List; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.iCustomer.genericutilities.WebDriverUtility;

/**
 * @author abhishek.birana
 */
public class SalesHomePage extends WebDriverUtility
{
	@FindBy(xpath = "//span[text()='New']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//a[text()='Sales Request']")
	private WebElement salesRequestBtn;
	
	@FindBy(xpath = "//input[@id='dropdownBasic3']")
	private WebElement selectAccountDropdown;
	
	@FindBy(xpath = "//div[@class='dropdown-list dropdown-menu show']/ul/li[@class='dropdown-toggle ng-star-inserted']")
	private List<WebElement> selectAccountList;
	
	@FindBy(xpath = "//input[@id='dropdownBasic2']")
	private WebElement selectContactDropdown;
	
	@FindBy(xpath = "//div[@class='dropdown-list dropdown-menu show']/ul/li[@class='dropdown-toggle ng-star-inserted']")
	private List<WebElement> selectContactList;
	
	@FindBy(xpath = "//p[text()='Select Product']")
	private WebElement productDropdown;
	
	@FindBy(xpath = "//li[text()='Managed SDWAN']/following::ul/li[@class='variantName ng-star-inserted']")
	private List<WebElement> productList;
	
	@FindBy(xpath = "//select[@formcontrolname='contract_duration']")
	private WebElement contactDurationDropdown;
	
	@FindBy(xpath = "//*[local-name()='svg' and @class='feather feather-calendar']")
	private WebElement calendarIcon;
	
	@FindBy(xpath = "//div[text()='31']")
	private WebElement dateElement;
	
	@FindBy(xpath = "//select[@title='Select month']")
	private WebElement monthElement;
	
	@FindBy(xpath = "//select[@title='Select year']")
	private WebElement yearElement;
	
	@FindBy(xpath = "//select[@formcontrolname='currency']")
	private WebElement estimatedBudgetCurrencyDD;
	
	@FindBy(xpath = "//input[@formcontrolname='estimated_budget']")
	private WebElement estimatedBudgetTFA;
	
	@FindBy(xpath = "//select[@formcontrolname='billing_cycle']")
	private WebElement billingCycleDD;
	
	@FindBy(xpath = "//select[@formcontrolname='purchase_process']")
	private WebElement purchaseProductDD;
	
	@FindBy(xpath = "//input[@formcontrolname='product_package']")
	private WebElement productPackage;
	
	@FindBy(xpath = "//select[@formcontrolname='certainity']")
	private WebElement certainityDD;
	
	@FindBy(xpath = "//button[text()=' Save Info ']")
	private WebElement saveInfoBtn;
	
	@FindBy(xpath = "//button[text()='ok']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//span[text()='Technical Requirement ']")
	private WebElement TechnicalRequirementTxtBtn;
	
	@FindBy(xpath = "//select[@formcontrolname='existing_routing_protocol']")
	private WebElement ExistingRoutingProtocolDropdown;
	
	@FindBy(xpath = "//label[text()='URL Filtering']/preceding-sibling::input[@type='checkbox']")
	private WebElement urlFilteringCheckbox;
	
	@FindBy(xpath = "//label[text()='Malware Protection']/preceding-sibling::input[@type='checkbox']")
	private WebElement malwareProtectionCheckbox;
	
	@FindBy(xpath = "//label[text()='Local Attack Defense']/preceding-sibling::input[@type='checkbox']")
	private WebElement localAttackDefenseCheckbox;
	
	@FindBy(xpath = "//label[text()='Intrusion Prevention System']/preceding-sibling::input[@type='checkbox']")
	private WebElement intrusionPreventionSystemCheckbox;
	
	@FindBy(xpath = "//label[contains(text(), 'Public Cloud Access')]/following-sibling::div//span[@class='labels']")
	private WebElement publicCloudAccessTglBtn;
	
	@FindBy(xpath = "//label[text()='CPE Requirement*:']/following-sibling::div//span[@class='labels']")
	private WebElement cpeRequirementTglBtn;
	
	@FindBy(xpath = "//select[@formcontrolname='public_cloud_access_dropdown']")
	private WebElement publicCloudAccessDropdown;
	
	@FindBy(xpath = "//span[text()='View/Edit']")
	private WebElement viewEditTxtBtn;
	
	@FindBy(xpath = "//span[text()='Enter CPE Details']")
	private WebElement enterCPEDetailsTxtBtn;
	
	@FindBy(xpath = "//select[@formcontrolname='oem_model_id']")
	private WebElement oemModelDropdown1;
	
	@FindBy(xpath = "(//select[@formcontrolname='oem_model_id'])[2]")
	private WebElement oemModelDropdown2;
	
	@FindBy(xpath = "//select[@formcontrolname='cpe_model_id']")
	private WebElement cpeModelDropdown1;
	
	@FindBy(xpath = "(//select[@formcontrolname='cpe_model_id'])[2]")
	private WebElement cpeModelDropdown2;
	
	@FindBy(xpath = "(//input[@placeholder='No. of Devices'])[1]")
	private WebElement noOfDevicesTxtField1;
	
	@FindBy(xpath = "(//input[@placeholder='No. of Devices'])[2]")
	private WebElement noOfDevicesTxtField2;
	
	@FindBy(xpath = "//a[text()='+ Add Another']")
	private WebElement addAnotherTxt;
	
	@FindBy(xpath = "//a[text()='Save']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//select[@formcontrolname='topology']")
	private WebElement topologyDD;
	
	@FindBy(xpath = "//select[@formcontrolname='internet_req']")
	private WebElement internetRequiredDD;
	
	@FindBy(xpath = "//a[text()='Save Info']")
	private WebElement saveInfoBtn2;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement messageTechReq;
	
	@FindBy(xpath = "//button[text()='ok']")
	private WebElement okBtn2;
	
	@FindBy(xpath = "//span[text()='Site Information ']")
	private WebElement siteInformationTxt;
	
	@FindBy(xpath = "//span[text()=' Upload XLSX file ']")
	private WebElement uploadXLSXfileTxt;
	
	@FindBy(xpath = "//input[@name='files[]']")
	private WebElement selectFileTxt;
	
	@FindBy(xpath = "//a[text()='Upload File ']")
	private WebElement uploadFileBtn;
	
	@FindBy(xpath = "//a[text()='Save Info']")
	private WebElement saveInfoBtn3;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement siteMessage;
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn3;
	
	@FindBy(xpath = "//a[text()=' Check Feasibility ']")
	private WebElement checkFeasibilityBtn;
	
	@FindBy(xpath = "//span[text()='Qualify']")
	private WebElement qualifyTxt;
	
	@FindBy(xpath = "//label[text()='Delivery Timeframe* :']/../descendant::input[@class='form-control form-control-sm with_trash p-0 ng-untouched ng-pristine ng-valid']")
	private WebElement deliveryTimeframeCalendarImg;
	
	@FindBy(xpath = "//div[contains(@aria-label,'March 25')]/span")
	private WebElement march25Date;
	
	@FindBy(xpath = "//div[contains(@aria-label,'April 30')]/span")
	private WebElement april30Date;
	
	@FindBy(xpath = "//input[@placeholder='Select Priority']")
	private WebElement priorityDD;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> priorityList;
	
	@FindBy(xpath = "//input[@placeholder='Select Certainty']")
	private WebElement certainity2DD;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> certainity2List;
	
	@FindBy(xpath = "//input[@placeholder='Offered Discount']")
	private WebElement offeredDiscountTFA;
	
	@FindBy(xpath = "//input[@placeholder='Select Payment Mode']")
	private WebElement paymentModeDD;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> paymentModeList;
	
	@FindBy(xpath = "(//*[local-name()='svg' and @class='feather feather-calendar'])[2]")
	private WebElement expectedClosureTimeCalendarImg;
	
	@FindBy(xpath = "//button[text()=' Save Changes ']")
	private WebElement saveChangesBtn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement developRecordMessage;
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn4;
	
	@FindBy(xpath = "//span[text()='Won']")
	private WebElement wonTxt;
	
	@FindBy(xpath = "//input[@placeholder='Select KAM Name']")
	private WebElement kamNameDD;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> kamNameList;
	
	@FindBy(xpath = "//span[text()='Accepted']")
	private WebElement acceptedTxt;
	
	@FindBy(xpath = "//span[text()='Assign']")
	private WebElement assignTxt;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement proposeMessage;
	
	@FindBy(xpath = "//a[@id='ngb-nav-2']")
	private WebElement salesLeadID;
	
	@FindBy(xpath = "//div[@class='org_name']/h4")
	private WebElement orgAccountName;
	
	@FindBy(xpath = "//div[@class='org_name']/h5")
	private WebElement orgContactName;
	
	
	
	
	
	
	
	
	
	public SalesHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDate() {
		return dateElement;
	}
	
	
	public void clickOnNewBtn(WebDriver driver)
	{
		waitForElementToBeVisible(driver, newBtn);
		jsclick(driver, newBtn);
	}
	
	public void clickSalesRequestBtn(WebDriver driver)
	{
		jsclick(driver, salesRequestBtn);
	}
	
	public void enterDetails(WebDriver driver, String account, String contact, String product, String contactDuration, String estimatedBudgetCurrency, String estimatedBudget, String billingCycle, String purchaseProduct, String certainity) throws InterruptedException
	{
		jsclick(driver, selectAccountDropdown);
		handleDropdownList(driver, selectAccountList, account);
		
		jsclick(driver, selectContactDropdown);
		handleDropdownList(driver, selectContactList, contact);
		
		jsclick(driver, productDropdown);
		handleDropdownList(driver, productList, product);
		
		handleDropdown(contactDuration, contactDurationDropdown);
		
		Thread.sleep(2000);
		calendarIcon.click();
		
		Select sy = new Select(yearElement);
		sy.selectByVisibleText("2025");
		
		Select sm = new Select(monthElement);
		sm.selectByVisibleText("Dec");
		
		dateElement.click();
		
		handleDropdown(estimatedBudgetCurrency, estimatedBudgetCurrencyDD);
		estimatedBudgetTFA.sendKeys(estimatedBudget);
		
		handleDropdown(billingCycle, billingCycleDD);
		
		handleDropdown(purchaseProduct, purchaseProductDD);
		
		handleDropdown(certainity, certainityDD);
		
	}
	
	public void clickOnSaveInfoBtn()
	{
		if (saveInfoBtn.isEnabled()) {
			saveInfoBtn.click();
		}
		else {
			System.out.println("Save Btn is disabled");
		}
	}
	
	public String getSuccessMessage()
	{
		return successMessage.getText();
	}
	
	public void clickOkBtn()
	{
		okBtn.click();
	}
	
	
	public void getDetailsQualify(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		if (orgContactName.isDisplayed()) {
			System.out.println("Sales Lead ID is : "+salesLeadID.getText());
			System.out.println("Account Name or Organization Name :- "+orgAccountName.getText());
			System.out.println("Contact Name :- "+orgContactName.getText());
		}
		else
		{
			System.out.println("Contact name is not displayed");
		}
		
	}
	
	public void clickOnTechnicalRequirementText(WebDriver driver) throws Exception
	{
		TechnicalRequirementTxtBtn.click();
		Thread.sleep(2000);
	}
	
	
	
	public void enterTechnicalRequirementDetails(WebDriver driver, String existingRoutingProtocol, String securityRequirements, String publicCloudAccessToggleBtn, String publicCloudAccess, String cpeRequirement, String oemModel1, String oemModel2, String cpeModel1, String cpeModel2, String noOfDevices1, String noOfDevices2, String topology, String internetRequired) throws Exception
	{
		handleDropdown(ExistingRoutingProtocolDropdown, existingRoutingProtocol);
		Thread.sleep(2000);
		if (securityRequirements.contains("URL Filtering"))
		{
			urlFilteringCheckbox.click();
		}
		else if(securityRequirements.contains("Malware Protection"))
		{
			malwareProtectionCheckbox.click();
		}
		else if(securityRequirements.contains("Local Attack Defense"))
		{
			localAttackDefenseCheckbox.click();
		}
		else
		{
			intrusionPreventionSystemCheckbox.click();
		}
		
		if (publicCloudAccessToggleBtn.contains("Yes"))
		{
			publicCloudAccessTglBtn.click();
			handleDropdown(publicCloudAccessDropdown, publicCloudAccess);
			
		}		
		
		if (cpeRequirement.contains("Yes"))
		{
			Thread.sleep(2000);
			if (cpeRequirementTglBtn.isDisplayed()) {
				cpeRequirementTglBtn.click();
			}
			else {
				System.out.println("CPE Requirement Toggle Btn is not displayed");
			}
			waitForElementToBeVisible(driver, enterCPEDetailsTxtBtn);
			if (enterCPEDetailsTxtBtn.isDisplayed()) {
				enterCPEDetailsTxtBtn.click();
				waitForElementToBeVisible(driver, noOfDevicesTxtField1);
			}
			else
			{
				System.out.println("'View/Edit' OR 'Enter CPE Details' Text is not displayed");
			}
			handleDropdown(oemModelDropdown1, oemModel1);
			handleDropdown(cpeModelDropdown1, cpeModel1);
			noOfDevicesTxtField1.sendKeys(noOfDevices1);
			jsclick(driver, addAnotherTxt);
			waitForElementToBeVisible(driver, noOfDevicesTxtField2);
			handleDropdown(oemModelDropdown2, oemModel2);
			handleDropdown(cpeModelDropdown2, cpeModel2);
			noOfDevicesTxtField2.sendKeys(noOfDevices2);
			jsclick(driver, saveBtn);
			handleDropdown(topologyDD, topology);
			handleDropdown(internetRequiredDD, internetRequired);
			
			if (saveInfoBtn2.isDisplayed()) {
				jsclick(driver, saveInfoBtn2);
			}
			else {
				System.out.println("Save Info Btn is disabled");
			}
			
		}
		
	}
	
	public String getTechReqMessage()
	{
		return messageTechReq.getText();
	}
	
	public void clickOkBtn2()
	{
		okBtn2.click();
	}
	
	public void clickOnSiteInformationTxtText(WebDriver driver) throws Exception
	{
		jsclick(driver, siteInformationTxt);
		Thread.sleep(2000);
	}
	
	public void uploadFile(WebDriver driver)
	{
		uploadXLSXfileTxt.click();
		fileUploadPopup(driver, selectFileTxt);
		uploadFileBtn.click();
	}
	
	public void clickOnSaveInfoBtn3(WebDriver driver)
	{
		jsclick(driver, saveInfoBtn3);	
	}
	
	public String getSiteSuccessMessage()
	{
		return siteMessage.getText();
	}
	
	public void clickOkBtn3(WebDriver driver)
	{
		jsclick(driver, okBtn3);
	}
	
	public void clickOnCheckFeasibilityBtn(WebDriver driver)
	{
		jsclick(driver, checkFeasibilityBtn);
	}
	
	public void clickOnQualifyTxt(WebDriver driver)
	{
		jsclick(driver, qualifyTxt);
		waitForPageLoad(driver);
	}
	
	public void enterDevelopDetails(WebDriver driver, String priority, String certainity2, String offeredDiscount, String paymentMode) throws Exception
	{
		jsclick(driver, deliveryTimeframeCalendarImg);
		Thread.sleep(2000);
		march25Date.click();
		april30Date.click();
		jsclick(driver, deliveryTimeframeCalendarImg);
		jsclick(driver, priorityDD);
		Thread.sleep(5000);
		handleDropdownList(driver, priorityList, priority);
		jsclick(driver, certainity2DD);
		handleDropdownList(driver, certainity2List, certainity2);
		offeredDiscountTFA.sendKeys(offeredDiscount);
		jsclick(driver, paymentModeDD);
		handleDropdownList(driver, paymentModeList, paymentMode);
		expectedClosureTimeCalendarImg.click();
		
		Select sy = new Select(yearElement);
		sy.selectByVisibleText("2025");
		
		Select sm = new Select(monthElement);
		sm.selectByVisibleText("Dec");
		
		dateElement.click();
		
		jsclick(driver, saveChangesBtn);
		
		
	}
	
	public String getDevelopRecordMessage()
	{
		return developRecordMessage.getText();
	}
	
	public void clickOkBtn4()
	{
		okBtn4.click();
	}
	
	public void clickOnWonTxt(WebDriver driver)
	{
		jsclick(driver, wonTxt);
		waitForPageLoad(driver);
	}
	
	public void enterProposeDetails(WebDriver driver, String kamName, String date) throws Exception
	{
		jsclick(driver, kamNameDD);
		Thread.sleep(2000);
		handleDropdownList(driver, kamNameList, kamName);
		Thread.sleep(2000);
		
		if (calendarIcon.isDisplayed()) {
			calendarIcon.click();
		}
		else {
			System.out.println("Calendar Icon is not presents");
		}
		
		Select sy = new Select(yearElement);
		sy.selectByVisibleText("2025");
		
		Select sm = new Select(monthElement);
		sm.selectByVisibleText("Dec");
		commonDateClick(driver, date);
		
	}
	
	public void commonDateClick(WebDriver driver, String date)
	{
		WebElement element = driver.findElement(By.xpath("//div[text()='"+date+"']"));
		element.click();
	}
	
	public void clickOnAcceptedTxt(WebDriver driver)
	{
		jsclick(driver, acceptedTxt);
		waitForPageLoad(driver);
	}
	
	public void clickOnAssignTxt(WebDriver driver)
	{
		jsclick(driver, assignTxt);
		waitForPageLoad(driver);
	}
	
	public String getProposeMessage()
	{
		return proposeMessage.getText();
	}
}
