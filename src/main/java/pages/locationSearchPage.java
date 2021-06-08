package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.baseClass;

public class locationSearchPage extends baseClass {
	
	 static WebDriverWait wait = new WebDriverWait(driver,30);

	 static WebElement findButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	 static WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lookup']")));
	
	public static void checkForValidLocation(String location) {
		searchField.sendKeys(location);
		findButton.click();
	}
	
	public static void checkForInvalidLocation(String invalidLocation) {
		searchField.sendKeys(invalidLocation);
		findButton.click();
	}
	
	
	
	
	
}
