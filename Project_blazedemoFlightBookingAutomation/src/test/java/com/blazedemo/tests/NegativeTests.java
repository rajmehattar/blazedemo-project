package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.HomePage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;

import base.BaseTest;

public class NegativeTests extends BaseTest {

	// TC05 - Blank credit card
	@Test
	public void TC05_blankCreditCard() {

		// Select destination city, departure city and proceed to check flights
		HomePage home = new HomePage(driver);
		home.selectCities("Boston", "New York");
		home.searchFlights();

		// Choose flight
		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		// Enter passenger details except Credit card and proceed
		PurchasePage purchase = new PurchasePage(driver);
		purchase.enterPassengerDetails("Tony Stark", "250 Stark Tower", "New York", "New York State", "413000", "");
		purchase.purchaseFlight();

		// Check if booking is confirmed
		ConfirmationPage confirm = new ConfirmationPage(driver);
		Assert.assertFalse(confirm.isBookingConfirmed());
	}

	// TC06 - Invalid credit card characters
	@Test
	public void TC06_invalidCreditCardCharacters() {

		// Select destination city, departure city and proceed to check flights
		HomePage home = new HomePage(driver);
		home.selectCities("Boston", "New York");
		home.searchFlights();

		// Choose flight
		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		// Enter invalid Credit card characters and proceed
		PurchasePage purchase = new PurchasePage(driver);
		purchase.enterPassengerDetails("Tony Stark", "250 Stark Tower", "New York", "New York State", "413000",
				"abc@xyz");
		purchase.purchaseFlight();

		// Check if booking is confirmed
		ConfirmationPage confirm = new ConfirmationPage(driver);
		Assert.assertFalse(confirm.isBookingConfirmed());
	}

	// TC07 - Same departure and destination city
	@Test
	public void TC07_sameDepartureSameDestination() {

		// Select destination city, departure city and proceed to check flights
		HomePage home = new HomePage(driver);
		home.selectCities("Paris", "Paris");
		home.searchFlights();

		Assert.assertTrue(driver.getTitle().contains("BlazeDemo"));
	}

}
