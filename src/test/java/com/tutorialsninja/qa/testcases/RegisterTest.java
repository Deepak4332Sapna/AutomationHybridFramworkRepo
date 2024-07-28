package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegistrationPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {

	public WebDriver driver;

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initialBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAccount();
		homePage.selectRegistrationOption();
	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMendatoryFields() {
		RegistrationPage registrationPage = new RegistrationPage(driver);

		registrationPage.validFirstName();
		registrationPage.validlastName();
		registrationPage.validEmailName("Deepak\" + Utilities.generateEmilWithTimeStamp() + \"@gmail.com");
		registrationPage.validTelephone();
		registrationPage.validPassword();
		registrationPage.validConfirm();
		registrationPage.validAgreeField();
		registrationPage.validContinue();
		registrationPage.sccessMessageShowing();

	}

	@Test(priority = 2)
	public void verifyRegisteringAccountWithoutFillingAnyDetails() {

		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.validContinue();
		registrationPage.firstNameErrorMessage();
		registrationPage.lastNameErrorMessage();
		registrationPage.emailErrorMessage();
		registrationPage.phoneErrorMessage();
		registrationPage.passwordWarningErrorMessage();
	}

}
