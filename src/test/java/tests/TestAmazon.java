package tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import core.BaseClass;


public class TestAmazon extends BaseClass {

	@Test(priority = 1)
	public void scrollInfinite() throws InterruptedException {
		
		driver.get("https://www.amazon.in/");
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement ele = fluent
				.until(driver -> driver.findElement(By.xpath("//a[contains(normalize-space(text()),'Fashion')]")));
		Assert.assertTrue(ele.isDisplayed(), "Element not displayed");
		ele.click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		long scrollHeight = (long) js.executeScript("return document.documentElement.scrollHeight");

		while (true) {
			js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight)");
			Thread.sleep(2000);

			long newHeigth = (long) js.executeScript("return document.documentElement.scrollHeight");

			if (newHeigth == scrollHeight)
				break;
			scrollHeight = newHeigth;
		}
	}


}
