package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver createDriver() {
		WebDriver driver;
		String Browser = System.getProperty("browser", "chrome");
		boolean isHeadless = true;

		try {

			switch (Browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeoptions = new ChromeOptions();
				if (isHeadless) {
					chromeoptions.addArguments("--headless=new");
				}

				driver = new ChromeDriver(chromeoptions);
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxoptions = new FirefoxOptions();
				if (isHeadless) {
					firefoxoptions.addArguments("--headless=new");
				}
				driver = new FirefoxDriver(firefoxoptions);
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				EdgeOptions edgeoptions = new EdgeOptions();
				if (isHeadless) {
					edgeoptions.addArguments("--headless=new");
				}
				driver = new EdgeDriver(edgeoptions);
				break;
			default:
				throw new RuntimeException("Browser is not available" + Browser);

			}
			return driver;

		} catch (Exception e) {
			throw new RuntimeException("Failed to create WebDriver for browser: " + Browser, e);
		}

	}

}
