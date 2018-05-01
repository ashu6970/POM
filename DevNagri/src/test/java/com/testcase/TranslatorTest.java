package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.main.product.Base_Test;
import com.pages.product.Translator;

public class TranslatorTest extends Base_Test{
	
	public Translator translator;
	
	/**
	 * Verify the functionality of the translator login.
	 * @throws Exception
	 */
	@Test(priority=1)
	public void translatorDoLogin() throws Exception
	{
		translator =new Translator();
		translator.login("test.translator@devnagri.com", "secret");
		Assert.assertEquals(translator.validTranslatorPage(), "Earnings");
	}
	
	/**
	 * Verify the functionality of the assign the project.
	 * @throws Exception
	 */
	@Test(priority=2)
	public void  doSelectTranslatorProject() throws Exception
	{
		translator.assignProject();
		Assert.assertEquals(translator.validAssignProject(), "Project Description");
	}
	
	/**
	 * Verify the functionality of automated translation button.
	 * @throws Exception
	 */
	@Test(priority=3)
	public void automatedTranslation() throws Exception
	{
		translator.automatedTranslationUpDown();
		Assert.assertEquals(translator.validAutomatedUpDown(), "Save & Next");
		
	}
	
	/**
	 * Verify the functionality of select all the words and do translator all of them.
	 * @throws Throwable
	 */
	@Test(priority=4)
	public void doselectWordsAndEnterText() throws Throwable
	{
		translator.clickOnWord();
	}
	
	/**
	 * Verify the functionality of the complete button.
	 * @throws Throwable
	 */
	@Test(priority=5, dependsOnMethods = { "doselectWordsAndEnterText" })
	public void docompleteTranslation() throws Throwable
	{
		translator.completeTranslation();
		Assert.assertEquals(translator.validCompleteTranslation(), "completed");	
	}
	
	/**
	 * Used for click on devnagri logo.
	 * @throws InterruptedException
	 */
	@Test(priority=6,dependsOnMethods = { "docompleteTranslation" } )
	public void doClickOnLogo() throws InterruptedException
	{
		translator.clickDeva();
	}
	
	/**
	 * Verify the functionality of the translator logout.
	 * @throws InterruptedException
	 */
	@Test(priority=7)
	public void doTranslatorLogout() throws InterruptedException
	{
		translator.translatorLogout();
	}
	
	
}


