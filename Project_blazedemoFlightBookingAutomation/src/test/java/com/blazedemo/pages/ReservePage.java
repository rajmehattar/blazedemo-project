package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservePage {
	
	private WebDriver driver;
	
	private By chooseFlightButton = By.cssSelector("input[type='submit']");
	
	public ReservePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean isReserveFlightPageDisplayed() {
		
		return driver.getTitle().contains("reserve");
	}
	
	public void chooseFlight() {
		
		driver.findElement(chooseFlightButton).click();
	}

}
