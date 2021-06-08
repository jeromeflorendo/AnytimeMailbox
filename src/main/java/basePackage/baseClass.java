package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.UtilityClass;

public class baseClass {
	
	public static WebDriver driver;
	public static Properties pro;

	public baseClass() {
		try {
			pro = new Properties();
			File src = new File("./Config/config.property");
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Error when loading config.properties files" + e.getMessage());
		}

	}
	
	public static void startApplication() {
		String browserName = pro.getProperty("Browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser selected not found");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(UtilityClass.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(UtilityClass.IMPLICITWAIT_TIMEOUT, TimeUnit.SECONDS);

		// default URL is defined in the config.property under Config Folder
		driver.get(pro.getProperty("URL"));

	}
	
	@BeforeMethod
	public void setUp() {
		startApplication();
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

	
	
	
	
	
	
	
	
	
}
