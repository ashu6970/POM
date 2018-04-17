package com.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.main.product.Base_Test;

public class Manager extends Base_Test{
	
	
	@FindBy(xpath = "//form[@id='loginform']/div[1]/div[1]/input[1]") // Enter the email id
	WebElement txtbn_username;

	@FindBy(xpath = "//form[@id='loginform']/div[2]/div[1]/input[1]") // Enter the email password
	WebElement txtbn_password;

	@FindBy(xpath = "//form[@id='loginform']/div[4]/div[1]/button[1]") // To Select the login button													
	WebElement btn_login;
	
	@FindBy(xpath = "//*[@id='container']/div[2]/div[1]/div/h4/a") // To Select the project
	WebElement selectProject;
	
	@FindBy(xpath = "//div[@class='container-fluid']/child::div[5]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/button[1]/i[1]") // To Select order button													
	WebElement btn_selectOrder;
	
	@FindBy(xpath = "//*[@id='files']/div/table/tbody/tr/td[5]/div/div/a[1]") // To Select the assign button												
	WebElement btn_assignProject;
	
	@FindBy(xpath = "//div[@class='card m-b-60 no-border']/child::div[1]/table/tbody/tr[1]/td[2]/a") // To assign the project Hindi												
	WebElement btn_assignTranslatorToHindi;
	
	@FindBy(xpath = "//div[@class='card m-b-60 no-border']/child::div[1]/table/tbody/tr[2]/td[2]/a")
	WebElement btn_assignTranslatorToPunjabi;
	
	@FindBy(xpath = "//div[@class='card m-b-60 no-border']/child::div[1]/table/tbody/tr[3]/td[2]/a")
	WebElement btn_assignTranslatorToTamil;
	
	@FindBy(xpath = "//div[@class='card m-b-60 no-border']/child::div[1]/table/tbody/tr[4]/td[2]/a")
	WebElement btn_assignTranslatorToGujarati;
	
	@FindBy(xpath = "//div[@class='table-responsive']/child::table/tbody/tr[1]/td[4]/form[1]/input[2]") //Assign project to Translator
	WebElement btn_assingToTranslator;

	@FindBy(xpath = "//div[@class='alert alert-success']") //Assign project to Translator
	WebElement validationAssignProject;

	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/div[1]/ul[1]/li[5]/a[1]")  //  Select User logout button
	WebElement btn_logout;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/a[1]") // Select the user button
	WebElement btn_user;

	public Manager() {

		PageFactory.initElements(driver, this);
	}

	public void login(String username,String password)
	{
		txtbn_username.clear();
		txtbn_username.clear();											
		txtbn_username.sendKeys(username);
		txtbn_password.sendKeys(password);
		btn_login.click();	
	}
	
	public void selectCreatedProject() throws Exception
	{
		javaScriptClick(selectProject);
	}
	
	public void assignLanguageTranslator()
	{
		btn_assignTranslatorToHindi.click();
	}
	
	public void assignToTranslator()
	{
		 btn_assingToTranslator.click();
		
	}
			public void createdOrder() throws Exception
			{
				waitForElement(btn_selectOrder);
				
				javaScriptClick(btn_selectOrder);			
	}
	
	public void assign()
	{
		btn_assignProject.click();
	}

	public String assignProjectToTranslator()
	{
	return validationAssignProject.getText();
	}
	
      public void managerLogout() throws InterruptedException
	
	  {
		 btn_user.click();
		 Thread.sleep(2000);
		 btn_logout.click();
	  }
}
