package com.pages.product;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//*[@id='container']/div[2]/div[2]/div/h4/a") // To Select the project
	WebElement selectProject1;
	
	@FindBy(xpath = "//div[@class='container-fluid']/child::div[5]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]/div[1]/button[1]/i[1]") // To Select order button													
	WebElement btn_selectOrder;
	
	@FindBy(xpath = "//*[@id='files']/div/table/tbody/tr/td[5]/div/div/a[2]") // To Select the translator button												
	WebElement btn_translatorProject;
	
	@FindBy(xpath = "//*[@id='files']/div/table/tbody/tr/td[5]/div/div/a[1]") // To Select the client translator button												
	WebElement btn_clientTranslatorProject;
	
	@FindBy(xpath = "//div[@class='col-md-5 right-controls p-t-0']/button[1]")  // To select the accept button.													
	WebElement btn_accpet;
	
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

	@FindBy(xpath = "//div[@class='alert alert-success']") //Validation
	WebElement validationAssignProject;

	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/div[1]/ul[1]/li[5]/a[1]")  //  Select User logout button
	WebElement btn_logout;

	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/div[1]/ul[1]/li[6]/a[1]")  //  Select User logout button
	WebElement btn_clientlogout;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/a[1]") // Select the user button
	WebElement btn_user;

	@FindBy(xpath = "//div[@class='col-md-12 automated-control']")  // To Select automated Translation.													
	WebElement btn_automatedTranslationuUpDown;
	
	@FindBy(xpath = "//div[@class='col-md-1 drops form-buttons p-t-0 no-border']/button")  // To Enter the text in the text field.													
	WebElement btn_complete;
	
	@FindBy(xpath = "//ul[@id='sidebarnav']/li[2]/a/span")  // To valid the manager login.											
	WebElement managerLoginValid;
	
	// New User Interface.
	
	@FindBy(xpath = "//div[@class='row page-titles']/child::div[3]/div[2]/div[1]/h5[4]")  // To select the order button.											
	WebElement btn_order;
	
	@FindBy(xpath = "//div[@class='center-v-h-card']/child::div[2]/div[1]/div[1]/div[8]/span[2]")  // To select the action button.											
	WebElement btn_action;
	
	@FindBy(xpath = "//div[@class='glossary-ctrl-drop']/child::a[3]")  // To select the assign button.											
	WebElement btn_assign;
	
	@FindBy(xpath = "//div[@class='card m-b-60 no-border']/div/table/tbody/tr/td[2]/a[1]")  // To select assign translator button.											
	WebElement btn_assignTranslator;
	
	@FindBy(xpath = "//form[@id='assignForm']/input[2]")  // To select assign button.											
	WebElement btn_assignToTranslator;
	
	
	
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
	/**
	 * Used for JavaScript method for click
	 */
	public void selectCreatedProject() throws Exception
	{
		javaScriptClick(selectProject);
	}
	
	/**
	 * It's used for click on the Hindi assign Translator button.
	 */
	public void assignLanguageTranslator()
	{
		btn_assignTranslatorToHindi.click();
	}
	
	/**
	 * Used for click on assign translator button
	 */
	public void assignToTranslator()
	{
		 btn_assingToTranslator.click();
		
	}
	
	/**
	 * Click on order button and wait for the element.
	 */
	public void createdOrder() throws Exception
	{
				waitForElement(btn_selectOrder);
				javaScriptClick(btn_selectOrder);			
	}
	
	/**
	 * click on button to assign the project to the translator.
	 */
	public void assign()
	{
		btn_assignProject.click();
	}
	
	/**
	 *Used to click on translator project. 
	 */
	public void translator()
	{
		btn_translatorProject.click();
	}
	
	/**
	 * It is used to clicj on client translator button.
	 */
	public void clientTranslator()
	{
		btn_clientTranslatorProject.click();
	}
	/**
	 * Used to click on automated translation button.
	 */
	public void automatedTranslationUpDown() throws Exception
	{
		Thread.sleep(3000);
		 javaScriptClick(btn_automatedTranslationuUpDown);
	}
	
	/**
	 * Click on the complete button after completion of translation.
	 */
	public void completeTranslation() throws Exception
	{
	waitForElement(btn_complete);
	javaScriptClick(btn_complete);
	}

	/**
	 * It is used for select all the words on the translation page.
	 */
	public void selectWords() throws Exception
	{
	List<WebElement> selectAllWords = driver.findElements(By.xpath("//div[@class='sentence-list  success']"));
	int size=selectAllWords.size();
	
	for(int i=0; i<size;i++)
	{
		Thread.sleep(2000);
		selectAllWords.get(i).click();
		Thread.sleep(3000);	
		javaScriptClick(btn_accpet);
	}
	
	}
	
	public String assignProjectToTranslator()
	{
	return validationAssignProject.getText();
	}
	
	/**
	 * Used for logout form manager module.
	 */
      public void managerLogout() throws InterruptedException
	  {
    	  Thread.sleep(2000);
		 btn_user.click();
		 Thread.sleep(2000);
		 btn_logout.click();
	  }
      /**
       * It is used to logout from the client module.
       */
      public void clientLogout() throws InterruptedException
      {
    	  Thread.sleep(2000);
 		 btn_user.click();
 		 Thread.sleep(2000);
    	  btn_clientlogout.click();
      }
      
      public String managerLoginValidation()
      {
    	  return managerLoginValid.getText();
      }
      
}
