package core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	protected static WebDriver driver;

	@BeforeTest
	public void setup() {
		WebDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.naukri.com");
	}

	@Test(priority = 1)
	public void Login() {
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("//form[@class='form']/descendant::input[@type='text']"))
				.sendKeys("draj.shet45@gmail.com");
		driver.findElement(By.xpath("//form[@class='form']/descendant::input[@type='password']")).sendKeys("Draj@007");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']/div"))));	
	}
	
	@Test(priority = 2)
	public void UploadResume() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']/div")).click();
		driver.findElement(By.linkText("View & Update Profile")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Credits"))));
		driver.findElement(By.xpath("//div[@class='action']/descendant::input[@type='file' and @id='attachCV']")).sendKeys("C:\\Users\\dheer\\Desktop\\Resume\\DheerajShet_QA_Automation_4.5YoE.docx");
	   Thread.sleep(5000);	
	}
	
	
	@Test(priority = 3)
	public void Logout() {
		driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__icon']/div")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
