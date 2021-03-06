package com.main.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.Product.WebEventListener;

/**
 * @author Ashwani
 * @version 1.0
 */

public class Base_Test {

	public static WebDriver driver;
	public static Properties prop;
	public static File file;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	/**
	 * This method read the properties file to read the credential.
	 */
	public static void readPropertyFile() {

		try {
			file = new File(System.getProperty("user.dir") + "/src/resource/java/config.prop");
			FileInputStream file_read = new FileInputStream(file);
			prop = new Properties();
			prop.load(file_read);

		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * This method is used for open the browser.
 */
	public static void initializeBrowser() {
		// String browserName = prop.getProperty("browser");

		if (driver == null) {
			driver = new ChromeDriver();
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;

			// if(browserName.equals("chrome")){
			// driver = new ChromeDriver();
		}
		/*
		 * else if(browserName.equals("FF")){ driver = new FirefoxDriver(); }
		 * else { System.out.println("Browser is not open"); }
		 */
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	/**
	 * This method used for implicitly wait during the execution time.
	 */
	public static void waitForPageLoaded() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Used to the JavaScript method for page scroll down.
	 */
	public static void pageScrolldown() {
		JavascriptExecutor down = (JavascriptExecutor) driver;
		down.executeScript("window.scrollBy(0,500)", "");

	}
	
	/**
	 * Used to the JavaScript method for page scroll up.
	 */

	public static void pageScrollUp() {
		JavascriptExecutor up = (JavascriptExecutor) driver;
		up.executeScript("scroll(0, -500);");
	}

	/**
	 * JavaScript method used for click on element.
	 * @param element  it receive the xpath using javaScript method  
	 * @throws Exception if the element is not visible it throws no such element exception
	 */
	public static void javaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (Exception e) {
			System.out.println("Unable to click on element " + e.getStackTrace());
		}
	}
	
	/**
	 * This method used for refresh the page.
	 */

	public static void refresh() {
		driver.navigate().refresh();
	}
	
	public static void waitForElement(WebElement element) throws Error
	{
		new WebDriverWait(driver, 90)
        .until(ExpectedConditions.visibilityOf(element));
		
	}	
	
	/**
	 * 
	 * @param Used for generate alphabetic number
	 * @return Alphabetic Number
	 */
	
	public static String generateRandomString(int length){
		  return RandomStringUtils.randomAlphabetic(length);
		 }
		 
		 public static String generateRandomNumber(int length){
		  return RandomStringUtils.randomNumeric(length);
		 }
		 
		 public static String generateRandomAlphaNumeric(int length){
		  return RandomStringUtils.randomAlphanumeric(length);
		 } 
		 public static String generateStringWithAllobedSplChars(int length,String allowdSplChrs){
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    allowdSplChrs;
		  return RandomStringUtils.random(length, allowedChars);
		 }
		 
		 public static String generateEmail(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String email="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  email=temp.substring(0,temp.length()-9)+"@gmail.com";
		  return email;
		 }
		 
		 public static String generateUrl(int length) {
		  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
		    "1234567890" +   //numbers
		    "_-.";   //special characters
		  String url="";
		  String temp=RandomStringUtils.random(length,allowedChars);
		  url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
		  return url;
		 }
	
}