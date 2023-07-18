package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class ProductCatalog extends AbstarctComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> productList;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	//By prodWait = By.xpath("//*[contains(@class,'mb-3' )]");
	By prodWait = By.cssSelector(".mb-3");
	//By addCart = By.xpath("//*[@class='card-body']//button[contains(@class,'w-10')]");
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By toastValidation = By.id("toast-container");
	By prodNames = By.cssSelector("b");

	
	  public List<WebElement> getProductList() {
		  waitTillElementAppear(prodWait);
	  return productList; 
	  }
	 

	public WebElement getProductName(String name) {
		WebElement prodName = getProductList().stream()
				.filter(product -> product.findElement(prodNames).getText().equalsIgnoreCase(name)).findFirst()
				.orElse(null);
		return prodName;
	}
	
	public void addProductToCart(String name) throws InterruptedException
	{
		WebElement prod = getProductName(name);
		prod.findElement(addCart).click();
		waitTillElementAppear(toastValidation);
		waitTillElementDisappear(spinner);
		
	}
}
