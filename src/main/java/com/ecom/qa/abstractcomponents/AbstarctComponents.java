package com.ecom.qa.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.qa.pages.CartPage;
import com.ecom.qa.pages.OrderPage;

public class AbstarctComponents {
	
	WebDriver driver;
	public AbstarctComponents(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="//*[contains(@routerlink,'cart')]")
	WebElement cartHeader;
	@FindBy(xpath ="//*[@routerlink='/dashboard/myorders']")
	WebElement orderProduct;
	public OrderPage orderProducts()
	{
		orderProduct.click();
		OrderPage order = new OrderPage(driver);
		return order;
	}
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cart = new CartPage(driver);
		return cart;
	}
	public void waitTillElementAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitTillElementAppearUsingWebElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitTillElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillElementDisappear(WebElement ele) throws InterruptedException {
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.invisibilityOf(ele));
		 */
		Thread.sleep(1000);
	}

}
