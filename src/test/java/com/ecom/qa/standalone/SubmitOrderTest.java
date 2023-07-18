package com.ecom.qa.standalone;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecom.qa.basetest.BaseTest;
import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.CheckOutPage;
import com.ecom.qa.pages.OrderPage;
import com.ecom.qa.pages.PlaceOrderPage;
import com.ecom.qa.pages.ProductCatalog;

public class SubmitOrderTest extends BaseTest {
	@Test(dataProvider = "getData",groups = {"PurchageProduct"})
	public void submitTest(HashMap<String, String> input) throws IOException, InterruptedException {
		
		String countryName ="India";
		String text ="THANKYOU FOR THE ORDER.";
		ProductCatalog prodCatalog = landingPage.loginPage(input.get("email"), input.get("password"));
		prodCatalog.getProductList();
		//Add Cart
		prodCatalog.addProductToCart(input.get("productName"));
		//Using Explicit Wait
		//Display all product which add into cart
		//Validation add product in cart page.	
		CartPage cartPage = prodCatalog.goToCartPage();
		Boolean productMatch = cartPage.isMatch(input.get("productName"));
		Assert.assertTrue(productMatch);
		CheckOutPage checkOutPage =cartPage.clickCheckOut();
		checkOutPage.selectCountry(countryName);
		PlaceOrderPage Orderpage = checkOutPage.placeProductOrder();
		//Thread.sleep(5000);
		Orderpage.conformMsgDisplay();
	    Boolean exp	= Orderpage.validationTest(text);
		Assert.assertTrue(exp);
		
		
	}
	@Test(dependsOnMethods = {"submitTest"})
	public void OrderProductTest() throws InterruptedException
	{
	String name ="IPHONE 13 PRO";
		ProductCatalog prodCatalog = landingPage.loginPage("vivek93royal@gmail.com", "Vivek@2400");
		OrderPage orderPage = prodCatalog.orderProducts();
		Boolean matchProductName = orderPage.isMatch(name);
		Assert.assertTrue(matchProductName);
	}
	
	
	/*
	 * @DataProvider public Object[][] getData() { return new Object[][]
	 * {{"vivek93royal@gmail.com","Vivek@2400","IPHONE 13 PRO"},{
	 * "rishu240@gmail.com", "Rishu@240","ADIDAS ORIGINAL"}}; }
	 */
	/*
	 * @DataProvider public Object[][] getData() { HashMap<String, String> data1 =
	 * new HashMap<String,String>(); data1.put("email", "vivek93royal@gmail.com");
	 * data1.put("password", "Vivek@2400"); data1.put("productName", "ZARA COAT 3");
	 * 
	 * HashMap<String, String> data2 = new HashMap<String,String>();
	 * data2.put("email", "rishu240@gmail.com"); data2.put("password", "Rishu@240");
	 * data2.put("productName", "ADIDAS ORIGINAL");
	 * 
	 * return new Object[][] {{data1},{data2}}; }
	 */
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		System.out.println(System.getProperty("user.dir") + "/src/test/java/com/ecom/qa/fileUtils/productData.json");
		//DataReader reader = new DataReader();
		List<HashMap<String, String>> jsonToMap =getJsonToMap(System.getProperty("user.dir") + "/src/test/java/com/ecom/qa/data/productData.json");
		//List<HashMap<String, String>> jsonToMap = getJsonToMap(
		//		System.getProperty("user.dir" + "/src/test/java/com/ecom/qa/fileUtils/productData.json"));
		return new Object[][] { { jsonToMap.get(0) }, { jsonToMap.get(1) } };
	}
	
}
