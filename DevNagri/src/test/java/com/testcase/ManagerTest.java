package com.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.Manager;

public class ManagerTest extends Base_Test {
	
	public Manager manager =null;
	@Test(priority=1)
	public void doMangerLogin()
	{								
		manager=new Manager();
		//driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/input[1]")).sendKeys("manager@fourtek.com");
		//driver.findElement(By.xpath("//form[@id='loginform']/div[2]/div[1]/input[1]")).sendKeys("secret");
		manager.login("test.manager@devnagri.com","secret");
		//driver.findElement(By.xpath("//form[@id='loginform']/div[4]/div[1]/button[1]")).click();
	}
	@Test(priority=2)
	public void selectTheCreatedProject() throws Exception
	{
		manager.selectCreatedProject();	
		pageScrolldown();
	}
	
	@Test(priority=3)
	public void selectOrder() throws Exception
	{
		manager.createdOrder();	
		manager.assign();
	}
	
	@Test(priority=4)
	public void selectLanguageTranslator()
	{
		manager.assignLanguageTranslator();
	}
	
	@Test(priority=5)
	public void assignProjectToTranslator() throws InterruptedException
	{
		Thread.sleep(3000);
		manager.assignToTranslator();
		Assert.assertEquals(manager.assignProjectToTranslator(),"Successfully assigned!");
		System.out.println(manager.assignProjectToTranslator());
	}
	@Test(priority=6)
	public void doManagerLogout() throws InterruptedException
	{
	manager.managerLogout();
	}

	@AfterSuite
	public void managerTranslationPage() throws Exception
	{
		manager.login("test.manager@devnagri.com","secret");
		manager.selectCreatedProjectAfterSuite();	
		pageScrolldown();
		manager.createdOrder();
		manager.translator();
		manager.automatedTranslationUpDown();
		//manager.selectWords();
		manager.completeTranslation();
		System.out.println("Abc");
		
		
	}
}
