package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.Reviewer;


public class ReviewerTest  extends Base_Test {
	
	public Reviewer reviewer;
	
	@Test(priority=1)
	public void reviewerDoLogin() throws Exception
	{
		reviewer =new Reviewer();
		reviewer.login("test.reviewer@devnagri.com", "secret");
		Assert.assertEquals(reviewer.vaidReviewerLogin(), "Translator Application");
	}
	
	@Test(priority=2)

	public void  doSelectReviewerProject() throws Exception
	{
		pageScrolldown();
		reviewer.assignProject();
		Assert.assertEquals(reviewer.validAssignProject(), "Project Description");
	}
	
	@Test(priority=3)
	public void automatedTranslation() throws Exception
	{
		reviewer.automatedTranslationUpDown();
		Assert.assertEquals(reviewer.validAutomatedUpDown(), "Save & Next");
	}
	
	@Test(priority=4)
	public void doAcceptWord() throws Throwable
	{
		reviewer.acceptTranslation();
	}
	
	@Test(priority=5, dependsOnMethods={"doAcceptWord"})
	public void doClickOnComplete() throws Throwable
	{
		reviewer.completeReviewer();
	}
	
	@Test(priority=6,dependsOnMethods={"doClickOnComplete"})
	public void doClickOnLogo() throws InterruptedException
	{
		reviewer.clickDeva();
	}
	
	@Test(priority=7)
	public void doTranslatorLogout() throws InterruptedException
	{
		reviewer.reviewerLogout();
	}

}
