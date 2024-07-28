package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailAddressField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement clickButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement emailPasswordNotMatchingwarning;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void emailFieldSetup(String emailText){
		emailAddressField.sendKeys(emailText);
	}
	public void passwordFieldSetup(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public void loginButtonClick() {
		clickButton.click();
	}
	
	public boolean emailpasswordWarningMessage() {
		boolean messageShowing = emailPasswordNotMatchingwarning.isDisplayed();
		return messageShowing;
	}
}
