package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import core.BaseClass;

public class Testtest extends BaseClass {

	@Test(priority = 4)
	public void test4() {
		driver.get("https://www.myntra.com/");
		String title=driver.getTitle();
		System.out.println("Test4:"+title);
		Assert.assertEquals(title, driver.getTitle());
	}

	@Test(priority = 5)
	public void test5() {
		driver.get("https://www.myntra.com/shop/men");
		String title=driver.getTitle();
		System.out.println("Test5:"+title);
		Assert.assertEquals(title, driver.getTitle());
	}

	@Test(priority = 3)
	public void test3() {
		driver.get("https://www.myntra.com/shop/women");
		String title=driver.getTitle();
		System.out.println("Test3:"+title);
		Assert.assertEquals(title, driver.getTitle());
	
	}

	@Test(priority = 6)
	public void test6() {
		driver.get("https://www.myntra.com/shop/kids");
		String title=driver.getTitle();
		System.out.println("Test6:"+title);
		Assert.assertEquals(title, driver.getTitle());
	}

}
