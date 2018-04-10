package com.testcase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.MakeOrder;

public class MakeOrderTest extends Base_Test {
	public MakeOrder makeorder;
	
	@Test(priority=1)
	public void clickOnMakeOrder()
	{
		makeorder=new MakeOrder();
		makeorder.makeAnOrder();	
	}
	 
	@Test(priority=2)
	public void clickOnTagetLanguage()
	{
		makeorder.targetLanguage();	
	}
	
	@Test(priority=3)
	public void clickOnSubmit()
	{
		makeorder.submit();
		String txt=makeorder.Validate();
		Assert.assertEquals(txt, "Place Order Now");
		System.out.println(txt);
	}
	
    @Test(priority=4)
	public void clickOnPlaceOrderNow()
	{
    	makeorder.placeAnOrder();
    	}

}
