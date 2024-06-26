package com.iCustomer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.Customer360HomePage;
import com.iCustomer.pageobjectrepository.HomePage;
import com.iCustomer.pageobjectrepository.ProductPage;


@Listeners(com.iCustomer.genericutilities.ListenersImplementationClass.class)
public class CreateNewOrganizationTest extends BaseClass {
	
	Customer360HomePage chp = null;
	
	@Test(priority = 1)
	public void launchiCustomerProduct() throws InterruptedException
	{
		ProductPage pp = new ProductPage(driver);
		
		
		pp.clickOnICustomerLaunchButton(driver);
		wUtil.waitForPageLoad(driver);
		
		String actualTitle = pp.getPageTitle(driver);
		String expectedTitle = "CUSTOMER USER CONSOLE";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not Matched");
		Thread.sleep(2000);
		wUtil.switchToWindow(driver, "iCustomer");
		wUtil.waitForPageLoad(driver);
		
	}
	
	@Test(priority = 2)
	public void open360HomeModule() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOn360Home(driver);
		chp = new Customer360HomePage(driver);
		chp.clickOnNewButton(driver);
		chp.clickOnOrganizationButton(driver);
		
		chp.clickOnCreateSingleButton(driver);
		chp.clickOnProceedButton(driver);
		
	}
	
	@Test(priority = 3)
	public void fillDetails() throws Exception
	{
		int num = jUtil.getRandomNumber();
		String text = jUtil.getRandomString();
		String organizationName = eUtil.readDataFromExcel("Organization Details", 1, 0);
		String organizationNameNew = jUtil.getNameChange(organizationName, "Org", num);
		eUtil.writeDataIntoExistingExcelSheet("Organization Details", 1, 0, organizationNameNew);
		eUtil.writeDataIntoExistingExcelSheet("Sales Home", 1, 0, organizationNameNew);
		
		String registrationNo = eUtil.readDataFromExcel("Organization Details", 1, 1);
		String industry = eUtil.readDataFromExcel("Organization Details", 1, 2);
		String description = eUtil.readDataFromExcel("Organization Details", 1, 3);
		String parentOrganization = eUtil.readDataFromExcel("Organization Details", 1, 4);
		String cluster = eUtil.readDataFromExcel("Organization Details", 1, 5);
		String tier = eUtil.readDataFromExcel("Organization Details", 1, 6);
		String organizationAddressLine1 = eUtil.readDataFromExcel("Organization Details", 1, 7);
		String organizationAddressLine2 = eUtil.readDataFromExcel("Organization Details", 1, 8);
		String pin = eUtil.readDataFromExcel("Organization Details", 1, 9);
		String country = eUtil.readDataFromExcel("Organization Details", 1, 10);
		String state = eUtil.readDataFromExcel("Organization Details", 1, 11);
		String city = eUtil.readDataFromExcel("Organization Details", 1, 12);
		
		String sPOCFirstName = eUtil.readDataFromExcel("Organization Details", 1, 13);
		String sPOCFirstNameNew = jUtil.getNameChange(sPOCFirstName, "FN", text);
		eUtil.writeDataIntoExistingExcelSheet("Organization Details", 1, 13, sPOCFirstNameNew);
		
		String sPOCLastName = eUtil.readDataFromExcel("Organization Details", 1, 14);
		String sPOCLastNameNew = jUtil.getNameChange(sPOCLastName, "LN", text);
		eUtil.writeDataIntoExistingExcelSheet("Organization Details", 1, 14, sPOCLastNameNew);
		
		eUtil.writeDataIntoExistingExcelSheet("Sales Home", 1, 1, sPOCFirstNameNew+" "+sPOCLastNameNew);
		
		String sPOCEmail = eUtil.readDataFromExcel("Organization Details", 1, 15);
		String sPOCEmailNew = jUtil.getRandomMail(sPOCEmail, num);
		eUtil.writeDataIntoExistingExcelSheet("Organization Details", 1, 15, sPOCEmailNew);
		
		
		String sPOCPhoneCode = eUtil.readDataFromExcel("Organization Details", 1, 16);
		
		String mobileNumber = eUtil.readDataFromExcel("Organization Details", 1, 17);
		String mobileNumberNew = jUtil.getRandomMobileNumber();
		eUtil.writeDataIntoExistingExcelSheet("Organization Details", 1, 17, mobileNumberNew);
		
		chp.enterAllRequiredDetails(driver, organizationNameNew, registrationNo, industry, description, parentOrganization, cluster, tier, organizationAddressLine1, organizationAddressLine2, pin, country, state, city, sPOCFirstNameNew, sPOCLastNameNew, sPOCEmailNew, sPOCPhoneCode, mobileNumberNew);
		
		chp.clickOnSaveInfoButton(driver);
		
		chp.clickOnOkButton(driver);
		
		chp.clickOnProceedBtn2Button(driver);
		
		
		
		
		chp.clickOnToggelBtn(driver);
		chp.clickOnSaveInfoBtn2(driver);
		chp.clickOnOkButton(driver);
		chp.clickOnProceedBtn3(driver);
		
		chp.clickOnFinishBtn(driver);
		
		String actualText = chp.getOrgMessage(driver);
		String expectedText = "Organization onboarded successfully.";
		
		System.out.println(actualText);
		
		Assert.assertEquals(actualText, expectedText, "Organization Not Created");
		chp.clickOnOkBtn2(driver);
		
	}


}
