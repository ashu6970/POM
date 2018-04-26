package com.pages.product;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.main.product.Base_Test;

public class Reviewer extends Base_Test{
	
	@FindBy(xpath = "//form[@id='loginform']/div[1]/div[1]/input[1]") // Enter the email id
	WebElement txtbn_username;

	@FindBy(xpath = "//form[@id='loginform']/div[2]/div[1]/input[1]") // Enter the email password
	WebElement txtbn_password;

	@FindBy(xpath = "//form[@id='loginform']/div[4]/div[1]/button[1]") // To Select the login button													
	WebElement btn_login;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/a[1]") // Select the user button
	WebElement btn_user;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/div[1]/ul[1]/li[5]/a[1]")  //  Select User logout button
	WebElement btn_logout;
	
	@FindBy(xpath = "//div[@class='col-md-12 automated-control']")  // To Select automated Translation.													
	WebElement btn_automatedTranslationuUpDown;
	
	@FindBy(xpath = "//div[@class='col-md-3 col-xm-4 col-xs-6'][last()]/div/a")  // To select the project.													
	WebElement selectReviewerProject;
	
	//@FindBys(@FindBy(xpath = "//div[@class='sentence-list  warning hover']")) // Select the all the path of words.
	// List<WebElement> selectAllWords;
	
	@FindBy(xpath = "//div[@class='col-md-5 right-controls p-t-0']/button[1]")  // To select the accept button.													
	WebElement btn_accpet;
	
	@FindBy(xpath = "//div[@class='col-md-5 right-controls p-t-0']/button[2]")  // To select the reject button.												
	WebElement btn_reject;
	
	@FindBy(xpath = "//div[@class='col-md-1 drops form-buttons p-t-0 no-border']/button") // To select the complete button.													
	WebElement btn_complete;
	
	@FindBy(xpath = "//a[@href='http://staging.devnagri.com']")  // To select the devnagri logo.													
	WebElement devlogo;
	
	@FindBy(xpath = "//ul[@id='sidebarnav']/li[2]/a/span")  // To select Translator Application												
	WebElement validationReviewerLogin;
	
	@FindBy(xpath="//div[@class='row control-bar trans m-l-0 m-r--2']/div/h4")  // To get the project description text on translation page.
	WebElement validationAssignProject;
	

	@FindBy(xpath="//div[@class='col-md-7 right-controls text-right p-t-0']/button[2]")  // To get the save and next text on translation page.
	WebElement validationAutomatedUpDown;
	
	public Reviewer() {

		PageFactory.initElements(driver, this);
	}

	/**
	 * This method used for receive the email and password.
	 * @param username
	 * @param password
	 */
	public void login(String username,String password)
	{
		txtbn_username.clear();
		txtbn_username.clear();											
		txtbn_username.sendKeys(username);
		txtbn_password.sendKeys(password);
		btn_login.click();	
	}

	/**
	 * Used for select the assign project.
	 * @throws Exception
	 */
	public void assignProject() throws Exception 
	{
		Thread.sleep(2000);
		javaScriptClick(selectReviewerProject);
	}
	
	/**
	 * This method used for click on automated button for UP and down.
	 * @throws Exception
	 */
	public void automatedTranslationUpDown() throws Exception
	{
		Thread.sleep(3000);
		javaScriptClick(btn_automatedTranslationuUpDown);
	}
	
	/**
	 * Method used for click on all the words and do trnaslated all the words.
	 * @throws Throwable
	 */

	public void acceptTranslation() throws Throwable
	{
		List<WebElement> count =driver.findElements(By.xpath("//div[@class='sentence-list  warning hover']"));
		int size = count.size();
		for(int i=0; i<size;i++)
		{
			Thread.sleep(3000);
			count.get(i).click();
			Thread.sleep(2000);
			javaScriptClick(btn_accpet);
			
		}
		
	}
	
	/**
	 * Method used for click on the complete button.
	 * @throws Exception
	 */
	public void completeReviewer() throws Exception
	{
	waitForElement(btn_complete);
	javaScriptClick(btn_complete);
	}
	
	/**
	 * Used for click on devnagri logo.
	 * @throws InterruptedException
	 */
	public void clickDeva() throws InterruptedException
	{
		devlogo.click();
		Thread.sleep(2000);
		
	}
	
	/**
	 * This method used for reviewer logout.
	 * @throws InterruptedException
	 */
	public void reviewerLogout() throws InterruptedException
	
	  {
		 btn_user.click();
		 Thread.sleep(2000);
		 btn_logout.click();
	  }
	
	/**
	 * Used for validations
	 * @return
	 */
	public String vaidReviewerLogin()
	{
		return validationReviewerLogin.getText();
	}
	
	public String validAssignProject()
	 {
		 return validationAssignProject.getText();
	 }
	
	 public String validAutomatedUpDown()
	 {
		 return validationAutomatedUpDown.getText();
	 }
	
}
