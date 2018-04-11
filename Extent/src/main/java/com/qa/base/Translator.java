package com.qa.base;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Translator extends GenerateData {

	public static void main(String[] args) throws InterruptedException {
		GenerateData G = new GenerateData();
		WebDriver driver=new ChromeDriver();
		driver.get("http://staging.devnagri.com/");
		driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/input[1]")).sendKeys("test.translator@devnagri.com");
		driver.findElement(By.xpath("//form[@id='loginform']/div[2]/div[1]/input[1]")).sendKeys("secret");
		driver.findElement(By.xpath("//form[@id='loginform']/div[4]/div[1]/button[1]")).click();
		Thread.sleep(3000);
		
		List<WebElement> count =driver.findElements(By.xpath("//div[@class='col-md-3 col-xm-4 col-xs-6']"));
		Thread.sleep(2000);
		count.get(count.size() - 1).click();
		//System.out.println(count.size());
		System.out.println(count.get(count.size() - 1));
		  //System.out.println(elements.get(elements.size() - 1).getText());
		
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//div[@class='col-md-12 automated-control']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		//driver.findElement(By.xpath("")).click();
		List<WebElement> drop = driver.findElements(By.xpath("//div[@class='sentence-list  default']"));
		for(int i=0; i<drop.size();i++)
		{
			Thread.sleep(2000);
			drop.get(i).click();
			driver.findElement(By.xpath("//div[@class='row translation-view']/div[2]/textarea")).sendKeys(G.generateRandomString(20));
			Thread.sleep(1000);
			WebElement element1 = driver.findElement(By.xpath("//div[@class='col-md-7 right-controls text-right p-t-0']/button[1]"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", element1);
			driver.findElement(By.xpath("//div[@class='col-md-7 right-controls text-right p-t-0']/button[1]")).click();
			
			}
	
	}

}