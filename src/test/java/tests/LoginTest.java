package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.baseClass;
import pages.loginPage;

public class LoginTest extends baseClass{

	loginPage lp;
	
	@BeforeMethod
	public void setUp() {
		startApplication();
	}
	
	@Test
	public void LogInTest() {
		loginPage.logInToApplication();
	}

	
}
