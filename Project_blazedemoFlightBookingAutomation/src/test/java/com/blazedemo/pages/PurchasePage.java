package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PurchasePage {

	private WebDriver driver;

	private By name = By.id("inputName");
	private By addr = By.id("address");
	private By addcity = By.id("city");
	private By addstate = By.id("state");
	private By addzipcode = By.id("zipCode");
	private By addcardNumber = By.id("creditCardNumber");
	private By purchaseButton = By.cssSelector("input[type='submit']");

	public PurchasePage(WebDriver driver) {

		this.driver = driver;
	}

	public void enterPassengerDetails(String fullname, String address, String city, String state, String zipcode,
			String cardnumber) {

		driver.findElement(name).sendKeys(fullname);
		driver.findElement(addr).sendKeys(address);
		driver.findElement(addcity).sendKeys(city);
		driver.findElement(addstate).sendKeys(state);
		driver.findElement(addzipcode).sendKeys(zipcode);
		driver.findElement(addcardNumber).sendKeys(cardnumber);

	}

	public void purchaseFlight() {

		driver.findElement(purchaseButton).click();
	}

}
