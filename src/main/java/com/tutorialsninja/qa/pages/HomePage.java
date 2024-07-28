package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	WebDriver driver;
	
	
	//Object Start
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registrationOption;
	//Object Ends
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void	clickOnAccount() {
		myAccountDropMenu.click();
	}
	public void selectLoginOption() {
		loginOption.click();
	}
	public void selectRegistrationOption() {
		registrationOption.click();
	}
}
