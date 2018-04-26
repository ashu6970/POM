package com.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.ChooseTranslationPlan;
import com.pages.product.MakeOrder;

public class ChooseTranslationPlanTest extends Base_Test {

	public ChooseTranslationPlan TranslationPlan;
	public MakeOrder makeorder;
	/**
	 * Verify the functionality of choose plan button
	 *  Select the plan for Translation.
	 * @throws Exception 
	 */
	
	@Test(priority=1)
	public void choosePlanForTranslation() throws Exception
	{
		TranslationPlan=new ChooseTranslationPlan();
		Assert.assertEquals(TranslationPlan.fileUploadValidation(), "Congrats!");
		System.out.println(TranslationPlan.fileUploadValidation());
		TranslationPlan.choosePlan();
		Assert.assertEquals(TranslationPlan.forchooseplan(), "Choose Plan");
		System.out.println(TranslationPlan.forchooseplan());
	}
	
	/**
	 * Verify the funtionality of dashboard button.
	 */
	@Test(priority=2,enabled = false)
	public void goToDashboard()
	{
		TranslationPlan.dashBoard();
	}
	
	/**
	 * verify the functionality of process button.
	 * @throws Exception
	 */
	@Test(priority=3)
	public void selectTheBestPlan() throws Exception
	{
		
		makeorder=TranslationPlan.process();
	}
}
