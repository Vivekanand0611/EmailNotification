package com.ecom.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.qa.abstractcomponents.AbstarctComponents;

public class LandingPage extends AbstarctComponents {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "userEmail")
	WebElement userName;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement login;
	@FindBy(xpath ="//div[@aria-label='Incorrect email or password.']")
	WebElement errorValidation;
	
	public String msgDisplay() throws InterruptedException
	{
		waitTillElementAppearUsingWebElement(errorValidation);
		return errorValidation.getText();
	}
	//Perform action
	
	public ProductCatalog loginPage(String useName,String pwd)
	{
		userName.sendKeys(useName);
		password.sendKeys(pwd);
		login.click();
		return new ProductCatalog(driver);
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}

}
