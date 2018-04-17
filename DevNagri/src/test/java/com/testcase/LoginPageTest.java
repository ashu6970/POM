package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.main.product.Base_Test;
import com.pages.product.CreateProject;
import com.pages.product.LoginPage;

public class LoginPageTest extends Base_Test {
	public LoginPage loginpage;
	public CreateProject createproject;

	
	/**
	 * This method used for Open the browser.
	 * and call the method from main class to initialize the browser.
	 */
	@Test(priority = 1)
	public void openBrowser() {
		readPropertyFile();
		initializeBrowser();
		loginpage = new LoginPage();
	}
	
	/**
	 * Entered the incorrect value in the email text field 
	 * and verify the functionality of login page
	 */
	@Test(priority = 2, groups = "Negative")
	public void invalidEmail() {
		loginpage.HomePagelogin(generateEmail(20),generateRandomString(9));
		loginpage.clearEditBox();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
	}

	/**
	 * Entered the incorrect value in the password text field
	 * and verify the functionality of login page
	 */
	@Test(priority = 3, groups = "Negative")
	public void invalidPassword() {
		loginpage.HomePagelogin(generateEmail(20),generateRandomString(7));
		loginpage.clearEditBox();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
	}
	
	/**
	 * Entered the incorrect value in the email and password text field.
	 * and verify the functionality of login page
	 */
	@Test(priority = 4, groups = "Negative")
	public void invalidPwdEmail() {
		loginpage.HomePagelogin(generateEmail(20),generateRandomString(8));
		loginpage.clearEditBox();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
	}
	
	/**
	 * Entered the case sensitive word in the password text field
	 * and verify the functionality of login page
	 */
	@Test(priority = 5, groups = "Negative")
	public void checkCaseSensitive() {
		loginpage.HomePagelogin(generateEmail(20), "SECRET");
		loginpage.clearEditBox();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
		
		loginpage.HomePagelogin(generateEmail(20), "sECrET");
		loginpage.clearEditBox();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
	}
	
	/**
	 * Entered the Unicode Transformation Format text in the password text field
	 * and verify the functionality of login page
	 */
	@Test(priority = 6, groups = "Negative")
	public void checkUnicodeTransformationFormat() {
		loginpage.HomePagelogin(generateEmail(20), "सीक्रेट");
		loginpage.clearEditBox();
		loginpage.forCredentialMatch();
		Assert.assertEquals(loginpage.forCredentialMatch(), "These credentials do not match our records.");
	}
	/**
	 * This method used for forget password
	 */
	@Test(priority =6,enabled=false)
	public void forgetPassword()
	{
		loginpage.forgetPass("client@fourtek.com");
		WebElement login_txt = driver.findElement(By.xpath("//div[@id='main-wrapper']/div[1]"));
		String txt = login_txt.getText();
		Assert.assertEquals(txt, "We have e-mailed your password reset link!");
	}
		/**
		 * This method used for login
		 * and verify the functionality of the login page.
		 */
	@Test(priority = 7)
	public void doLogin() {
		
		createproject= loginpage.HomePagelogin(prop.getProperty("username"), prop.getProperty("password"));
		waitForPageLoaded();
		Assert.assertEquals(loginpage.forLoginSucussfully(),"Start New Project");
		System.out.println(loginpage.forLoginSucussfully());
	}

}
