package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> threadSafeDriver = new ThreadLocal<WebDriver>();

	private DriverManager() {
	}

	public static void initDriver() {
		if (threadSafeDriver.get() != null) {
			throw new RuntimeException("Driver is already initialized");
		}
		threadSafeDriver.set(DriverFactory.createDriver());
	}

	public static WebDriver getDriver() {
		WebDriver driver = threadSafeDriver.get();

		if (driver == null) {
			throw new RuntimeException("Driver is not initialized");
		}
		return driver;
	}

	public static void closeDriver() {
		WebDriver driver = threadSafeDriver.get();
		try {
			if (driver != null) {
				driver.quit();
			}
		} finally {
			threadSafeDriver.remove();
		}
	}
}
