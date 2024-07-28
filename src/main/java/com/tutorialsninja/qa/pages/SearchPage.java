package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	@FindBy(name = "search")
	private WebElement searchValidProduct;
	
	@FindBy(xpath = "//span[@class='input-group-btn']")
	private WebElement clickOnValidSearch;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement varifySearch;
	
	@FindBy(name = "search")
	private WebElement searchInValidProduct;
	
	@FindBy(xpath = "//span[@class='input-group-btn']")
	private WebElement clickOnInValidSearch;
	
	@FindBy(xpath = "//input[@id='button-search']/following-sibling::p")
	private WebElement varifyInValidSearch;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void validSearch() {
		searchValidProduct.sendKeys("HP");
	}
	public void validSearchClick() {
		clickOnValidSearch.click();
	}
	public boolean verifySearchText() {
		boolean verificcationOfValidSearch = varifySearch.isDisplayed();
		return verificcationOfValidSearch;
	}
	
	public void InvalidSearchClick() {
		searchInValidProduct.sendKeys("Honda");
	}
	
	public void InvalidSearchClicks() {
		clickOnInValidSearch.click();
	}
	public boolean InverifySearchText() {
		boolean displayInvalidData = varifyInValidSearch.isDisplayed();
		return displayInvalidData;
	}
	
	
}
