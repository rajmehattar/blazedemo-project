package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.HomePage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;

import base.BaseTest;

public class FunctionalTests extends BaseTest {

	// TC02 - Search flights with valid cities
	@Test
	public void TC02_searchFlights() {

		HomePage home = new HomePage(driver);
		home.selectCities("Paris", "Berlin");
		home.searchFlights();

		ReservePage reserve = new ReservePage(driver);
		Assert.assertTrue(reserve.isReserveFlightPageDisplayed());

	}

	// TC03 - Complete a flight booking
	@Test
	public void TC03_completeFlightBooking() {

		// Select destination city, departure city and proceed to check flights
		HomePage home = new HomePage(driver);
		home.selectCities("Boston", "New York");
		home.searchFlights();

		// Choose flight
		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		// Enter passenger details and proceed
		PurchasePage purchase = new PurchasePage(driver);
		purchase.enterPassengerDetails("Tony Stark", "250 Stark Tower", "New York", "New York State", "413000",
				"5111111111");
		purchase.purchaseFlight();

		// Check if booking is confirmed
		ConfirmationPage confirm = new ConfirmationPage(driver);
		Assert.assertTrue(confirm.isBookingConfirmed());

	}

}
