package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.ProductPage;

public class BB extends BaseClass{

	@Test
	public void runBBA() throws InterruptedException
	{
		ProductPage pp = new ProductPage(driver);
		pp.clickOnICustomerLaunchButton(driver);
		Thread.sleep(15000);
		String actualTitle = pp.getPageTitle(driver);
		String expectedTitle = "CUSTOMER USER CONSOLE";
		Assert.assertEquals(actualTitle, expectedTitle, "Title is not Matched");
		Thread.sleep(2000);
		wUtil.switchToWindow(driver, "iCustomer");
		System.out.println("runBBA");
	}
	
	@Test
	public void runBBB()
	{
		System.out.println("runBBB");
	}
	
	@Test
	public void runBBC()
	{
		System.out.println("runBBC");
	}
	
	
}
