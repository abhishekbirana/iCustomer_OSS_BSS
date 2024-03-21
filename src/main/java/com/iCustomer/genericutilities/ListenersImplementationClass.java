package com.iCustomer.genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener Interface of TestNG
 * @author abhishek.birana
 *
 */
public class ListenersImplementationClass implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;

	/**
	 * This is Test Start method it gives details of method which execution is started
	 * @author abhishek.birana
	 */
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.INFO, "-> "+methodName+" - Test Execution started <-");
		System.out.println("-> "+methodName+" - Test Execution started <-");
		
	}

	/**
	 * This is Test Success method it gives details of method which execution is Pass
	 * @author abhishek.birana
	 */
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, "-> "+methodName+" - Test is Passed <-");
		System.out.println("-> "+methodName+" - Test is Passed <-");
		
	}

	
	/**
	 * This is Test Failure method it gives details of method which execution is Failed. If Test Method is getting fail this method will take Screenshot and stored it.
	 * @author abhishek.birana
	 */
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, "-> "+methodName+" - Test is Failed <-");
		System.out.println("-> "+methodName+" - Test is Failed <-");
		test.log(Status.WARNING, result.getThrowable());
		
		/*Take Screen shot for the failed test scripts*/
		
		String screenShotName = methodName+"-"+new JavaUtility().getSystemDateinFormat();
		
		WebDriverUtility wUtil = new WebDriverUtility();
		try {
			String path = wUtil.takeScreenShot(BaseClass.driver, screenShotName);
			test.addScreenCaptureFromPath(path); //attach screen shot to report
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * This is Test Skipped method it gives details of method which execution is Skipped
	 * @author abhishek.birana
	 */
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, "-> "+methodName+" - Test is Skipped <-");
		System.out.println("-> "+methodName+" - Test is Skipped <-");
		test.log(Status.WARNING, result.getThrowable());
	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}


	/**
	 * This is Start method it gives details of method which execution is started and Create Report
	 * @author abhishek.birana
	 */
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-> Suite execution Started <-");
		
		/*Configure the extent reports here*/
		                                                                          //Report-20 Aprl 2023 - 08-23-56.html
		
		String reportName = "Report-"+new JavaUtility().getSystemDateinFormat()+".html";
		Container.webMap.put("REPORT_NAME", reportName);
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".\\ExtentReports\\"+reportName);
		htmlReport.config().setDocumentTitle("iCustomer Execution Report");
		htmlReport.config().setReportName("Automation Report by Abhishek Birana");
		htmlReport.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "http://10.0.1.104:8085/#/login");
		report.setSystemInfo("User Name", "Abhishek Birana");
		report.setSystemInfo("Base Platform", "Windows 10");
		report.setSystemInfo("Reporter Name", "Abhishek");
		
		
	}

	/**
	 * This is Finish method it gives details of method which execution is completed
	 * @author abhishek.birana
	 */
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("-> Suite execution finished <-");
		
		/*Extent report should get generated*/
		report.flush();
		
	}
   
}
