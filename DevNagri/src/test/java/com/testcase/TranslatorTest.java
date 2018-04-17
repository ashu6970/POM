package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.main.product.Base_Test;
import com.pages.product.Translator;

public class TranslatorTest extends Base_Test{
	
	public Translator translator;
	@Test(priority=1)
	public void translatorDoLogin() throws Exception
	{
		translator =new Translator();
		translator.login("test.translator@devnagri.com", "secret");
		Assert.assertEquals(translator.validTranslatorPage(), "Earnings");
	}
	
	@Test(priority=2)
	public void  doSelectTranslatorProject() throws Exception
	{
		translator.assignProject();
		Assert.assertEquals(translator.validAssignProject(), "Project Description");
	}
	
	@Test(priority=3)
	public void automatedTranslation() throws Exception
	{
		translator.automatedTranslationUpDown();
		Assert.assertEquals(translator.validAutomatedUpDown(), "Save & Next");
		
	}
	
	@Test(priority=4)
	public void doselectWordsAndEnterText() throws Throwable
	{
		translator.clickOnWord();
	}
	
	@Test(priority=5, dependsOnMethods = { "doselectWordsAndEnterText" })
	public void docompleteTranslation() throws Throwable
	{
		translator.completeTranslation();
		Assert.assertEquals(translator.validCompleteTranslation(), "completed");	
	}
	
	@Test(priority=6,dependsOnMethods = { "docompleteTranslation" } )
	public void doClickOnLogo()
	{
		translator.clickDeva();
	}
	
	@Test(priority=7)
	public void doTranslatorLogout() throws InterruptedException
	{
		translator.translatorLogout();
	}
	
	
}

