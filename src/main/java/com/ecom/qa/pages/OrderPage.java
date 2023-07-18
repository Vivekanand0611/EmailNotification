package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class OrderPage extends AbstarctComponents {
	
	WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//tbody/tr/td[2]")
	List<WebElement> OrderProduct;
	public void displayOrderProduct()
	{
		orderProducts();
	}
    
	public Boolean isMatch(String name) throws InterruptedException
	{
		displayOrderProduct();
		//Thread.sleep(2000);
		Boolean productMatch = OrderProduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(name));
		return productMatch;
	}

}
