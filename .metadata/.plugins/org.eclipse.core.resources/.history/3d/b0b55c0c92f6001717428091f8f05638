package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.FileUpload;

public class FileUploadTest extends Base_Test {
	
	public FileUpload fileload;
	
	@Test(priority=1)
	public void clickOnAddNewFile()
	{
		try
		{
		fileload =new FileUpload();
		fileload.addNewFile();
		Thread.sleep(3000);
		String txt= fileload.Validate();
		Assert.assertEquals(txt, "Upload a new file");
		System.out.println(txt);
		}
		catch(Exception e)
		{
			System.out.println("File is not uploaded" +e);
		}
		
	}
	
	@Test(priority=2,dependsOnMethods={"clickOnAddNewFile"})
	public void enterFileLocation()
	{
		try
		{
		fileload.upLoadFile(prop.getProperty("File_po"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*@Test(priority=3,dependsOnMethods={"enterFileLocation"})
	public void clickOnProcess()
	{
		fileload.process();
	}*/
	
	@Test(priority=3,dependsOnMethods={"enterFileLocation"})
	public void selectFileType()
 
	{
		try
		{
		fileload.fileSelectionPop();
		Thread.sleep(2000);
		fileload.process();
		refresh();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

