package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class PlaceOrderPage extends AbstarctComponents {
    WebDriver driver;
	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(className ="hero-primary" )
	WebElement conformMsg;

public String conformMsgDisplay() throws InterruptedException
{
   String text = conformMsg.getText();
   return text;
}

public Boolean validationTest(String text) throws InterruptedException
{
	Boolean exp = conformMsgDisplay().equalsIgnoreCase(text);
	Thread.sleep(2000);
	return exp;
}
	

}
