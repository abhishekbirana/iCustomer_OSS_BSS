package com.MyWork;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.pageobjectrepository.HomePage;
import com.iCustomer.pageobjectrepository.ProductPage;
import com.iCustomer.pageobjectrepository.TaskPage;

@Listeners(com.iCustomer.genericutilities.ListenersImplementationClass.class)
public class TaskTest extends BaseClass
{
	TaskPage tp = null;
	
//	@Test(priority = 1)
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
	
//	@Test(priority = 2)
	public void openTasksModule() throws Exception
	{
		HomePage hp = new HomePage(driver);
		hp.clickOnTasks(driver);
		tp = new TaskPage(driver);
		Thread.sleep(3000);
		tp.clickOnNewBtn(driver);
		Thread.sleep(2000);
		wUtil.waitForPageLoad(driver);
		
	}
	
//	@Test(priority = 3)
	public void fillCreateNewTask() throws Exception
	{
		String taskSummary = eUtil.readDataFromExcel("Create New Task", 1, 0);
		String description = eUtil.readDataFromExcel("Create New Task", 1, 1);
		String status = eUtil.readDataFromExcel("Create New Task", 1, 2);
		String relatedCaseID = eUtil.readDataFromExcel("Create New Task", 1, 3);
		String caseIDStage = eUtil.readDataFromExcel("Create New Task", 1, 4);
		String dueOnDate = eUtil.readDataFromExcel("Create New Task", 1, 5);
		String dueOnMonth = eUtil.readDataFromExcel("Create New Task", 1, 6);
		String dueOnYear = eUtil.readDataFromExcel("Create New Task", 1, 7);
		String dueOnHours = eUtil.readDataFromExcel("Create New Task", 1, 8);
		String dueOnMinutes = eUtil.readDataFromExcel("Create New Task", 1, 9);
		String assignedTo = eUtil.readDataFromExcel("Create New Task", 1, 10);

		
		tp.fillCreateNewTask(driver, taskSummary, description, status, relatedCaseID, caseIDStage, dueOnDate, dueOnMonth, dueOnYear, dueOnHours, dueOnMinutes, assignedTo);
		tp.clickOnSaveBtn(driver);
		
		System.out.println(tp.getTasksMessage());
		
		Assert.assertEquals(tp.getTasksMessage(), "Success");
		
		tp.clickOkBtn(driver);
		
	}
	
	

}
