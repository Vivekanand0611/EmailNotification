package com.ecom.qa.standalone;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecom.qa.basetest.BaseTest;
import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.ProductCatalog;

public class ErrorValidationTest extends BaseTest {
	@Test(groups = {"ErrorHandling"})
	public void errorValidationTest() throws IOException, InterruptedException {
		
		
		landingPage.loginPage("vivek93royal@gmail.com", "Vivek@240");
		landingPage.msgDisplay();
		
		Assert.assertEquals(landingPage.msgDisplay(),"Incorrect email or password." );
		
		
		
	}
	@Test(groups = {"ErrorHandling"})
	public void productError() throws InterruptedException
	{
		String name ="ZARA COAT 3";
		ProductCatalog prodCatalog = landingPage.loginPage("rishu240@gmail.com", "Rishu@240");
		prodCatalog.addProductToCart(name);
		//prodCatalog.getProductList();
		prodCatalog.getProductName(name);
		CartPage page = new CartPage(driver);
		Boolean productMatch = page.isMatch("zara");
		Assert.assertFalse(productMatch);
	}

}
