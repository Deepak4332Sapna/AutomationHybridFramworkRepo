package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initialBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnAccount();
		homePage.selectLoginOption();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "supplyTestData")
	public void verifyLoginWithValidCredentials(String email, String password) {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailFieldSetup(email);
		loginPage.passwordFieldSetup(password);
		loginPage.loginButtonClick();

		AccountPage acccountPage = new AccountPage(driver);
		Assert.assertTrue(acccountPage.verifyAccount());
	}

	@DataProvider
	public Object[][] supplyTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("loginSheet");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailFieldSetup("vivek1234" + Utilities.generateEmilWithTimeStamp() + "@gmail.com");
		loginPage.passwordFieldSetup("vivek123");
		loginPage.loginButtonClick();

		loginPage.emailpasswordWarningMessage();

	}

	@Test(priority = 3)
	public void verifyWithoutProvidingCredencials() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.loginButtonClick();

		loginPage.emailpasswordWarningMessage();

	}

}
