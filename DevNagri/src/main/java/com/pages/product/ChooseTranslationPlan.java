package com.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.product.Base_Test;

public class ChooseTranslationPlan extends Base_Test {
	
	@FindBy(xpath="//*[@class='col-md-8 success']/child::center/a[1]")
	WebElement btn_choosePlan;
	
	@FindBy(xpath="//*[@id='main-wrapper']/div[2]/div/div/div/div[1]/div[2]/div[2]/center/a[2]")
	WebElement btn_Dashboard;
	
	@FindBy(xpath="//div[@class='center-v-h-card']/div[2]/div/a")
	WebElement btn_processNow;
	
	@FindBy(xpath="//*[@id='main-wrapper']/div[2]/div/div/div/div[1]/div[2]/div[2]/center/p/text()[1]")
	WebElement validateForFileUpload;
	
	@FindBy(xpath="//*[@id='main-wrapper']/div/div/div/div/h5")
	WebElement ValidateChooseplan;
	
	@FindBy(xpath="//div[@class='col-md-8 success']/center/h3")
	WebElement validationFileUpload;
	
	
	
	public ChooseTranslationPlan()
	{
		PageFactory.initElements(driver,this);
	}
	
	/**
	 * Perform the click on the choose plan button.
	 * @throws Exception 
	 */
	public void choosePlan() throws Exception
	{
	 waitForElement(btn_choosePlan);
		 WebElement element = driver
					.findElement(By.xpath("//*[@class='col-md-8 success']/child::center/a[1]"));
		 javaScriptClick(element);	
	
		 
	 }
	/**
	 * Perform the click on the dashboard button.
	 */
	public void dashBoard()
	{
		btn_Dashboard.click();
	}
	
	/**
	 * This is perform the click on the process now button
     * @throws Exception
     * @return Object of make an order page. 
	 
	 */
	public MakeOrder process() throws Exception
	{
		javaScriptClick(btn_processNow);
		//driver.findElement( By.xpath("//*[@id='main-wrapper']/div[2]/div/div/div/div[1]/div[2]/div/a")).click();
		//btn_processNow.click();
		
		return new MakeOrder();
	}
	
	/**
	 * Method used for validation
	 */
	public String forFileUpload()
	 {
		return validateForFileUpload.getText();
	 }
	
	public String forchooseplan()
	 {
		return ValidateChooseplan.getText();
	 }
	public String fileUploadValidation()
	 {
		return validationFileUpload.getText();
	 }
	
}


