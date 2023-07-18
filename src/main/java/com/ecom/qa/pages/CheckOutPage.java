package com.ecom.qa.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class CheckOutPage extends AbstarctComponents {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(xpath ="//*[@placeholder='Select Country']")
	WebElement countrySelect;
    @FindBy(xpath = "//*[contains(@class,'ta-item')]")
    List<WebElement> listCountry ;
    @FindBy(xpath = "//*[@class='actions']/a")
	WebElement placeOrder;
    public void selectCountry(String countryName)
    {
    	waitTillElementAppearUsingWebElement(countrySelect);
    	countrySelect.sendKeys("Ind");
       for (WebElement webElement : listCountry) {
			
			if(webElement.getText().equals(countryName))
			{
				waitTillElementToBeClickable(webElement);
				webElement.click();
				break;
			}
		}
    }
    
    public PlaceOrderPage placeProductOrder()
	{
		waitTillElementToBeClickable(placeOrder);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", placeOrder);
		
		return new PlaceOrderPage(driver);
	}
}
