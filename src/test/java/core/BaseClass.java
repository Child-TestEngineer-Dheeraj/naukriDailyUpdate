package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		DriverManager.initDriver();
		driver = DriverManager.getDriver();
		System.out.println("Created ChromeDriver");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Opened Browser");
		
		System.out.println("Opened amazon");
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void teardown() {
		DriverManager.closeDriver();
	}

}
