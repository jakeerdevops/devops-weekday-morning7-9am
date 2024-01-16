package test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseValidation {
	
	String browser = "chrome";
	String url = "https://www.fb.com";
	
	public static WebDriver driver;
			
	@BeforeTest
	public void beforeTest() {
		//invoke the browser
		driver = new ChromeDriver();
		
		//open the url
		driver.get(url);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@Test
	public void urlValidation() {
		String expectedResult = "https://www.facebook.com/";
		String actualResult = driver.getCurrentUrl();
		
		Reporter.log("Expected Result = " + expectedResult);
		Reporter.log("Actual Result = " + actualResult);
		
		//compare the results
		assertTrue(actualResult.equals(expectedResult), "Mismatch in the results,");
	
	}

}
