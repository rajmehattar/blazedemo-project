package com.blazedemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.blazedemo.pages.HomePage;

import base.BaseTest;

public class SmokeTest extends BaseTest {

	// TC01 - Verify homepage loads and dropdowns visible
	@Test
	public void TC01_verifyHomepageLoads() {

		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.isDropdownVisible());
	}

}
