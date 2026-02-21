package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.pages.ConfirmationPage;
import com.blazedemo.pages.HomePage;
import com.blazedemo.pages.PurchasePage;
import com.blazedemo.pages.ReservePage;
import com.blazedemo.utils.TestDataProvider;

import base.BaseTest;

public class DataDrivenTest extends BaseTest {

	// TC04 - Multiple bookings with different data sets
	@Test(dataProvider = "bookingData", dataProviderClass = TestDataProvider.class)
	public void TC04_multipleBookings(String from, String to, String fullname, String address, String city, String state,
			String zipcode, String cardnumber) {

		// Select destination city, departure city using DataProvider and proceed to
		// check flights
		HomePage home = new HomePage(driver);
		home.selectCities(from, to);
		home.searchFlights();

		// Choose flight
		ReservePage reserve = new ReservePage(driver);
		reserve.chooseFlight();

		// Enter passenger details using DataProvider and proceed
		PurchasePage purchase = new PurchasePage(driver);
		purchase.enterPassengerDetails(fullname, address, city, state, zipcode, cardnumber);
		purchase.purchaseFlight();

		// Check if booking is confirmed
		ConfirmationPage confirm = new ConfirmationPage(driver);
		Assert.assertTrue(confirm.isBookingConfirmed());

	}

}
