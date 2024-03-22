package com.iCustomer.pageobjectrepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iCustomer.genericutilities.Container;
import com.iCustomer.genericutilities.WebDriverUtility;

/**
 * @author abhishek.birana
 */
public class Customer360HomePage extends WebDriverUtility {
	
	@FindBy(xpath = "//*[text()='360 Home']")
	private WebElement home360Btn;
	
	@FindBy(xpath = "//title[text()='iCustomer']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//span[text()='New']")
	private WebElement newBtn;
	
	@FindBy(xpath = "//a[text()='Organization']")
	private WebElement organizationBtn;
	
	@FindBy(xpath = "//span[text()='Create Single']")
	private WebElement createSingleBtn;
	
	@FindBy(xpath = "//a[text()=' Proceed ']")
	private WebElement proceedBtn1;
	
	@FindBy(xpath = "//input[@formcontrolname='organisation_name']")
	private WebElement organisationName;
	
	@FindBy(xpath = "//input[@formcontrolname='registration_no']")
	private WebElement registrationNumber;
	
	@FindBy(xpath = "//input[@placeholder='Select Industry']")
	private WebElement industryDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> industryList;
	
	@FindBy(xpath = "//textarea[@formcontrolname='description']")
	private WebElement descriptionTxt;
	
	@FindBy(xpath = "//input[@placeholder='Select Parent Organization']")
	private WebElement parentOrganizationDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> parentOrganizationList;
	
	@FindBy(xpath = "//input[@placeholder='Select Cluster']")
	private WebElement clusterDropwown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> clusterList;
	
	@FindBy(xpath = "//input[@placeholder='Select Tier']")
	private WebElement tierDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> tierList;
	
	@FindBy(xpath = "//h4[text()='Organization Details']/ancestor::div[@class='Prod_list']/descendant::input[@formcontrolname='address_1']")
	private WebElement address1;
	
	@FindBy(xpath = "//h4[text()='Organization Details']/ancestor::div[@class='Prod_list']/descendant::input[@formcontrolname='address_2']")
	private WebElement address2;
	
	@FindBy(xpath = "//h4[text()='Organization Details']/ancestor::div[@class='Prod_list']/descendant::input[@placeholder='Pin/Zip']")
	private WebElement pinCode;
	
	@FindBy(xpath = "//select[@formcontrolname='country_id']")
	private WebElement countryName;
	
	@FindBy(xpath = "//input[@placeholder='Select State']")
	private WebElement stateNameDropdown;
	
	@FindBy(xpath = "//ul[@class='dataList ng-star-inserted']/li")
	private List<WebElement> stateNameList;
	
	
	@FindBy(xpath = "//h4[text()='Organization Details']/ancestor::div[@class='Prod_list']/descendant::input[@placeholder='City']")
	private WebElement cityName;
	
	@FindBy(xpath = "//input[@placeholder='Firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@placeholder='Lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@formcontrolname='spoc_email']")
	private WebElement emailId;
	
	@FindBy(xpath = "//select[@formcontrolname='phone_code']")
	private WebElement phoneCode;
	
	@FindBy(xpath = "//input[@formcontrolname='spoc_phone']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "//a[text()='Save Info']")
	private WebElement saveInfoBtn;
	
	@FindBy(xpath = "//button[text()='Ok']")
	private WebElement okBtn;
	
	@FindBy(xpath = "//*[@class='mt-2 px-5']/button[text()=' Proceed ']")
	private WebElement proceedBtn2;
	
	@FindBy(xpath = "//*[@data-off='No']")
	private WebElement billingAddrToggleBtn;
	
	@FindBy(xpath = "//button[text()='Save Info']")
	private WebElement saveInfoBtn2;
	
	@FindBy(xpath = "//button[text()=' Proceed ']")
	private WebElement proceedBtn3;
	
	@FindBy(xpath = "//button[text()='Finish']")
	private WebElement finishBtn;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement okBtn2;
	
	
	
	
	public Customer360HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOn360HomeButton(WebDriver driver) throws InterruptedException
	{
		home360Btn.click();
	}
	
	public String getPageTitle(WebDriver driver)
	{
		return pageTitle.getText();
	}
	
	public void clickOnNewButton(WebDriver driver)
	{
		newBtn.click();
	}
	
	public void clickOnOrganizationButton(WebDriver driver)
	{
		organizationBtn.click();
	}
	
	public void clickOnCreateSingleButton(WebDriver driver) throws Exception
	{
		createSingleBtn.click();
	}
	
	public void clickOnProceedButton(WebDriver driver)
	{
		proceedBtn1.click();
	}
	
	public void enterAllRequiredDetails(WebDriver driver, String organizationName, String registrationNo, String industry, String description, String parentOrganization, String cluster, String tier, String organizationAddressLine1, String organizationAddressLine2, String pin, String country, String state, String city, String sPOCFirstName, String sPOCLastName, String sPOCEmail, String sPOCPhoneCode, String mobileNumber)
	{
		organisationName.sendKeys(organizationName);
		System.out.println("Organization Name is : "+organizationName);
		registrationNumber.sendKeys(registrationNo);
		
		industryDropdown.click();
		handleDropdownList(driver, industryList, industry);
		
		descriptionTxt.sendKeys(description);
		
		parentOrganizationDropdown.click();
		handleDropdownList(driver, parentOrganizationList, parentOrganization);
		
		clusterDropwown.click();
		handleDropdownList(driver, clusterList, cluster);
		
		tierDropdown.click();
		handleDropdownList(driver, tierList, tier);
		
		address1.sendKeys(organizationAddressLine1);
		address2.sendKeys(organizationAddressLine2);
		pinCode.sendKeys(pin);
		
		handleDropdown(country, countryName);
		
		
		stateNameDropdown.click();
		handleDropdownList(driver, stateNameList, state);
		cityName.sendKeys(city);
		firstName.sendKeys(sPOCFirstName);
		System.out.println("SPOC First Name is : "+sPOCFirstName);
		lastName.sendKeys(sPOCLastName);
		System.out.println("SPOC Last Name is : "+sPOCLastName);
		emailId.sendKeys(sPOCEmail);
		System.out.println("SPOC Email is : "+sPOCEmail);
		handleDropdown(phoneCode, sPOCPhoneCode);
		phoneNumber.sendKeys(mobileNumber);
		System.out.println("SPOC Mobile Number is : "+mobileNumber);
		
	}
	
	public void clickOnSaveInfoButton(WebDriver driver)
	{
		saveInfoBtn.click();
	}
	
	public void clickOnOkButton(WebDriver driver)
	{
		okBtn.click();
	}
	
	public void clickOnProceedBtn2Button(WebDriver driver)
	{
		proceedBtn2.click();
	}
	
	public void clickOnToggelBtn(WebDriver driver)
	{
		billingAddrToggleBtn.click();
	}
	
	public void clickOnSaveInfoBtn2(WebDriver driver)
	{
		saveInfoBtn2.click();
	}
	
	public void clickOnProceedBtn3(WebDriver driver)
	{
		proceedBtn3.click();
	}
	
	public void clickOnFinishBtn(WebDriver driver)
	{
		finishBtn.click();
	}
	
	public String getOrgMessage(WebDriver driver)
	{
		return successMessage.getText();
	}
	
	public void clickOnOkBtn2(WebDriver driver)
	{
		okBtn2.click();
	}
	
	
	

}
