package com.testcase;

import org.testng.annotations.Test;

import com.pages.product.Reviewer;


public class ReviewerTest {
	
	public Reviewer reviewer;
	
	@Test(priority=1)
	public void reviewerDoLogin() throws Exception
	{
		reviewer =new Reviewer();
		reviewer.login("test.reviewer@devnagri.com", "secret");
	}
	
	@Test(priority=2)

	public void  doSelectReviewerProject()
	{
		reviewer.assignProject();
	}
	
	@Test(priority=3)
	public void automatedTranslation() throws Exception
	{
		reviewer.automatedTranslationUpDown();
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
	public void doClickOnLogo()
	{
		reviewer.clickDeva();
	}
	
	@Test(priority=7)
	public void doTranslatorLogout() throws InterruptedException
	{
		reviewer.reviewerLogout();
	}

}
