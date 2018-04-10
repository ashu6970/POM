package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.main.product.Base_Test;
import com.pages.product.LoginPage;

public class LoginPageTest extends Base_Test {

	public LoginPage loginpage;

	@Test(priority = 1)
	public void openBrowser() {
		readPropertyFile();
		initializeBrowser();
		loginpage = new LoginPage();

	}

	@Test(priority = 5)
	public void doLogin() {
		loginpage.HomePagelogin(prop.getProperty("username"), prop.getProperty("password"));
		waitForPageLoaded();
		String tittle = loginpage.Validate();
		Assert.assertEquals(tittle, "Start New Project");
		System.out.println(tittle);
	}

	// throw new skipException("skipping test case as run mode is y")
	@Test(priority = 2, groups = "Negative")
	public void invalidEmail() throws InterruptedException {
		loginpage.HomePagelogin("yuidif@fourtek.com", "secret");
		loginpage.clearEditBox();
		WebElement login_txt = driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/span[1]/strong[1]"));
		String txt = login_txt.getText();
		Assert.assertEquals(txt, "These credentials do not match our records.");
	}

	@Test(priority = 3, groups = "Negative")
	public void invalidPassword() throws InterruptedException {
		loginpage.HomePagelogin("client@fourtek.com", "12233");
		loginpage.clearEditBox();
		WebElement login_txt = driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/span[1]/strong[1]"));
		String txt = login_txt.getText();
		Assert.assertEquals(txt, "These credentials do not match our records.");
		System.out.println(txt);
	}

	@Test(priority = 4, groups = "Negative")
	public void invalidPwdEmail() {
		loginpage.HomePagelogin("cssddddt@fourtek@com", "12233");
		loginpage.clearEditBox();
		WebElement login_txt = driver.findElement(By.xpath("//form[@id='loginform']/div[1]/div[1]/span[1]/strong[1]"));
		String txt = login_txt.getText();
		Assert.assertEquals(txt, "These credentials do not match our records.");
	}

}
