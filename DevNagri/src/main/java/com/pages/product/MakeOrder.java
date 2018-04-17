package com.pages.product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.main.product.Base_Test;

public class MakeOrder extends Base_Test{
	
	@FindBy(xpath="//div[@class='container-fluid']/child::div[2]/div[2]/div[1]/a[1]")
	WebElement btn_proceedNow;
	
	@FindBy(xpath="//div[@class='center-v-h-card']/div/div[3]/div[1]/button[2]")
	WebElement btn_makeAndPayment;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/div[1]/ul[1]/li[6]/a[1]")
	WebElement btn_logout;
	
	@FindBy(xpath="//ul[@class='navbar-nav my-lg-0']/child::li[4]/a[1]")
	WebElement btn_user;
	
	@FindBy(xpath="//*[@id='main-wrapper']/div/div/div/div/h5")
	WebElement translationOrder;
	
	
	/**
	 *  To initialize the PageFactory model
	 */
	public MakeOrder()
	{
		PageFactory.initElements(driver,this);
	}
	 
	/**
	 * Perform the click on the confirm and Make payment button.
	 * @throws Exception 
	 */
	public void makeAndPayment() throws Exception
	{
		
		Thread.sleep(10000);
		 WebElement element1 = driver
					.findElement(By.xpath("//div[@class='center-v-h-card']/div/div[3]/div[1]/button[2]"));
		 javaScriptClick(element1);	 
	}
	
	public void clientlogout() throws InterruptedException
	
	{
		waitForElement(btn_user);
		 btn_user.click();
		 Thread.sleep(2000);
		 btn_logout.click();
	}
	
	public String validationOrder()
	{
	return translationOrder.getText();
	}
	 
}
