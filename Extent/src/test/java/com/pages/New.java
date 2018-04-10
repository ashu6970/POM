package com.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.GenerateData;



public class New extends BaseTest {
	
	
	//What is log? : capturing info/activities at the time of program execution. 
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
	GenerateData genData;
		Logger log = Logger.getLogger(New.class);
	
	@Test(priority = 1)
	public void openBrowser() {
		genData=new GenerateData();
		System.out.println(genData.generateRandomAlphaNumeric(30));
		System.out.println(genData.generateRandomString(20));
		System.out.println(genData.generateEmail(30));
		System.out.println(genData.generateStringWithAllobedSplChars(30, "abc123_-."));
		System.out.println(genData.generateRandomNumber(10));
		System.out.println(genData.generateRandomNumber(9));
		
		log.info("Open the new browser");
		System.out.println("New");;
	}
	@Test(priority = 2)
	public void login()
	{
		BaseTest B=new BaseTest();
		initializeBrowser();
		driver.get("http://dev.devnagri.co.in/");
		driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/input[1]")).sendKeys("test.client@devnagri.com");
		driver.findElement(By.xpath("//form[@id='loginform']/div[2]/div[1]/input[1]")).sendKeys("secret");
		driver.findElement(By.xpath("//form[@id='loginform']/div[4]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//div[@id='container']//child::div[1]/div[1]/a[1]")).click();
		B.selectIndustry();
	}
}
