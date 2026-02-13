package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import core.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMyntra extends BaseClass {

	@Test(priority = 1)
	public void addItemsToWhislist() {
		driver.get("https://www.myntra.com/men-tshirts");
		// WebElement item=driver.findElement(By.xpath("//h4[contains(text(),'Men
		// Training or Gym T-shirt')]"));
		By item = By.xpath("//h4[contains(text(),'Men Training or Gym T-shirt')]");
		By whilist = By.xpath(
				"//h4[contains(text(),'Men Training or Gym T-shirt')]/ancestor::li//span[contains(normalize-space(text()),'wishlist')]");
		By login_button = By.xpath("//div[@class='welcome-header' and contains(normalize-space(.),'Login ')]");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		System.out.println("Waiting for item to locate");
		wait.until(ExpectedConditions.visibilityOfElementLocated(item));

		Actions act = new Actions(driver);
		System.out.println("Hovering on item");
		act.moveToElement(driver.findElement(item)).perform();

		System.out.println("Waiting for whilist to locate");
		wait.until(ExpectedConditions.elementToBeClickable(whilist)).click();

		System.out.println("Waiting for login_button to locate");
		wait.until(ExpectedConditions.visibilityOfElementLocated(login_button));
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertTrue(driver.findElement(login_button).isDisplayed(), "Your are not navigated to login page");

	}

	@Test(priority = 2)
	public void scrollCurrentPage() {
		driver.get("https://www.myntra.com/men-tshirts");
		By NextBtn = By.xpath("//li[@class='pagination-next' and contains(normalize-space(text()),'Next')]");
		WebElement nextbtn_ele = driver.findElement(NextBtn);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(NextBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextbtn_ele);

		By prevElem = By.cssSelector("li.pagination-prev");

		String classvalue = wait.until(ExpectedConditions.presenceOfElementLocated(prevElem)).getDomAttribute("class");
		// pagination-prev pagination-disabled
		Assert.assertTrue(classvalue.contains("pagination-prev pagination-disabled"),
				"Previous button should be disabled on Page 1");

		wait.until(ExpectedConditions.elementToBeClickable(NextBtn)).click();
	}

	@Test(priority = 4)
	public void test4() {
		Assert.assertTrue(false);
		System.out.println("Testing test4");
	}

	@Test(priority = 5)
	public void test5() {
		Assert.assertTrue(true);
		System.out.println("Testing test5");
	}

	@Test(priority = 3)
	public void test3() {
		Assert.assertTrue(true);
		System.out.println("Testing test3");
	}

	@Test(priority = 6)
	public void test6() {
		Assert.assertTrue(true);
		System.out.println("Testing test6");
	}

}
