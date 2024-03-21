package com.iCustomer.genericutilities;

import java.io.IOException; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.iCustomer.pageobjectrepository.LoginPage;
import com.iCustomer.pageobjectrepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consists of all Basic Configuration Annotations
 * @author abhishek.birana
 *
 */
public class BaseClass {
	
	public JavaUtility jUtil = new JavaUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	
	public static WebDriver driver;	
	
	
	@BeforeSuite
	public void bsConfig() throws IOException
	{
//		System.out.println(" =====> Database Connection Successfully <===== ");
	}

	
	@BeforeTest
	public void bcConfig() throws Exception
	{
		String BROWSER = pUtil.readDatafromPropertyFile("browser");
		String URL = pUtil.readDatafromPropertyFile("url");
		
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--incognito");
           
            driver = new ChromeDriver(option);
            
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			option.addArguments("--remote-allow-origins=*");
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(option);
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
			System.out.println("=====> "+BROWSER+" Browser launch successful <===== ");
		}
		
		
		else
		{
			System.out.println("Invalid Browser Name in property file");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	
	@BeforeClass
	public void bmConfig() throws IOException, InterruptedException
	{
		String USERID = pUtil.readDatafromPropertyFile("userid");
	    String PASSWORD = pUtil.readDatafromPropertyFile("password");
	    
	    LoginPage lp = new LoginPage(driver);
	    lp.loginToApp(USERID, PASSWORD);
	    
	    System.out.println(" =====> Login is Successful <===== ");
	    
	    String parentId = driver.getWindowHandle();
		eUtil.writeParentIdIntoExistingExcelSheet("WindowsData", 1, 0, parentId);
	}

	

	@AfterClass
	public void amConfig() throws Exception
	{
		ProductPage pp = new ProductPage(driver);
		String parentId = eUtil.readDataFromExcel("WindowsData", 1, 0);
		driver.close();
		wUtil.switchToParentTab(driver, parentId);
		pp.logOutOfApp(driver);
		System.out.println(" =====> Logout is Successful <===== ");
	}
	
	@AfterTest
	public void acConfig() throws Exception
	{
		Thread.sleep(2000);
		driver.quit();
		System.out.println(" =====> browser closed Successfully <===== ");
		
		
	}
	
	@AfterSuite
	public void asConfig() throws IOException, InterruptedException
	{
		
		
		SendEmail smwa = new SendEmail();
		smwa.sendingEmail("abhishek.birana@in2ittech.com","Sagar.Mehra@in2ittech.com","This email sent using JavaMailer API from Automation Testing. This mail contains emailable-report.html file.","Testing Report by Abhishek Birana");
		
		
//		System.out.println(" =====> Database Closed Successfully <===== ");
		

	}
	
	
}
