package com.qa.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reviwer {

	
	public static void main(String[] args) throws InterruptedException
			{
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://staging.devnagri.com/");
		driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/input[1]")).sendKeys("test.reviewer@devnagri.com");
		driver.findElement(By.xpath("//form[@id='loginform']/div[2]/div[1]/input[1]")).sendKeys("secret");
		driver.findElement(By.xpath("//form[@id='loginform']/div[4]/div[1]/button[1]")).click();
		
		Thread.sleep(3000);
		List<WebElement> count =driver.findElements(By.xpath("//div[@class='col-md-3 col-xm-4 col-xs-6']/div[1]/a[1]"));
		int c=count.size();
		int size = c-1;
		count.get(size).click();
		
	
	//	Thread.sleep(2000);

		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", count.get(1));
		
	//	System.out.println("A");
		
		
		
			}

}
