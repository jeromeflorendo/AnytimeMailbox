package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import basePackage.baseClass;
import pages.locationSearchPage;

public class LocationTest extends baseClass{

	public LocationTest() {
		super();
	}
	
	locationSearchPage locationPages;
	
	@Test
	public void validLocationTest() {
		locationSearchPage.checkForValidLocation("New Jersey");
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("New Jersey"));
	}
	
	@Test
	public void invalidLocationTest() {
		locationSearchPage.checkForInvalidLocation("Taytay, Rizal");
		String pageTitle = driver.getTitle();
		Assert.assertFalse(pageTitle.contains("Taytay Rizal"));
	}
	
}
