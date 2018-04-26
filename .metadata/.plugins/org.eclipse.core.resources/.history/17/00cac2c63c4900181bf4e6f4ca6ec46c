package com.testcase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.product.Base_Test;
import com.pages.product.MakeOrder;

public class MakeOrderTest extends Base_Test {
	public MakeOrder makeorder;
	
	@Test(priority=1)
	public void doTheOrder() throws Exception
	{
		makeorder=new MakeOrder();
		Assert.assertEquals(makeorder.validationOrder(),"Professional Translation");
		System.out.println(makeorder.validationOrder());
		makeorder.makeAndPayment();
		Thread.sleep(20000);
	} 
	
	@Test(priority=2)
	
	public void clientLogout() throws InterruptedException
	{
		makeorder.clientlogout();
	}

}
