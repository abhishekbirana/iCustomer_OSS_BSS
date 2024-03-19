package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.ProductPage;

public class AA extends BaseClass {

	@Test
	public void runAAA() throws InterruptedException
	{
		ProductPage pp = new ProductPage(driver);
		pp.clickOnICustomerLaunchButton(driver);
		Thread.sleep(15000);
		String actualTitle = pp.getPageTitle(driver);
		String expectedTitle = "CUSTOMER USER CONSOLE";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualTitle, expectedTitle, "Title is not Matched");
		Thread.sleep(2000);
		wUtil.switchToWindow(driver, "iCustomer");
		System.out.println("runAAA");
		sa.assertAll();
	}
	
	@Test
	public void runAAB()
	{
		System.out.println("runAAB1");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(true, true);
		System.out.println("runAAB2");
		sa.assertAll();
		System.out.println("runAAB3");
	}
	
	@Test
	public void runAAC()
	{
		Assert.fail();
		System.out.println("runAAC");
	}
	
	
}
