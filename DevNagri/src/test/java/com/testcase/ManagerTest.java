package com.testcase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.Manager;

public class ManagerTest extends Base_Test {
	
	public Manager manager =null;
	/**
	 *Verify the functionality of the manager login.
	 */
	@Test(priority=1)
	public void doMangerLogin()
	{								
		manager=new Manager();
		manager.login("test.manager@devnagri.com","secret");
		Assert.assertEquals(manager.managerLoginValidation(),"Manage Users");	
	}
	
	/**
	 * This method used for select the create project.
	 */
	@Test(priority=2)
	public void selectTheCreatedProject() throws Exception
	{
		manager.selectCreatedProject();	
		pageScrolldown();
	}
	
	/**
	 * Click on the order button for assing the project to the translator.
	 */
	@Test(priority=3)
	public void selectOrder() throws Exception
	{
		manager.createdOrder();	
		Thread.sleep(2000);
		manager.assign();
	}
	
	/**
	 *Verify the functionality when project assign to the translator in hindi language.
	 */
	@Test(priority=4)
	public void selectLanguageTranslator()
	{
		manager.assignLanguageTranslator();
	}
	
	/**
	 * Verify the functionality of assign project to the translator.
	 */
	@Test(priority=5)
	public void assignProjectToTranslator() throws InterruptedException
	{
		Thread.sleep(3000);
		manager.assignToTranslator();
		System.out.println(manager.assignProjectToTranslator());
	}
	/**
	 * Verify the functionality of logout.
	 */
	@Test(priority=6)
	public void doManagerLogout() throws InterruptedException
	{
	manager.managerLogout();
	}

	/**
	 * This method used for login and perform to complete the translated words.
	 */
	@AfterSuite
	public void managerTranslationPage() throws Exception
	{
		manager.login("test.manager@devnagri.com","secret");
		manager.selectCreatedProject();	
		pageScrolldown();
		manager.createdOrder();
		manager.translator();
		manager.automatedTranslationUpDown();
		//manager.selectWords();
		manager.completeTranslation();
		Thread.sleep(2000);
		manager.managerLogout();			
	}
	
	/**
	 * This method used to verified the translated word after done by the manager.
	 */
	@AfterSuite(dependsOnMethods = { "managerTranslationPage" })
	public void ClientTranslationPage() throws Exception
	{
		manager.login("test.client@devnagri.com","secret");
		manager.selectCreatedProject();
		Thread.sleep(2000);
		manager.createdOrder();
		manager.clientTranslator();
		manager.completeTranslation();
		Thread.sleep(2000);
		manager.clientLogout();		
	}
	
	
}
