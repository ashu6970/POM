package com.pages.product;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Lists;
import com.main.product.Base_Test;

public class FileUpload extends Base_Test{
	
	@FindBy(xpath="//*[@id='main-wrapper']/div[2]/div[2]/div/div[1]/div[4]/div/h4/a[1]")    // Click on add file button
	 WebElement btn_addNewFile;
	
	@FindBy(xpath="//div[@id='dropzone']/div[1]")    // Click on Upload files here button
	 WebElement btn_dropFileHereToUpload;
	
	@FindBy(xpath="//div[@class='dz-default dz-message']/span[1]")  //Click on drop pop  
	 WebElement btn_dropNewFile;
	
	@FindBy(xpath="//div[@class='center-v-h-card']/child::form[1]/div[1]/div[3]/div[1]/button[1]")    
	 WebElement btn_submit;
	
	@FindBy(xpath="//select[@id='select']")    
	 WebElement select_fileFormat;
	
	@FindBy(xpath="//h4[@class='modal-title step-1']")    
	 WebElement valid;
	
	@FindBy(xpath="//div [@class='alert alert-danger']")
	WebElement errorparsing;
	
	@FindBy(xpath="//div[@class='col-md-6 support']")
	WebElement supportFileFormat;	
	
	/**
	 *  To initialize the PageFactory model
	 */
	public FileUpload()
	{
     PageFactory.initElements(driver, this);
	}
	
	/**
	 * Perform the click on the Add new File button.
	 * @throws Exception throws if the element is not found.
	 */
	public void addNewFile() throws Exception
	{
		try
		{
		Thread.sleep(1000);
		btn_dropFileHereToUpload.click();
		}
		
	catch(Exception e)
		{
		e.printStackTrace();
		throw(e);
		}
	}
	
	public void dropNewFile() throws InterruptedException
	{
		
		btn_dropNewFile.click();
		Thread.sleep(3000);
		}

	
	public void setClipboardData(String string) {
		
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	/**
	 * Used robot class to perform the action using keyboard.
	 * @param location it receive the location of the file which is given in the prop file.
	 */
	public void upLoadFile(String location) 
	{
        try
        {
            setClipboardData(location);               
            Robot robot = new Robot();         
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
        } 
        
        catch (Exception e) 
        {
        	e.printStackTrace();
        }
	}
	
	/**
	 * Method used for click on the submit button.
	 * @throws Exception 
	 */
	public ChooseTranslationPlan submit() throws Exception
	{
		Thread.sleep(3000);
		WebElement element1 = driver
				.findElement(By.xpath("//div[@class='center-v-h-card']/child::form[1]/div[1]/div[3]/div[1]/button[1]"));
		javaScriptClick(element1);
		
		return new ChooseTranslationPlan();
	}
	/**
	 * Handle the pop of select screen and select the file format.
	 */
	public void fileSelectionPop()
	{
		
	try
		{
		select_fileFormat.click();
		WebElement selectDropdown = select_fileFormat;
		Select filetype=new Select(selectDropdown);
		Thread.sleep(3000);
		filetype.selectByIndex(1);
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}	
		}
	
	/**
	 * Used for validation
	 * @return it returns text to valid the case.
	*/
	 public String validate()
	    {
	    	 waitForPageLoaded();
	    	 return valid.getText();
	    	
	    }
	 
	 public String validateErrorParsing()
	 {
		 return errorparsing.getText();
	 }
	
	 public String forValidateFileFormat()
	 {
		return supportFileFormat.getText();
	 }
	 
}
