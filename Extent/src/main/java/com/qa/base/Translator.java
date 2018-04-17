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
		
		WebElement element = driver.findElement(By.xpath("//div[@class='container-fluid']/div/div[30]/div/a[1]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		WebElement element1 = driver.findElement(By.xpath("//div[@class='col-md-12 automated-control']"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		
		//driver.findElement(By.xpath("")).click();
		List<WebElement> drop = driver.findElements(By.xpath("//div[@class='sentence-list  default']"));
		
		int z= drop.size();
		for(int i=0; i<z;i++)
		{
			Thread.sleep(2000);
			System.out.println(drop.get(i).getTagName());
			System.out.println(i);
			drop.get(i).click();
			driver.findElement(By.xpath("//div[@class='row translation-view']/div[2]/textarea")).sendKeys(G.generateRandomString(20));
			Thread.sleep(1000);
			WebElement element2 = driver.findElement(By.xpath("//div[@class='col-md-7 right-controls text-right p-t-0']/button[1]"));
			JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			executor2.executeScript("arguments[0].click();", element2);
			
			
			}
	
	}

}
