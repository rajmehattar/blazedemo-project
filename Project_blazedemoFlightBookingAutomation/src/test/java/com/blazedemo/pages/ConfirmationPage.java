package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	private WebDriver driver;
	
	private By confirmationMsg = By.tagName("h1");
	
	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean isBookingConfirmed() {
		
		return driver.findElement(confirmationMsg).getText().contains("Thank you");
	}

}
