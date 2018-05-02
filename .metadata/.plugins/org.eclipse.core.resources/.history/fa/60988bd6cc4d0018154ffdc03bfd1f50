package com.testcase;



import java.util.List;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Lists;
import com.main.product.Base_Test;
import com.pages.product.ChooseTranslationPlan;
import com.pages.product.FileUpload;

public class FileUploadTest extends Base_Test {
	
	public FileUpload fileload;
	public ChooseTranslationPlan TranslationPlan;
	
	/**
	 * To perform click on the add new file button and
	 * verify the upload file pop should be display on the screen.
	 * @throws Exception 
	 */
	@Test(priority=1)
	public void clickOnAddNewFile() throws Exception
	{
		fileload =new FileUpload();
		fileload.addNewFile();

		
	}
	/*
	@Test(priority=2,groups="Negative")
	public void withoutSelectFileType() throws InterruptedException
	{
		
		fileload.upLoadFile(prop.getProperty("File_po"));
		fileload.process();
		String txt=fileload.validateErrorParsing();
		Assert.assertEquals(txt, "Error in parsing file");
		waitForPageLoaded();
	}
	
	@Test(priority=3,groups="Negative")
	public void incorrectFileFormat() throws Exception
	{
		// upload the Tiff file.
		try
		{
		fileload.addNewFile();
		fileload.upLoadFile(prop.getProperty("File_Tiff"));
		fileload.process();
		String txt=fileload.validateErrorParsing();
		Assert.assertEquals(txt, "Error in parsing file");
		waitForPageLoaded();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		// Upload zip file.
		
		fileload.addNewFile();
		fileload.upLoadFile(prop.getProperty("File_zip"));
		fileload.process();
		String txt=fileload.validateErrorParsing();
		Assert.assertEquals(txt, "Error in parsing file");
		waitForPageLoaded();
		
		// upload python file.
		
		fileload.addNewFile();
		fileload.upLoadFile(prop.getProperty("File_py"));
		fileload.process();
		String txt1=fileload.validateErrorParsing();
		Assert.assertEquals(txt1, "Error in parsing file");
		waitForPageLoaded();
			
	}
	*/
	
	/**
	 * This method used for enter the location of file using random object.
	 * @throws InterruptedException 
	 */
	@Test(priority=4)
	public void enterFileLocation() throws InterruptedException
	{
		String randomElement="";
	Random randomPath = new Random();
    List<String> givenList = Lists.newArrayList("/home/fourtek/Downloads/File Format/strings.po", "/home/fourtek/Downloads/File Format/strings.stringsdict");
    int numberOfElements = 1;
	 
    for (int i = 0; i < numberOfElements; i++) {
        int randomIndex = randomPath.nextInt(givenList.size());
         randomElement = givenList.get(randomIndex); 
        
    }
    
   fileload.upLoadFile(String.valueOf(randomElement));
   Thread.sleep(2000);
   Assert.assertEquals(fileload.forValidateFileFormat(), "Supported");
   System.out.println(fileload.forValidateFileFormat()); 
   Thread.sleep(3000);
		//fileload.upLoadFile(prop.getProperty("File_po"));
		
	}
	
	
	/**
	 * This method is used for select the file format.
	 */
	@Test(priority=5)
	public void selectFileFormat()
 
	{
		try
		{
		fileload.fileSelectionPop();
		Thread.sleep(2000);
		TranslationPlan=fileload.submit();	
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}

