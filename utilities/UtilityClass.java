package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass {

	public static long PAGELOAD_TIMEOUT = 20;
	public static long IMPLICITWAIT_TIMEOUT = 20;
	
	public static String getScreenshotName(String methodName) {
		Date d = new Date();
		String fileName = methodName + "_" + d.toString().replace(":", "_").replace(" ", "_") + ".png";
		return fileName;
	}
	
	public static String getReportName() {
		Date d = new Date();
		String fileName = "Test Report " + "-" + d.toString().replace(":", "-").replace(" ", "_") + ".html";
		return fileName;
	}
	
	public static String takeScreenshot(WebDriver driver, String methodName) {
		String fileName = getScreenshotName(methodName);
		String directory = System.getProperty("user.dir") + "/screenshotsFolder/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(screenshot, new File(path));
		} catch (Exception e) {
			System.out.println("Error encountered when attaching screenshot"+e.getMessage());
		}
		return path;
	}
	
	public void copyFile(String baseFileLocation, String copyFileLocation) {
		File baseFile = new File("C:\\Users\\Lenovo\\Desktop\\JavaProject\\AutomationFramework\\data\\datafile");
		baseFileLocation = System.getProperty("user.dir") + baseFile;
		//create a new folder with in the project directory
		copyFileLocation = System.getProperty("user.dir") + "/copiedFileFolder/";
		new File(copyFileLocation).mkdirs();
		
		File cloneFile = new File(copyFileLocation);
		
		FileInputStream fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		//provide location of the base file
		try {
			fileInputStream = new FileInputStream(baseFile);
			fileOutputStream = new FileOutputStream(cloneFile);

		} catch (FileNotFoundException e) {
			System.out.println("Error occured when copying file: "+e.getMessage());
		}
		
		int charactersInFile = 0;
		try {
			while((charactersInFile = fileInputStream.read()) !=-1) {
				fileOutputStream.write(charactersInFile);
			}
		}
		catch(Exception e) {
			System.out.println("Error when copying the file: "+e.getMessage());
		}
		
		finally {
			//close fileinput streams
			if(fileInputStream !=null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					System.out.println("Error occured when closing FileInputStream: "+e.getMessage());
				}
			}
			else if(fileOutputStream !=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					System.out.println("Error occured when closing FileOutputStream: "+e.getMessage());
				}
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
