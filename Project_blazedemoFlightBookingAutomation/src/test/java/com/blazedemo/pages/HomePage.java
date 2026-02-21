package com.blazedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	private WebDriver driver;
	
	private By fromCity = By.name("fromPort");
	private By toCity = By.name("toPort");
	private By findFlightsButton = By.cssSelector("input[type='Submit']");
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean isDropdownVisible() {
		
		return driver.findElement(fromCity).isDisplayed()
				&& driver.findElement(toCity).isDisplayed();
	}
	
	
	public void selectCities(String from, String to) {
		
		new Select(driver.findElement(fromCity)).selectByVisibleText(from);
		new Select(driver.findElement(toCity)).selectByVisibleText(to);
	}
	
	public void searchFlights() {
		
		driver.findElement(findFlightsButton).click();
	}
	

}
