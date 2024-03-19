package com.iCustomer.pageobjectrepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.iCustomer.genericutilities.BaseClass;
import com.iCustomer.genericutilities.Container;

/**
 * @author abhishek.birana
 */
public class LoginPage extends BaseClass
{
	
	
	//Locators
	
	@FindBy(id = "emailAddress")
	private WebElement userIdEdt;
	
	@FindBy(id = "password")
	private WebElement passwordEdt;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInBtn;
	
	
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	
	
	public void loginToApp(String USERID, String PASSWORD) throws InterruptedException
	{
		userIdEdt.sendKeys(USERID);
		passwordEdt.sendKeys(PASSWORD);
		signInBtn.click();
	}
	
}