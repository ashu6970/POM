package com.pages.product;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.main.product.Base_Test;

public class FileUpload extends Base_Test{
	
	@FindBy(xpath="//a[contains(text(),'Add New File')]")    // Click on add file button
	 WebElement btn_addNewFile;
	
	@FindBy(xpath="//div[contains(@class,'modal-body step-1')]/div[1]")  //Click on drop pop  
	 WebElement btn_dropNewFile;
	
	@FindBy(xpath="//div[contains(@class,'modal-body step-1')]/div[1]/div[1]/div[2]/button[1]")    
	 WebElement btn_process;
	
	@FindBy(xpath="//select[@id='select']")    
	 WebElement select_dropDownListOfSelectFile;
	
	@FindBy(xpath="//h4[@class='modal-title step-1']")    
	 WebElement valid;
	
	
	
	
	public FileUpload()
	{
     PageFactory.initElements(driver, this);
	}
	
	public void addNewFile() throws Exception
	{
		try
		{
		Thread.sleep(1000);
		btn_addNewFile.click();
		}
		
	catch(Exception e)
		{
		e.printStackTrace();
		throw(e);
		}
	}
	
	public void dropNewFile()
	{
		try
		{
		btn_dropNewFile.click();
		Thread.sleep(2000);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		
	}
	
	public void setClipboardData(String string) {
		
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public void upLoadFile(String location) 
	{
        try

        {
            setClipboardData(location);                 //Setting clipboard with file location
            Robot robot = new Robot();                 //native key strokes for CTRL, V and ENTER keys
            dropNewFile();
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
	
	public void process()
	{
		try
		{	
	      btn_process.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fileSelectionPop()
	{
		
	try
		{
		select_dropDownListOfSelectFile.click();
		WebElement selectDropdown = select_dropDownListOfSelectFile;
		Select filetype=new Select(selectDropdown);
		Thread.sleep(2000);
		filetype.selectByIndex(1);
		}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		
	}
	 public String Validate()
	    {
	    	 waitForPageLoaded();
	    	 return valid.getText();
	    	
	    }
	
}

