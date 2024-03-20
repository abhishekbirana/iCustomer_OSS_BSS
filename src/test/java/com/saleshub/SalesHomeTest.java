package com.saleshub;


import org.testng.Assert; 
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.HomePage;
import com.iCustomer.pageobjectrepository.ProductPage;
import com.iCustomer.pageobjectrepository.SalesHomePage;

@Listeners(com.iCustomer.genericutilities.ListenersImplementationClass.class)
public class SalesHomeTest extends BaseClass
{
	SalesHomePage shp = null;
	
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
	}
	
	@Test(priority = 2)
	public void openSalesHomeModule() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnSalesHome(driver);
		shp = new SalesHomePage(driver);
		shp.clickOnNewBtn(driver);
		shp.clickSalesRequestBtn(driver);
	}
	
	
	@Test(priority = 3)
	public void fillQualify() throws Exception
	{
		
		shp = new SalesHomePage(driver);
		
		String account = eUtil.readDataFromExcel("Sales Home", 1, 0);
		String contact = eUtil.readDataFromExcel("Sales Home", 1, 1);
		String product = eUtil.readDataFromExcel("Sales Home", 1, 2);
		String contactDuration = eUtil.readDataFromExcel("Sales Home", 1, 3);
		String estimatedBudgetCurrency = eUtil.readDataFromExcel("Sales Home", 1, 5);
		String estimatedBudget = eUtil.readDataFromExcel("Sales Home", 1, 6);
		String billingCycle = eUtil.readDataFromExcel("Sales Home", 1, 7);
		String purchaseProduct = eUtil.readDataFromExcel("Sales Home", 1, 8);
		String certainity = eUtil.readDataFromExcel("Sales Home", 1, 10);
		
		shp.enterDetails(driver, account, contact, product, contactDuration, estimatedBudgetCurrency, estimatedBudget, billingCycle, purchaseProduct, certainity);

		shp.clickOnSaveInfoBtn();

		System.out.println(shp.getSuccessMessage());

		Assert.assertEquals(shp.getSuccessMessage(), "Successfully Updated");

		shp.clickOkBtn();
		
		String existingRoutingProtocol = eUtil.readDataFromExcel("Technical Requirement", 1, 0);
		String securityRequirements = eUtil.readDataFromExcel("Technical Requirement", 1, 1);
		String publicCloudAccessToggleBtn = eUtil.readDataFromExcel("Technical Requirement", 1, 2);
		String publicCloudAccess = eUtil.readDataFromExcel("Technical Requirement", 1, 3);
		String cpeRequirement = eUtil.readDataFromExcel("Technical Requirement", 1, 4);
		String oemModel1 = eUtil.readDataFromExcel("Technical Requirement", 1, 5);
		String oemModel2 = eUtil.readDataFromExcel("Technical Requirement", 2, 5);
		String cpeModel1 = eUtil.readDataFromExcel("Technical Requirement", 1, 6);
		String cpeModel2 = eUtil.readDataFromExcel("Technical Requirement", 2, 6);
		String noOfDevices1 = eUtil.readDataFromExcel("Technical Requirement", 1, 7);
		String noOfDevices2 = eUtil.readDataFromExcel("Technical Requirement", 2, 7);
		String topology = eUtil.readDataFromExcel("Technical Requirement", 1, 8);
		String internetRequired = eUtil.readDataFromExcel("Technical Requirement", 1, 9);
		
		
		
		shp.clickOnTechnicalRequirementText(driver);
		Thread.sleep(2000);
		wUtil.scrollActionToBottom(driver);
		System.out.println("1");
		shp.enterTechnicalRequirementDetails(driver, existingRoutingProtocol, securityRequirements, publicCloudAccessToggleBtn, publicCloudAccess, cpeRequirement, oemModel1, oemModel2, cpeModel1, cpeModel2, noOfDevices1, noOfDevices2, topology, internetRequired);
		
		System.out.println(shp.getTechReqMessage());
		
		Assert.assertEquals(shp.getTechReqMessage(), "Technical Requirement is updated successfully");
		shp.clickOkBtn2();
		
//		shp.clickOnSiteInformationTxtText(driver);
//		shp.uploadFile(driver);
//		wUtil.scrollActionToBottom(driver);
//		shp.clickOnSaveInfoBtn3(driver);
//		
//		System.out.println(shp.getSiteSuccessMessage());
//		
//		Assert.assertEquals(shp.getSiteSuccessMessage(), "Site updated successfully");
//		
//		shp.clickOkBtn3(driver);
//		shp.clickOnCheckFeasibilityBtn(driver);
//		wUtil.scrollActionToTop(driver);
//		shp.clickOnQualifyTxt(driver);
		
		
	}
	
//	@Test(priority = 4)
	public void fillDevelop() throws Exception
	{
		shp = new SalesHomePage(driver);
		
		String priority = eUtil.readDataFromExcel("Develop", 1, 0);
		String certainity2 = eUtil.readDataFromExcel("Develop", 1, 1);
		String offeredDiscount = eUtil.readDataFromExcel("Develop", 1, 2);
		String paymentMode = eUtil.readDataFromExcel("Develop", 1, 3);
		shp.enterDevelopDetails(driver, priority, certainity2, offeredDiscount, paymentMode);
		
		System.out.println(shp.getDevelopRecordMessage());
		
		Assert.assertEquals(shp.getDevelopRecordMessage(), "Develop Record updated !!");
		shp.clickOkBtn4();
		shp.clickOnWonTxt(driver);
	}
	
	
//	@Test(priority = 5)
	public void fillPropose() throws Exception
	{
		shp = new SalesHomePage(driver);
		String kamName = eUtil.readDataFromExcel("Propose", 1, 0);
		String date = eUtil.readDataFromExcel("Propose", 1, 1);
		shp.enterProposeDetails(driver, kamName, date);
		shp.clickOnAcceptedTxt(driver);
		System.out.println(shp.getProposeMessage());
		
		Assert.assertEquals(shp.getProposeMessage(), "success");
		shp.clickOkBtn3(driver);
		
	}
	

}
