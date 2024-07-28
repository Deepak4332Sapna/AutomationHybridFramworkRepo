package com.tutorialsninja.qa.pages;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameInputField;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameInputField;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailInputField;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneInputField;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordInputField;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmInputField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement agreeField;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueField;
	
	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement successMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement WarningMessageRegistration;
	
	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarning ;
	
	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement LastNameWarning;
	
	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement phoneWarning;
	
	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	public void validFirstName() {
		firstNameInputField.sendKeys("Deepak");
	}
	public void validlastName() {
		lastNameInputField.sendKeys("baria");
	}
	public void validEmailName(String password) {
		emailInputField.sendKeys(password);
	}
	public void validTelephone() {
		telephoneInputField.sendKeys("7089465079");
	}
	public void validPassword() {
		passwordInputField.sendKeys("12345678");
	}
	public void validConfirm() {
		confirmInputField.sendKeys("12345678");
	}
	public void validAgreeField() {
		agreeField.click();
	}
	public void validContinue() {
		continueField.click();
	}
	
	public boolean sccessMessageShowing() {
		boolean messageShowing = successMessage.isDisplayed();
		return messageShowing;
	}
	
	public boolean firstNameErrorMessage() {
		boolean messageShowingRegistration = WarningMessageRegistration.isDisplayed();
		return messageShowingRegistration;
	}
	
	public boolean lastNameErrorMessage() {
		boolean messageShowingFirstName = firstNameWarning.isDisplayed();
		return messageShowingFirstName;
	}
	public boolean emailErrorMessage() {
		boolean messageShowingLastName = LastNameWarning.isDisplayed();
		return messageShowingLastName;
	}
	public boolean telephoneErrorMessage() {
		boolean messageShowingEmail = emailWarning.isDisplayed();
		return messageShowingEmail;
	}
	public boolean phoneErrorMessage() {
		boolean messageShowingPhone = phoneWarning.isDisplayed();
		return messageShowingPhone;
	}
	public boolean passwordWarningErrorMessage() {
		boolean messageShowingPassword = passwordWarning.isDisplayed();
		return messageShowingPassword;
	}
	
}
