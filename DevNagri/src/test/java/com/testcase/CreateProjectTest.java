package com.testcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.CreateProject;
import com.pages.product.FileUpload;

public class CreateProjectTest extends Base_Test {
	
	public CreateProject createproject;
	public FileUpload fileload;
	
	/**
	 * This method used for click on the start new project button
	 *  and create the object of the create project page.
	 */

	@Test(priority = 0)
	public void startProject() {
			createproject = new CreateProject();
			createproject.startNewProject();
			Assert.assertEquals(createproject.forStartNewProject(),"Project Description");
			System.out.println(createproject.forStartNewProject());
	}
	
		
	/**
	 * Without selecting any options click on the lets start button.
	 * @throws Exception 
	 */
		@Test(priority = 1, groups = "Negative")
	public void withOutSelectAllOptions() throws Exception {
		createproject.clickOnSubmit();
		Assert.assertEquals(createproject.withoutSelectAnyField(),"The name field is required.");
		System.out.println(createproject.withoutSelectAnyField());

	}
		
	/**
	 * Only type the project name then click on the lets start button.
	 * @throws Exception 
	 */
	
	@Test(priority = 2, groups = "Negative")
	public void onlyEnterProjectName() throws Exception
	{
		createproject.enterProjectName(generateRandomString(10));
		Thread.sleep(2000);
		createproject.clickOnSubmit();
		Assert.assertEquals(createproject.onlyEnterProjectName(), "The languages field is required.");
		System.out.println(createproject.onlyEnterProjectName());
	}
	
	
	/**
	 * Only type all field except project name then click on the lets start button.
	 * @throws Exception 
	 */
	
	@Test(priority = 3, groups = "Negative")
	public void onlySelectTargetLanguage() throws Exception
	{
		createproject.clearEditBox();
		createproject.selectTargetLanguage();
		createproject.clickOnSubmit();
		Assert.assertEquals(createproject.withoutSelectAnyField(), "The name field is required.");
	}
	
	/**
	 * Enter the name in project text field.
	 */
	@Test(priority = 4)
	public void typeProjectName() {
	
			createproject.enterProjectName(generateRandomString(10));
	
	}
   /**
   * Used for select the project type. 
   */
	@Test(priority = 5)
	public void projectType() {
		createproject.selectPlateform();

	}
	/**
	   * Used for select the industry type. 
	   */
	@Test(priority = 6,enabled =false)
	public void industryType() {
		createproject.selectIndustry();

	}
	
	/**
	 * This method is used for select the target language. 
	 */
	@Test(priority = 7)
	public void targetLanguage() {
		createproject.selectTargetLanguage();
	}
	
	/**
	 * To perform click on the lets start button.
	 * @throws Throwable 
	 */
	@Test(priority = 8)
	public void doClickOnLetsStartButton() throws Throwable {
		pageScrolldown();
		fileload=createproject.clickOnSubmit();
	    Thread.sleep(3000);
	 Assert.assertEquals(createproject.validationOfCreateProject(),"http://staging.devnagri.com/projects");	
	 System.out.print(createproject.validationOfCreateProject());

	}

}
