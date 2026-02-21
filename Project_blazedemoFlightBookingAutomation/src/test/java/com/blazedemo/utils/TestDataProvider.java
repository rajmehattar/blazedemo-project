package com.blazedemo.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider(name = "bookingData")
	public Object[][] bookingData(){
		return new Object[][] {
			{"Boston", "New York", "Tony Stark", "250 Stark Tower", "New York",
             "New York State", "413000", "5111111111"},
			{"Paris", "Berlin", "Steve Rogers", "125 Cape Town", "Cape Town",
              "Western State", "413005", "5222222222"}
		};
	}

}
