package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initialBrowserAndOpenApplicationURL(prop.getProperty("browser"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void searchWithValidProduct() {
		SearchPage searchPage = new SearchPage(driver);
		searchPage.validSearch();
		searchPage.validSearchClick();
		searchPage.verifySearchText();
	}

	@Test(priority = 2)
	public void searchWithInvalidProduct() {

		SearchPage searchPage = new SearchPage(driver);

		searchPage.InvalidSearchClick();
		searchPage.InvalidSearchClicks();
		searchPage.InverifySearchText();

	}
}
