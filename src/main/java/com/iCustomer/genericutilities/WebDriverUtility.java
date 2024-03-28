package com.iCustomer.genericutilities;

import java.awt.AWTException; 
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class contains all the generic methods related to web driver actions
 * @author abhishek.birana
 *
 */
public class WebDriverUtility {
	
	/**
	 * this method will maximize the window
	 * @author abhishek.birana
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * @author abhishek.birana
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	
	/**
	 * This method will open the window in full screen mode
	 * @author abhishek.birana
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver)
	{
		driver.manage().window().fullscreen();
	}
	
	
	/**
	 * This method will wait for 20 seconds for the page to get loaded
	 * @author abhishek.birana
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**
	 * This method will wait for an element to become clickable
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait for an element to become visible
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will handle dropdown with the help of last index
	 * @author abhishek.birana
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element)
	{
		Select s = new Select(element);
		int selectOption = s.getOptions().size();
		s.selectByIndex(selectOption-1);
	}
	
	
	/**
	 * This method will handle dropdown with the help of index
	 * @author abhishek.birana
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	
	
	
	/**
	 * This method will handle dropdown with the help of value
	 * @author abhishek.birana
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown with the help of visible text
	 * @author abhishek.birana
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will handle List with the help of Visible text
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 * @param text
	 */
	public void handleDropdownList(WebDriver driver, List<WebElement> element, String text)
	{
		for (WebElement webElement : element)
		{
			if(webElement.getText().trim().equals(text))
			{
				webElement.click();
				break;
			}
			
		}
	}
	
	/**
	 * This method will perform mouse hover action on a web element
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click action anywhere on the web page
	 * @author abhishek.birana
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click action on a web element
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on the web page
	 * @author abhishek.birana
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a web element
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation
	 * @author abhishek.birana
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcEle, WebElement dstEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * this method will press and release the enter key
	 * @author abhishek.birana
	 * @throws AWTException
	 */
	public void pressEnter() throws AWTException
	{
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will handle frame based on index
	 * @author abhishek.birana
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or ID
	 * @author abhishek.birana
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch the control to immediate parent frame
	 * @author abhishek.birana
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch the control to default frame
	 * @author abhishek.birana
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method will accept the alert pop up
	 * @author abhishek.birana
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert pop up
	 * @author abhishek.birana
	 * @param driver
	 */
	public void dismisAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will get the alert text
	 * @author abhishek.birana
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	/**
	 * This method will upload file from system
	 * @author abhishek.birana
	 * @param driver
	 * @param element
	 */
	public void fileUploadPopup(WebDriver driver, WebElement element)
	{
		File f = new File(ConstantsUtility.siteInformationFilePath);
		element.sendKeys(f.getAbsolutePath());
	}
	
	/**
	 * This method will take screenshot and return the path of destination
	 * @author abhishek.birana
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(WebDriver driver, String ScreenShotName) throws IOException
	{
		if (driver == null)
		{
	        throw new IllegalArgumentException("WebDriver instance is null");
	    }
		
		try {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\ScreenShots\\"+ScreenShotName+".png");
		Files.copy(src, dst);
		
		return dst.getAbsolutePath();
		}
		
		catch (ClassCastException e)
		{
	        throw new IllegalArgumentException("WebDriver does not support taking screenshots", e);
	    } catch (IOException e)
		{
	        throw new IOException("Failed to capture screenshot: " + e.getMessage());
	    }
		
	}
	
	/**
	 * This method will perform random scroll action
	 * @author abhishek.birana
	 * @param driver
	 */
	public void scrollActionToPerticular(WebDriver driver, int x, int y)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
	
	/**
	 * This method will perform bottom scroll action
	 * @author abhishek.birana
	 * @param driver
	 */
	public void scrollActionToBottom(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	/**
	 * This method will perform top scroll action
	 * @author abhishek.birana
	 * @param driver
	 */
	public void scrollActionToTop(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0);");
	}
	
	
	/**
	 * This method will perform top scroll action upto perticular element
	 * @author abhishek.birana
	 * @param driver
	 */
	public void scrollActionToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	
	
	/**
	 * This method will click by using Javascript Executor
	 * @author abhishek.birana
	 * @param driver
	 * @param ele
	 */
	public void jsclick(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}
	
	/**
	 * This method will open a new Tab in Current Browser
	 * @author abhishek.birana
	 * @param driver
	 */
	public void openNewTab(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
	}
	
	/**
	 * This method will open a new Window of Current Browser
	 * @author abhishek.birana
	 * @param driver
	 */
	public void openNewWindow(WebDriver driver)
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
	}
	
	
	/**
	 * This method will perform zoom action
	 * @author abhishek.birana
	 * @param driver
	 */
	public void zoomBrowser(WebDriver driver, double zoomLevel) {
        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        // Execute JavaScript to set zoom level
        js.executeScript("document.body.style.zoom = '" + zoomLevel + "'");
    }
	
	/**
	 * This method will switch the control to immediate parent frame
	 * @author abhishek.birana
	 * @param driver
	 */
	public void switchToParentTab(WebDriver driver, String parentId)
	{
		driver.switchTo().window(parentId);
	}
	

	
	/**
	 * This method will switch to window based on window title
	 * @author abhishek.birana
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step 1: Capture all the window IDs
		Set<String> allWinIDs = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(allWinIDs);
		
		//Step 2: Navigate to each window ID
		for(String winID:al)
		{
			//Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			//Step 4: compare the title with required title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
			
		}
		
		
//		// OR //
//		Iterator it = allWinIDs.iterator();
//		String parentid = (String) it.next();
//		String childid = (String) it.next();
//		driver .switchTo().window(childid);
		
	}
	
	/**
	 * This method will switch to tab
	 * @author abhishek.birana
	 * @param driver
	 * @param tabno
	 */
	
	public void switchToTab(WebDriver driver, int tabno)
	{
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		ArrayList<String> li = new ArrayList<String>(windows);
		System.out.println(li);
		driver.switchTo().window(li.get(tabno));
		for (String string : li) {
			System.out.println(driver.switchTo().window(string).getTitle());
		}
		
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
