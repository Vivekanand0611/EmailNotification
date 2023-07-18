package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class CartPage extends AbstarctComponents {
	//Cart Program
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[@class='cartSection']//h3")
	List<WebElement> cartProduct;
	@FindBy(xpath ="//*[@class='totalRow']//button")
	WebElement checkOutButton;
	
    
	public Boolean isMatch(String name) throws InterruptedException
	{
		
		Boolean productMatch = cartProduct.stream().anyMatch(cart->cart.getText().equalsIgnoreCase(name));
		return productMatch;
	}
	public CheckOutPage clickCheckOut()
	{
		checkOutButton.click();
		
		return new CheckOutPage(driver);
	}
}
