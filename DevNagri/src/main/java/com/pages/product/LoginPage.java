package com.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.product.Base_Test;

public class LoginPage extends Base_Test {

	@FindBy(xpath = "//form[@id='loginform']/div[1]/div[1]/input[1]") // Enter the email id
	WebElement txtbn_username;

	@FindBy(xpath = "//form[@id='loginform']/div[2]/div[1]/input[1]") // Enter the email password
	WebElement txtbn_password;

	@FindBy(xpath = "//form[@id='loginform']/div[4]/div[1]/button[1]") // To Select the login button													
	WebElement btn_login;

	@FindBy(xpath = ".//*[@id='start-project-card']/div/div/a[1]")
	WebElement valid;

	@FindBy(xpath = "//form[@id='loginform']/div[1]/div[1]/span[1]/strong[1]")
	WebElement credentialMatch_negative;
	
	@FindBy(xpath = "//a[@id='to-recover']")
	WebElement btn_forgetPassword;
	
	@FindBy(xpath = "//*[@id='email3']")
	WebElement editbox_forgetPassword;
	
	@FindBy(xpath = "//*[@id='recoverform']/div[3]/div/button")
	WebElement btn_forgetSubmit;
	
	@FindBy(xpath = "//form[@id='loginform']/div[1]/div[1]/span[1]/strong[1]")
	WebElement credentialDoNotMatch;
	
	@FindBy(xpath = "//*[@id='container']/div[1]/div[1]/a")
	WebElement validloginSucessfully;
	
	/**
	 *  To initialize the PageFactory model
	 */
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Validate the login page title.
	 * @return it return the title of page
	 */
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	/**
	 * This method used for do the login.
	 * @param user it receive the user id.
	 * @param pwd it receive the user password.
	 */
	public CreateProject HomePagelogin(String user, String pwd) {
		
			txtbn_username.clear();
			txtbn_username.sendKeys(user);
			txtbn_password.sendKeys(pwd);
			btn_login.click();
			
			return new CreateProject();
	}
	
	/**
	* Used for validation purpose.
     * @return it returns the text.
	 */
 
	public String Validate() 
	{
		waitForPageLoaded();
		return valid.getText();
	}
	/**
	 * User to clear the email and password text field.
	 */
	public void clearEditBox() 
	{
		txtbn_username.clear();
		txtbn_password.clear();

	}
	
	/**
	 * Used for Forget password.
	 */
	public void forgetPass(String email)
	{
		btn_forgetPassword.click();
		editbox_forgetPassword.clear();
		editbox_forgetPassword.sendKeys(email);
		btn_forgetSubmit.click();
	}
	
	/**
	 * This method used for validation.
	 * @return
	 */
	public String forCredentialMatch()
	{
		return credentialDoNotMatch.getText();
	}	
	
	public String forLoginSucussfully()
	{
		return validloginSucessfully.getText();
	}

}
