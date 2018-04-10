package com.pages.product;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.product.Base_Test;

public class FileUpload extends Base_Test{
	
	@FindBy(xpath="//a[contains(text(),'Add New File')]")    // To upload the file
	 WebElement btn_addNewFile;
	
	@FindBy(xpath="//div[contains(@class,'modal-body step-1')]/div[1]")    // To upload the file
	 WebElement btn_dropNewFile;
	
	public FileUpload()
	{
     PageFactory.initElements(driver, this);
	}
	
	public void addNewFile()
	{
		btn_addNewFile.click();
		btn_dropNewFile.click();
	}
	
	public void uploadFile()
	{
		
	}
}
