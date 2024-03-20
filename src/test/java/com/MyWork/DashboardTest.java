package com.MyWork;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.DashboardPage;
import com.iCustomer.pageobjectrepository.HomePage;
import com.iCustomer.pageobjectrepository.ProductPage;

@Listeners(com.iCustomer.genericutilities.ListenersImplementationClass.class)
public class DashboardTest extends BaseClass
{
	DashboardPage shp = null;
	
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
	public void CreateEvent() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnDashboard(driver);
		DashboardPage dp = new DashboardPage(driver);
		dp.clickOnplusBtn(driver);
		wUtil.waitForPageLoad(driver);
		String EventName=eUtil.readDataFromExcel("Create Event form", 1, 0);
		String Description=eUtil.readDataFromExcel("Create Event form", 1, 1);
		String ShareWith=eUtil.readDataFromExcel("Create Event form", 1, 6);
		dp.filleventform(driver, EventName, Description, ShareWith);
		
		String actualMessage = dp.getSuccessMessage();
		String expectedMessage = "Success!!";
		
		System.out.println(actualMessage);
		Assert.assertEquals(actualMessage, expectedMessage, "Failed to Create an Event");
		dp.clickOkBtn();
		
	}
	
	
	
	

}
