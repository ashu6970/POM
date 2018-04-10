package com.qa.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.utils.WebEventListener;

public class BaseTest {
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

			driver = new ChromeDriver();
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			// EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
			 driver.get("https://www.google.com");
			

			// if(browserName.equals("chrome")){
			// driver = new ChromeDriver();
		
		/*
		 * else if(browserName.equals("FF")){ driver = new FirefoxDriver(); }
		 * else { System.out.println("Browser is not open"); }
		 */

	}

	public void selectIndustry() {
		//driver.findElement(By.xpath("//*[@id='addProjectForm']/div[5]/div[1]/div/button")).click();
		 List<WebElement> se = new Select(driver.findElement(By.xpath("[@id='addProjectForm']/div[5]/div[1]/div/button"))).getOptions();
		//List<WebElement> options = driver.findElements(By.xpath("//form[@id='addProjectForm']/child::div[5]/div[1]/div[1]/div/ul[1]"));
		System.out.println(se.size());
		//Random selecttype = new Random();
		//int list= selecttype.nextInt(options.size());
		//System.out.println(list);
		}
}
